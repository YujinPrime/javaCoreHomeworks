package module9.linkedlist;

import java.util.Arrays;
import java.util.Objects;

public class MyLinkedList<E>{
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(E element) {
        Node<E> prevNode = last;
        Node<E> newNode = new Node<>(prevNode, element, null);
        last = newNode;
        if (prevNode == null)
            first = newNode;
        else
            prevNode.next = newNode;
        size++;
    }

    public E remove(int index) {
        Node<E> toRemove = getNode(index);
        Node<E> next = toRemove.next;
        Node<E> prev = toRemove.prev;
        E elementToRemove = toRemove.element;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            toRemove.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            toRemove.next = null;
        }

        toRemove.element = null;
        size--;
        return elementToRemove;
    }

    public void clear() {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                Node<E> node = first;
                first = node.next;
                node.prev = null;
                node.next = null;
                node.element = null;
            }
            last = null;
            size = 0;
        }
    }

    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        Objects.checkIndex(index, size);
        Node<E> desiredNode = first;
        for (int i = 0; i < index; i++)
            desiredNode = desiredNode.next;
        return desiredNode;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    @Override
    public String toString() {
        Object[] elements = new Object[size];
        for (int i = 0; i < size; i++) {
            elements[i] = get(i);
        }
        return Arrays.toString(elements);
    }
}
