package module9;

import module9.arraylist.MyArrayList;
import module9.hashmap.MyHashMap;
import module9.linkedlist.MyLinkedList;
import module9.queue.MyQueue;
import module9.stack.MyStack;

import java.util.Arrays;
import java.util.LinkedList;

public class MyCollectionsTest {
    public static void main(String[] args) {

//        myArrayListMethodsTest();

//        myStackMethodsTest();

//        myLinkedListMethodsTest();

//        myQueueMethodsTest();

        myHashMapMethodsTest();
    }

    public static void myHashMapMethodsTest() {
        System.out.println("\n" + "++++++++++ HashMap initializing ++++++++++");
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        System.out.println("\n" + "========== put(); ==========");
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i + "h", i+1);
        }

        System.out.println("\n" + "========== size(); ==========");
        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println("\n" + "========== remove(); ==========");
        myHashMap.remove("6h");

        System.out.println("\n" + "========== get(); ==========");
        System.out.println("Element at index: " + myHashMap.get("10h"));

        System.out.println("\n" + "========== clear(); ==========");
        myHashMap.clear();


    }

    public static void myArrayListMethodsTest() {
        System.out.println("\n" + "++++++++++ ArrayList initializing ++++++++++");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        System.out.println(myArrayList);

        System.out.println("\n" + "========== add(); ==========");
        for (int i = 0; i < 17; i++) {
            myArrayList.add(i + "a");
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

    private static void myStackMethodsTest() {
        System.out.println("\n" + "++++++++++ Stack initializing ++++++++++");
        MyStack<String> myStack = new MyStack<>(0);
        System.out.println(myStack);

        System.out.println("\n" + "========== push(); ==========");
        for (int i = 0; i < 15; i++) {
            myStack.push(i + "s");
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

    public static void myLinkedListMethodsTest() {
        System.out.println("\n" + "++++++++++ LinkedList initializing ++++++++++");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        System.out.println(myLinkedList);

        System.out.println("\n" + "========== add(); ==========");
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i + "l");
        }
        System.out.println(myLinkedList);

        System.out.println("\n" + "========== size(); ==========");
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        System.out.println("\n" + "========== get(); ==========");
        System.out.println("Element at index: " + myLinkedList.get(3));

        System.out.println("\n" + "========== remove(); ==========");
        System.out.println("Element to remove: " + myLinkedList.remove(3));
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println(myLinkedList);

        System.out.println("\n" + "========== clear(); ==========");
        myLinkedList.clear();
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println(myLinkedList);
    }

    public static void myQueueMethodsTest() {
        System.out.println("\n" + "++++++++++ Queue initializing ++++++++++");
        MyQueue<String> myQueue = new MyQueue<>();
        System.out.println(myQueue);

        System.out.println("\n" + "========== add(); ==========");
        for (int i = 0; i < 10; i++) {
            myQueue.add(i + "q");
        }
        System.out.println(myQueue);

        System.out.println("\n" + "========== size(); ==========");
        System.out.println("myQueue.size() = " + myQueue.size());

        System.out.println("\n" + "========== peek(); ==========");
        System.out.println("First element of the queue: " + myQueue.peek());

        System.out.println("\n" + "========== poll(); ==========");
        System.out.println("Removed first element of the queue: " + myQueue.poll());
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println(myQueue);

        System.out.println("\n" + "========== clear(); ==========");
        myQueue.clear();
        System.out.println("myQueue.size() = " + myQueue.size());
        System.out.println(myQueue);
    }
}
