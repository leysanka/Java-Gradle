package com.epam.training.java;

import java.lang.reflect.Field;
import java.util.*;

public class TestListsSpeed {

    private enum Operations {
        ADD, ADD_POSITION, GET, REMOVE, REMOVE_INDEX, ADD_POSITION_BEGIN, SET
    }


    public static String[] createStringArray(int ofSize) {
        String[] s = new String[ofSize];
        int i = 0;
        while (i < ofSize) {
            s[i] = "hello";
            i++;
        }
        return s;
    }

    private static long calcSpeedOfListOperations(List list, Operations op) {
        long currTime = System.currentTimeMillis();
        int mid = list.size() / 2;
        switch (op) {
            case GET:
                for (int i = mid; i <= mid + 100 ; i++) {
                    list.get(i);
                }
                break;
            case ADD:
                for (int i = 0; i < 1000; i++) {
                    list.add("insert");//добавляет в конец
                }
                break;
            case ADD_POSITION:
                for (int i = mid; i <= mid + 100 ; i++) {
                    list.add(i, "insert_middle"); //добавление в середину
                }
            case ADD_POSITION_BEGIN:
                for (int i = 0; i < 1000 ; i++) {
                    list.add(0, "insert_begin"); //добавление в середину
                }
                break;
            case REMOVE:
                for (int i = 0; i < 100; i++) {
                    list.remove("insert_middle");}
                break;
            case REMOVE_INDEX:
                for (int i = mid; i <= mid + 100 ; i++) {
                    list.remove(i);
                }
                break;
            case SET:
                for (int i = mid; i <= mid + 100 ; i++) {
                    list.set(i, "SETTer");}
                break;

        }
        long afterTime = System.currentTimeMillis();
        return afterTime-currTime;
    }

    private static long calcSpeedOfGetListMid(List list) {
        long currTime = System.currentTimeMillis();
        list.get(list.size()/2);
        long afterTime = System.currentTimeMillis();
        return afterTime-currTime;
    }
    private static void testSpeedWithListIterator(List<String> lnkList, String operation) {
        ListIterator<String> LstIt = lnkList.listIterator(lnkList.size());
        long iterStart = 0;
        long iterFinish = 0;

        switch (operation){
            case "Update(Set)" : {
                iterStart = System.currentTimeMillis();
                for (; LstIt.previousIndex()>500000;) {
                    LstIt.set(LstIt.previous().toUpperCase());
                }
                iterFinish = System.currentTimeMillis();
                break;
            }
            case "Remove" : {
                iterStart = System.currentTimeMillis();
                for (; LstIt.previousIndex()>500000;) {
                    LstIt.previous();
                    LstIt.remove();
                }
                iterFinish = System.currentTimeMillis();
                break;
            }
            case "Add" : {
                iterStart = System.currentTimeMillis(); //add 1000 elements from the end (in the order previous -new, prev-new), until size does not exceed specified
                for (; lnkList.size()<1001000; LstIt.hasPrevious()) {
                    LstIt.previous();
                    LstIt.add("ee");
                }
                iterFinish = System.currentTimeMillis();
                break;
            }
            case "Add middle" : {
                LstIt = lnkList.listIterator(lnkList.size()/2);
                int count = lnkList.size()/2 + 1000; //insert 1000 elements in the middle
                iterStart = System.currentTimeMillis();
                for (; LstIt.nextIndex()<= count; LstIt.hasNext()) {
                    LstIt.add("md");
                    LstIt.next();
                }
                iterFinish = System.currentTimeMillis();
                break;
            }
            case "Iterate" : {
                iterStart = System.currentTimeMillis(); //add 1000 elements from the end (in the order previous -new, prev-new), until size does not exceed specified
                for (; LstIt.previousIndex()>500000; LstIt.hasPrevious()) {
                    LstIt.previous();
                }
                iterFinish = System.currentTimeMillis();
                break;
            }
            default:{
                throw new RuntimeException("Unknown operation.");
            }
        }

        System.out.printf("%s ListIterator %s: %d\n", lnkList.getClass().getSimpleName(), operation, (iterFinish-iterStart));

    }
//Reflection
    static int getCapacity(ArrayList al) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(al)).length;
    }

    public static final void main(String[] args) throws Exception {
//        String[] strings = createStringArray(1000000);

        String[] strings = new String[1_000_000];
      /** ~ одинаково с заполнением массива через цикл for стока 89*/
        Arrays.fill(strings, 0,5_000, "hello");
        Arrays.fill(strings, 5_000, strings.length, "buy");

        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(strings));
        LinkedList<String> lnkList = new LinkedList<>(Arrays.asList(strings));

        List<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        List<String> arrAsList = Arrays.asList(strings); // This is not changeable list
        List<String> linkedList = new LinkedList<>(Arrays.asList(strings));

        System.out.println("ArrayList Get middle index " + calcSpeedOfListOperations(arrList, Operations.GET));
        System.out.println("LinkedList Get middle index " + calcSpeedOfListOperations(lnkList, Operations.GET));

        System.out.println("ArrayList ADD value (in the end) " + calcSpeedOfListOperations(arrList, Operations.ADD));
        System.out.println("LinkedList ADD value (in the end) " + calcSpeedOfListOperations(lnkList, Operations.ADD));

        System.out.println("ArrayList ADD value (in the begin) " + calcSpeedOfListOperations(arrList, Operations.ADD_POSITION_BEGIN));
        System.out.println("LinkedList ADD value (in the begin) " + calcSpeedOfListOperations(lnkList, Operations.ADD_POSITION_BEGIN));

        System.out.println("ArrayList ADD in the middle index " + calcSpeedOfListOperations(arrList, Operations.ADD_POSITION));
        System.out.println("LinkedList ADD in the middle index " + calcSpeedOfListOperations(lnkList, Operations.ADD_POSITION));

        System.out.println("ArrayList Remove middle value " + calcSpeedOfListOperations(arrList, Operations.REMOVE));
        System.out.println("LinkedList Remove middle value" + calcSpeedOfListOperations(lnkList, Operations.REMOVE));

        System.out.println("ArrayList Remove middle index " + calcSpeedOfListOperations(arrList, Operations.REMOVE_INDEX));
        System.out.println("LinkedList Remove middle index " + calcSpeedOfListOperations(lnkList, Operations.REMOVE_INDEX));

        System.out.println("ArrayList Set middle index " + calcSpeedOfListOperations(arrList, Operations.SET));
        System.out.println("LinkedList Set middle index " + calcSpeedOfListOperations(lnkList, Operations.SET));

        /**
         * Test Lists Iteration speed
         * LinkedList is faster when adding/updating a sequential list of objects
         * */
        arrList = new ArrayList<>(Arrays.asList(strings));
        lnkList = new LinkedList<>(Arrays.asList(strings));
        testSpeedWithListIterator(lnkList,"Iterate");
        testSpeedWithListIterator(arrList,"Iterate");
        testSpeedWithListIterator(lnkList,"Add"); //adds from the end of list till specified index in the middle
        testSpeedWithListIterator(arrList,"Add");
        testSpeedWithListIterator(lnkList,"Update(Set)");
        testSpeedWithListIterator(arrList,"Update(Set)");
        testSpeedWithListIterator(lnkList,"Remove");
        testSpeedWithListIterator(arrList,"Remove");
        testSpeedWithListIterator(lnkList,"Add middle"); //adds from the the middle 1000 elements
        testSpeedWithListIterator(arrList,"Add middle");
        System.out.println(arrList.size() + " " + arrList.indexOf("md") +" " + arrList.lastIndexOf("md"));
        System.out.println(lnkList.size() + " " + lnkList.indexOf("md") +" " + lnkList.lastIndexOf("md"));

        /** Need to use trimToSize for ArrayList!! */
        /*System.out.println(getCapacity(arrList));
        arrList.trimToSize();
        System.out.println(getCapacity(arrList));*/

        /** Test заполнение массива через цикл 12млс
         *
         long ab = System.currentTimeMillis();
          for (int i =0; i < strings.length; i++) {
              String tmp = "abc";
              strings[i] = tmp;
          }
          long bc = System.currentTimeMillis();
          System.out.println(bc-ab + " Array"); */

        /**
         * Test get last and remove with ArrayList vs LinkedList todo
         *
         * */

        /**
         *
         * Test ensureCapacity and trimToSize()
         *
         System.out.println(arrList.size() + " " + "size");
         arrList.ensureCapacity(1000000);
         arrList.add("abcd");
         arrList.add(1000,"abcd");
         System.out.println(arrList.size() + "" + "size");
         arrList.remove(1000);
         arrList.remove("abcd");
         System.out.println(arrList.size() + " " + "size");
         arrList.trimToSize();
         System.out.println(arrList.size() + " " + "size after Trim");
         System.out.println(arrList.get(1000) + " " + arrList.indexOf("abcd"));
         // arrAsList.add("abc"); Exception here!
         //        arrAsList.remove(10);
         arrList.addAll(linkedList);
         System.out.println(arrList.size());
         */


/*
//        Collections.rotate(lnkList,3);
//        Collections.shuffle(lnkList);
//        System.out.print(lnkList);
//        Iterator<String> It = lnkList.iterator();
          while(LstIt.hasPrevious()){
            String el = LstIt.previous().concat("a");
            LstIt.set(el);
        }
        System.out.println(lnkList); */

    }

}

