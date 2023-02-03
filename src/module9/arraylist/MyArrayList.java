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
        if (initialCapacity > 0) {
            arrayList = new Object[initialCapacity];
        }else if (initialCapacity == 0) {
            arrayList = new Object[0];
        }else {
            throw new IllegalArgumentException("Incorrect initial capacity: " + initialCapacity);
        }
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        arrayList[size++] = element;
    }

    private void ensureCapacity(int requiredCapacity) {
        int newLength;
        if (arrayList.length == 0) {
            newLength = DEFAULT_CAPACITY;
            arrayList = Arrays.copyOf(arrayList, newLength);
        }else if (requiredCapacity > arrayList.length) {
            newLength = arrayList.length * 2;
            arrayList = Arrays.copyOf(arrayList, newLength);
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(arrayList, index + 1, arrayList, index, arrayList.length - index - 1);
        arrayList[--size] = null;
    }

    public void clear(){
        arrayList = Arrays.copyOf(new Object[0], arrayList.length);
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
        return Arrays.toString(arrayList);
    }
}
