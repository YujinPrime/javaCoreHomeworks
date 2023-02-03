package module9.hashmap;

import java.util.Arrays;

public class MyHashMap <K, V>{
    private Node<K, V>[] entry;
    private int size;
    private int capacity = 8;
    private final static double LOAD_FACTOR = 0.75;

    public MyHashMap() {
        entry = new Node[capacity];
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
//            StringBuilder nodeRow = new StringBuilder();
//            nodeRow.append("key=")
//                   .append(key)
//                   .append(", value=")
//                   .append(value);
//            if (next != null) {
//                nodeRow.append("; ").append(next);
//            }
//            return nodeRow.toString();
            return "key=" + key + ", value=" + value;
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }
        addElement(key, value);
        size++;
    }

    public void resize() {
        capacity *= 2;
        Node<K, V>[] oldEntry = Arrays.copyOf(entry, entry.length);
        entry = new Node[capacity];
        for (Node<K, V> node : oldEntry) {
            while(node != null) {
                addElement(node.key, node.value);
                node = node.next;
            }
        }
    }

    private void addElement(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value, null);
        int index = Math.abs(key.hashCode()) % capacity;
        if (entry[index] == null) {
            entry[index] = newNode;
        } else {
            Node<K, V> previous = null;
            Node<K, V> current = entry[index];
            while (current != null ) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                previous = current;
                current = current.next;
            }
            if(previous != null) {
                previous.next = newNode;
            }
        }
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }
        int index = Math.abs(key.hashCode()) % capacity;
        Node<K, V> previous = null;
        Node<K, V> current = entry[index];
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    entry[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                current.key = null;
                current.value = null;
                current.next = null;
                break;
            }
            previous = current;
            current = current.next;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        int index = Math.abs(key.hashCode()) % capacity;
        Node<K, V> current = entry[index];
        V value = null;
        while (current != null) {
            if (current.key.equals(key)){
                value = current.value;
                break;
            }
            current = current.next;
        }
        return value;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            if (entry[i] != null) {
                Node<K, V> tempNode;
                Node<K, V> current = entry[i];
                while (current != null) {
                    tempNode = current.next;
                    current.key = null;
                    current.value = null;
                    current.next = null;
                    current = tempNode;
                }
                entry[i] = null;
            }
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder hashTable = new StringBuilder();
        for (Node<K, V> node : entry) {
            if (node == null) {
                hashTable.append("[null]\n");
            } else {
//                hashTable.append("[").append(node).append("]\n");
                hashTable.append("[").append(node);
                while (node.next != null) {
                    hashTable.append("; ").append(node.next);
                    node = node.next;
                }
                hashTable.append("]\n");
            }
        }

        return hashTable.toString();
    }
}
