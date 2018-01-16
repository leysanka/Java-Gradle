package com.epam.training.java;

import java.util.*;

public class TestListsSpeed {

    private enum Operations {
        ADD, ADD_POSITION, GET, REMOVE, REMOVE_INDEX, SET
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
//        for (int i = 0; i<100; i++) {
            switch (op) {
                case GET:
                    for (int i = mid; i <= mid + 100 ; i++) {
                        list.get(i);
                    }
                    break;
                case ADD:
                    for (int i = 0; i < 100; i++) {
                        list.add("insert");
                    }
                    break;
                case ADD_POSITION:
                    for (int i = mid; i <= mid + 100 ; i++) {
                        list.add(i, "insert_middle");
                    }
                    // list.add(list.size()/2, "insert_middle");
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
//            }
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

    public static final void main(String[] args) {

//        String[] strings = createStringArray(1000000);

        String[] strings = new String[1_000_000];
        Arrays.fill(strings, 0,5_000, "hello");
        Arrays.fill(strings, 5_000, strings.length, "buy");
        System.out.println(strings[0] + " & " + strings[1_000_000-1]);

        List<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(strings));
        List<String> arrAsList = Arrays.asList(strings); // This is not changeable list
        List<String> linkedList = new LinkedList<>(Arrays.asList(strings));
        LinkedList<String> lnkList = new LinkedList<>(Arrays.asList(strings));

        long ab = System.currentTimeMillis();
        for (int i =0; i < strings.length; i++) {
            String tmp = "abc";
            strings[i] = tmp;
        }
        long bc = System.currentTimeMillis();
        System.out.println(bc-ab + " Array");
        System.out.println(strings[0] + " & " + strings[strings.length-1]);


        /**
         * Test get last and remove with ArrayList vs LinkedList
         *
         * */



        /**
         *
         * Test ensureCapacity and trimToSize()
         *
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

        /**
         * Test Lists Iteration speed
         * LinkedList is faster when updating/removing a sequential list of objects
         * */
        ListIterator<String> LstIt = lnkList.listIterator(lnkList.size());
        ListIterator<String> ArrLstIt = arrList.listIterator(arrList.size());

        long iterStart = System.currentTimeMillis();
        for (lnkList.size(); LstIt.previousIndex()>500000; LstIt.hasPrevious()) {
            LstIt.set(LstIt.previous().toUpperCase());
         /*   LstIt.previous();
            LstIt.remove();*/

        }
        long iterFinish = System.currentTimeMillis();
        System.out.println((iterFinish-iterStart) + " LnkList: " ); //+ lnkList.subList(0,5));

        long iterArrStart = System.currentTimeMillis();
        for (arrList.size(); ArrLstIt.previousIndex()>500000; ) {

            ArrLstIt.set(ArrLstIt.previous().toUpperCase());
             /*   ArrLstIt.previous();
                ArrLstIt.remove();*/
        }
        arrList.trimToSize();
        System.out.println(arrList.size());
        long iterArrFinish = System.currentTimeMillis();
        System.out.println((iterArrFinish-iterArrStart) + " ArrayList: "); // + arrList.subList(0,5));

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

        System.out.println("ArrayList Get middle index " + calcSpeedOfListOperations(arrList, Operations.GET));
        System.out.println("LinkedList Get middle index " + calcSpeedOfListOperations(lnkList, Operations.GET));

        System.out.println("ArrayList ADD value (in the end) " + calcSpeedOfListOperations(arrList, Operations.ADD));
        System.out.println("LinkedList ADD value (in the end) " + calcSpeedOfListOperations(lnkList, Operations.ADD));

        System.out.println("ArrayList ADD in the middle index " + calcSpeedOfListOperations(arrList, Operations.ADD_POSITION));
        System.out.println("LinkedList ADD in the middle index " + calcSpeedOfListOperations(lnkList, Operations.ADD_POSITION));

        System.out.println("ArrayList Remove middle value " + calcSpeedOfListOperations(arrList, Operations.REMOVE));
        System.out.println("LinkedList Remove middle value" + calcSpeedOfListOperations(lnkList, Operations.REMOVE));

        System.out.println("ArrayList Remove middle index " + calcSpeedOfListOperations(arrList, Operations.REMOVE_INDEX));
        System.out.println("LinkedList Remove middle index " + calcSpeedOfListOperations(lnkList, Operations.REMOVE_INDEX));

        System.out.println("ArrayList Set middle index " + calcSpeedOfListOperations(arrList, Operations.SET));
        System.out.println("LinkedList Set middle index " + calcSpeedOfListOperations(lnkList, Operations.SET));


    }
}

