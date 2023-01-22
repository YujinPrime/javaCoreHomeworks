package module9.arraylist;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList <E>{
    private Object[] arrayList;
    private int size = 0;

    public MyArrayList() {
        arrayList = new Object[10];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            arrayList = new Object[initialCapacity];
        }else if (initialCapacity == 0) {
            arrayList = new Object[0];
        }else if(initialCapacity < 0) {
            throw new IllegalArgumentException("Incorrect initial capacity: " + initialCapacity);
        }
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        arrayList[size++] = element;
    }

//    private void ensureCapacity(int requiredCapacity) {
//        if (requiredCapacity > arrayList.length) {
//            int newLength = arrayList.length * 2;
//            arrayList = Arrays.copyOf(arrayList, newLength);
//        }
//    }
    private void ensureCapacity(int requiredCapacity) {
        int newLength;
        if (arrayList.length == 0) {
            newLength = 2;
            arrayList = Arrays.copyOf(arrayList, newLength);
        }else if (requiredCapacity > arrayList.length && arrayList.length > 0) {
            newLength = arrayList.length * 2;
            arrayList = Arrays.copyOf(arrayList, newLength);
        }

    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[size - 1] = null;
        size--;
    }

    public void clear(){
        Object[] objects = {};
        arrayList = Arrays.copyOf(objects, arrayList.length);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
//        Objects.checkIndex(index, size);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) arrayList[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayList);
    }

}
