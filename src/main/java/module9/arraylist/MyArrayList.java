package module9.arraylist;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <E>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] arrayList;
    private int size = 0;

    public MyArrayList() {
        arrayList = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            arrayList = new Object[initialCapacity];
        }else {
            throw new IllegalArgumentException("Incorrect initial capacity: " + initialCapacity);
        }
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        arrayList[size++] = element;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (arrayList.length == 0) {
            arrayList = Arrays.copyOf(arrayList, DEFAULT_CAPACITY);
        }else if (requiredCapacity > arrayList.length) {
            arrayList = Arrays.copyOf(arrayList, arrayList.length * 2);
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(arrayList, index + 1, arrayList, index, arrayList.length - index - 1);
        arrayList[--size] = null;
    }

    public void clear(){
        arrayList = new Object[arrayList.length];
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) arrayList[index];
    }

    @Override
    public String toString() {
        Object[] arrayListToConsole = Arrays.copyOf(arrayList, size);
        return Arrays.toString(arrayListToConsole);
    }
}
