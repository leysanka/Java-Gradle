package com.epam.training.java;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;


public abstract class TestJava {
   public String test = "aa bb";


        public abstract int test();

    public static void main() {
        System.out.print("Б");
    }

    public static <T> T getSomething(T... a){
        return a[0];
    }

    public static void main(String[] args) throws ClassNotFoundException {

/*        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        sb.reverse();
        sb.trimToSize();
//        sb.ensureCapacity(Integer.MAX_VALUE);
//        sb.setLength(2);
        System.out.println("new length " + sb.length() + ", string " + sb.toString() + ", capactity " + sb.capacity());*/

       /* String st = "abd";
        st.replace("b", "d"); //not changed
        st = st.replace("b", "d"); //changed
        System.out.println(st);*/

       /* Boolean bl = new Boolean(null);
        System.out.println(bl);*/
       /* main();*/
/*        int var = 1;
        System.out.println("Переменная var (постфиксный инкремент): " + var++);
        System.out.println("Переменная var (префиксный инкремент): " + ++var);
        System.out.println(var);
        int var1 = 1;
        int var2 = 1;
        if (var1++ == ++var2){  //2
            System.out.println("Переменные равны");}
        else{
            System.out.println("Переменные не равны");
    }*/


    big_loop:
        for (int i = 0; i < 3 ; i++) {
            try {
                for (int j = 0; j < 3 ; j++) {
                    if (i == j) continue;
                    else if (i > j) continue big_loop;
                    System.out.print("A");
                }
            } finally {
                System.out.print("B");
            }
            System.out.print("C");
        }

        /**/
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        System.out.println(i1 == -128);
        System.out.println(i1.hashCode() + " + " + i2.hashCode());
        System.out.println(System.identityHashCode(i1)); //не переопределенный native hashcode
        System.out.println(System.identityHashCode(i2));

        String s1 = "ab";
        String s2 = "ab";
        System.out.println(s1 == s2);
        System.out.println(s1 == "ab");
       /* TestClass2 testClass2 = new TestClass2();
        TestClass2.setHello(6);
        System.out.println(TestClass2.hello);*/

       // List<Integer> list = Arrays.asList(1, 5, 7, 9);
     /*   List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1, 2, 3 );

        Iterator it = list.iterator();
        if (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println(list.toString());*/

        /*list.forEach(item -> System.out.println(item));
        int array[] = {1, 3, 5};

        System.out.println(Array.getLength(array));
        for (int item :
                array) {
            System.out.println("Array it:" + item);
        }

        ArrayList arraylistobject = new ArrayList<>();
        arraylistobject.add(1);
        arraylistobject.add("123");
        arraylistobject.add(123.35);
        System.out.println("ArraylistObject" + arraylistobject.toString());
        arraylistobject.forEach( item -> System.out.println(item));
*/

   /*     LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(list);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.offerFirst(4));
        System.out.println(linkedList.getFirst());
        System.out.println("Peak" + linkedList.removeFirst());
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        linkedList.spliterator().forEachRemaining(o-> System.out.print(o));*/

        /*Iterable<Integer> listIter = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        listIter.forEach(o-> System.out.println(o));
        Collection<Integer> listColl = new ArrayList<>(Arrays.asList(1, 2, 3, 4));*/

      /*  List<String> listStr = Arrays.asList("a", "b", "c", "c");
        Set<String> uniqueSet = new HashSet<>();
        uniqueSet.addAll(listStr);
        uniqueSet.add("a");
        uniqueSet.forEach(o-> System.out.println(o));
*/
      /*  int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);*/

/*        String a = "quadratic", b = "complexity";
        boolean hasSame = false;
        outer:
        for (int i = 0; i < a.length(); ++i) {
            for (int j = 0; j < b.length(); ++j) {
                if (a.charAt(i) == b.charAt(j)) {
                    hasSame = true;
                    break outer;
                }
            }
        }
        System.out.println("Same " + hasSame);*/

 /*       int a =1;
        double b =2;
        long с = a+b;

        long d =1;
        int e =2;
        double f = d+e;

        char j =1;
        char h =2;
        char i = (j+h);
*/

      //  System.out.println(7/-4 + "  Остаток");


        System.out.println(010); //octal integer
        System.out.println(0x10);//16ричный int
/*
* byte and short -> арифмитические операции возвр int*/
        byte bb;
        byte bb1 = 1;
        byte bb2 = 1;
//        bb = bb1 + bb2; //error due to gets int after summing
        bb = (byte)(bb1 + bb2);

        int x = 0b100;
        System.out.println("x " + x);

        Integer integer = 255;
        System.out.println("Int to byte " + integer.byteValue());

        double positive_infinity = 12.0 / 0;
        double negative_infinity = -15.0 / 0;
        System.out.println(String.valueOf(positive_infinity));
        System.out.println(String.valueOf(positive_infinity+negative_infinity));
        char ch1;
        ch1 = 225;
        System.out.println("ch1 содержит " + (int)(ch1));
        ch1++; // увеличим на единицу
        System.out.println("ch1 содержит " + ch1);
        ch1++; // увеличим на единицу
        System.out.println("ch1 содержит " + ch1);


        int[][] c = {{1,2,3}, {4,5,6,7},};
        System.out.println(Arrays.deepToString(c));

        int[] a = {1,2,3};
        int[] b = {6,9,3};
        List<Integer> aI = Arrays.stream(a).boxed().collect(Collectors.toList());
       // List<Integer> aI = Arrays.asList(1,2,3); //208
        List<Integer> bI = Arrays.stream(b).boxed().collect(Collectors.toList());
        aI.addAll(bI); //Exception will be there if aI is as of 208
        //aI.retainAll(bI);
        aI.sort(Comparator.naturalOrder());

        System.out.println("AI" + aI);

        Collection<String> strColl = new ArrayList<>(Arrays.asList("111", "444", "111", null));
        System.out.println(strColl);
        strColl.removeAll(Collections.singleton(null));
        /*Convert list to String array*/
        String[] s = strColl.toArray(new String[0]);

        /*Convert list to Integer array*/
        Integer[] i = strColl.stream().mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int[] ints = strColl.stream().mapToInt(Integer::parseInt).toArray();

        System.out.println(strColl);

        /*Printing arrays via stream: String[], Integer[], int[] */
        System.out.println(Arrays.stream(s).collect(Collectors.toList()));
        System.out.println(Arrays.stream(i).collect(Collectors.toList()));
        System.out.println(Arrays.stream(ints).boxed().collect(Collectors.toList()));


   /*     HashSet hashSetAB = new HashSet(aI);
        System.out.println("HashSetAB" + hashSetAB.toString());
        System.out.println("TreeSet" + new TreeSet<>(aI));
*/

        Collection<String> listStr1 = Arrays.asList("a", "b", "c", "c");
        Collection<String> listStr2 = Arrays.asList("a", "b", "c", "c");
        Collection<Integer> listStr3 = Arrays.asList(1,2,3);

      //  listStr1.addAll(listStr2); //Throws exception because Arrays.asList creates unmodifiable collection.
        Collection<String> listStrUnion = symmetricUnion(listStr1, listStr2);

        HashSet set = new HashSet<>(listStrUnion);
        System.out.println("Set" + set.toString());
       // Collection<Object> listDiffrUnion = objUnion(listStr1, listStr3);
        System.out.println("Union" + listStrUnion.toString());

        System.out.println("Intersection" + symmetricIntersection(listStr1, listStr2));
       // System.out.println(listDiffrUnion.toString());


/*        String s;

        Map map = new HashMap();
        map.put(set,listStr1);
        map.put(set.toArray()[1],listStr1);
        map.put(set.toArray()[2],listStr2);
        map.entrySet().forEach(o -> System.out.println(o));


        HashSet<Map.Entry<String,String>> hashSet = new HashSet<>();
        hashSet.add(new AbstractMap.SimpleEntry("a", "b"));
        hashSet.add(new AbstractMap.SimpleEntry("a", "d"));
        hashSet.add(new AbstractMap.SimpleEntry("c", "d"));
        System.out.println("HashSet" + hashSet);*/


 /*       Map fromHashSet = new HashMap(hashSet.size());
        for (Map.Entry entry :
                hashSet) {
            fromHashSet.put(entry.getKey(), entry.getValue());
        }
        System.out.println("HashMapFromHashSet " + fromHashSet.entrySet());
        System.out.println(fromHashSet.keySet());
        System.out.println(fromHashSet.values());
        */
      /*  IdentityHashMap fromHashSet = new IdentityHashMap(hashSet.size());
        for (Map.Entry entry :
                hashSet) {
            fromHashSet.put(entry.getKey(), entry.getValue());
        }
        System.out.println("HashMapFromHashSet " + fromHashSet.entrySet());
        System.out.println(fromHashSet.keySet());
        System.out.println(fromHashSet.values());*/

        //int a = tryFinallyTest(list);
       /* System.out.println("This is a: " + tryFinallyTest(list));*/

        Pair<Integer, String > pair = new Pair<Integer, String>(1, "abc");
        System.out.println(pair.getKey());
        System.out.println(getMaxValue(3.2, 5, 1000));
        System.out.println(getMaxValue(new double[]{1, 2, 3}));
    }

    public static  <T> Collection<T> symmetricIntersection(Collection<T> a, Collection<T> b) {
        Collection<T> intersection = new ArrayList<>(a);
        intersection.retainAll(b);
        return intersection;
    }

    public <Object> Collection<Object> objUnion(Collection<Object> a, Collection<Object> b) {
        Collection<Object> union = new ArrayList<>(a);
        union.addAll(b);
        return union;
    }

  public static  <T> Collection<T> symmetricUnion(Collection<T> a, Collection<T> b) {
        Collection<T> union = new ArrayList<>(a);
        union.addAll(b);
        return union;
    }

    public static double getMaxValue(double... values) {
        double largest = Double.MIN_VALUE;
        for(double v : values) {
            if (v > largest) {
                largest = v;
            }
        }
        return largest;
    }

    public Object M1(Object a) {
        return a;
    }

 /*   private static int tryFinallyTest(List<Integer> list) {
        try {
            for (int item : list) {
                switch (item) {
                    case 1: {
                        System.out.println("1");
                        return 1;
                    }
                    case 9: {
                        System.out.println("9");
                        return 9;
                    }
                }
            }
        } finally {
            System.out.println("100");
            return 100;
        }
    }*/

}
