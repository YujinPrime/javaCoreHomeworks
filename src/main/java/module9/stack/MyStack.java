package module9.stack;

import module9.arraylist.MyArrayList;

public class MyStack <E>{
    private MyArrayList<E> stack;

    public MyStack() {
        stack = new MyArrayList<>();
    }

    public MyStack(int initialCapacity) {
        stack = new MyArrayList<>(initialCapacity);
    }

    public void push(E element) {
        stack.add(element);
    }

    public void remove(int index) {
        stack.remove(index);
    }

    public void clear() {
        stack.clear();
    }

    public int size() {
        return stack.size();
    }

    public E peek() {
        return stack.get(size() - 1);
    }

    public E pop() {
        E elementToDelete = peek();
        remove(size() - 1);
        return elementToDelete;
    }

    @Override
    public String toString() {
        return String.valueOf(stack);
    }
}
