package module9.queue;

import module9.linkedlist.MyLinkedList;

public class MyQueue <E>{
    private MyLinkedList<E> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public void add(E element) {
        queue.add(element);
    }

    public int size() {
        return queue.size();
    }

    public E peek() {
        return queue.get(0);
    }

    public E poll() {
        return queue.remove(0);
    }

    public void clear() {
        queue.clear();
    }

    @Override
    public String toString() {
        return String.valueOf(queue);
    }
}
