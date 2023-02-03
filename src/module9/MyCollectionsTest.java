package module9;

import module9.arraylist.MyArrayList;
import module9.hashmap.MyHashMap;
import module9.linkedlist.MyLinkedList;
import module9.queue.MyQueue;
import module9.stack.MyStack;

public class MyCollectionsTest {
    public static void main(String[] args) {

        myArrayListMethodsTest();

        myStackMethodsTest();

        myLinkedListMethodsTest();

        myQueueMethodsTest();

        myHashMapMethodsTest();
    }

    public static void myArrayListMethodsTest() {
        System.out.println("\n++++++++++ ARRAYLIST INITIALIZING ++++++++++");
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
        System.out.println("\n\n++++++++++ STACK INITIALIZING ++++++++++");
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
        System.out.println("\n\n++++++++++ LINKEDLIST INITIALIZING ++++++++++");
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
        System.out.println("\n\n++++++++++ QUEUE INITIALIZING ++++++++++");
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

    public static void myHashMapMethodsTest() {
        System.out.println("\n\n++++++++++ HASHMAP INITIALIZING ++++++++++");
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        System.out.println(myHashMap);

        System.out.println("\n" + "========== put(); ==========");
        myHashMap.put(1, "1");
        myHashMap.put(2, "2");
        myHashMap.put(3, "3");
        myHashMap.put(9, "9");
        myHashMap.put(17, "17");
        myHashMap.put(18, "18");
        System.out.println("MyHashMap before resizing:\n" + myHashMap);
        myHashMap.put(16, "16");
        System.out.println("MyHashMap after resizing and rehashing:\n" + myHashMap);

        System.out.println("\n" + "========== size(); ==========");
        System.out.println("MyHashMap size = " + myHashMap.size());

        System.out.println("\n" + "========== remove(); ==========");
        myHashMap.remove(2);
        System.out.println("MyHashMap after removing the pair:\n" + myHashMap);

        System.out.println("\n" + "========== get(); ==========");
        System.out.println("Value of the key: " + myHashMap.get(9));

        System.out.println("\n" + "========== clear(); ==========");
        myHashMap.clear();
        System.out.println(myHashMap);
    }
}
