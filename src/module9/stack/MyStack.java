package module9.stack;

import module9.arraylist.MyArrayList;

public class MyStack <E>{
    private MyArrayList<E> stack;
    private int size = 0;

    public MyStack() {
        stack = new MyArrayList<>();
    }

    public MyStack(int initialCapacity) {
        stack = new MyArrayList<>(initialCapacity);
    }

    public void push(E element) {
        stack.add(element);
        size++;
    }

    public void remove(int index) {
        stack.remove(index);
        size--;
    }

    public void clear() {
        stack.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return stack.get(stack.size() - 1);
    }

    public E pop() {
        E elementToDelete = peek();
        remove(size - 1);
        return elementToDelete;
    }

    @Override
    public String toString() {
        return String.valueOf(stack);
    }
}
