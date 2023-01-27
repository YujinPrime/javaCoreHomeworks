package module9;

import module9.arraylist.MyArrayList;
import module9.stack.MyStack;

public class MyCollectionsTest {
    public static void main(String[] args) {

        myArrayListMethodsTest();

        myStackMethodsTest();
    }

    private static void myStackMethodsTest() {
        System.out.println("\n" + "++++++++++ Stack initializing ++++++++++");
        MyStack<String> myStack = new MyStack<>(0);
        System.out.println(myStack);

        System.out.println("\n" + "========== push(); ==========");
        for (int i = 0; i < 15; i++) {
            myStack.push(i + "e");
        }
        System.out.println(myStack);

        System.out.println("\n" + "========== remove(); ==========");
        myStack.remove(3);
        System.out.println(myStack);

        System.out.println("\n" + "========== size(); ==========");
        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("\n" + "========== peek(); ==========");
        System.out.println("First element of the stack: " + myStack.peek());

        System.out.println("\n" + "========== pop(); ==========");
        System.out.println("Removed first element of the stack: " + myStack.pop());
        System.out.println(myStack);

        System.out.println("\n" + "========== clear(); ==========");
        myStack.clear();
        System.out.println(myStack);
    }

    public static void myArrayListMethodsTest() {
        System.out.println("\n" + "++++++++++ List initializing ++++++++++");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);

        System.out.println("\n" + "========== add(); ==========");
        for (int i = 0; i < 17; i++) {
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
