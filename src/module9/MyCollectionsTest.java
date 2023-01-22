package module9;

import module9.arraylist.MyArrayList;

public class MyCollectionsTest {
    public static void main(String[] args) {

        myArrayListMethodsTest();
    }

    public static void myArrayListMethodsTest() {
        System.out.println("\n" + "========== List initializing ==========");
        MyArrayList<String> myArrayList = new MyArrayList<>(0);
        System.out.println(myArrayList);

        System.out.println("\n" + "========== add(); ==========");
        for (int i = 0; i < 18; i++) {
            myArrayList.add(i + "e");
        }
        System.out.println(myArrayList);

        System.out.println("\n" + "========== size(); ==========");
        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("\n" + "========== get(); ==========");
        System.out.println("Element at index: " + myArrayList.get(13));

        System.out.println("\n" + "========== remove(); ==========");
        myArrayList.remove(1);
        System.out.println(myArrayList);

        System.out.println("\n" + "========== clear(); ==========");
        myArrayList.clear();
        System.out.println(myArrayList);
    }
}
