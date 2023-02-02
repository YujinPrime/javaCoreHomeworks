package module9.hashmap;

public class MyHashMap <K, V>{
    private Node<K, V>[] entry;
    private int size;
    private final static int CAPACITY = 16;

    public MyHashMap() {
        entry = new Node[CAPACITY];
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
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }
        Node<K, V> newNode = new Node<>(key, value, null);
        int index = Math.abs(key.hashCode()) % CAPACITY;
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
            previous.next = newNode;
        }
        size++;
    }

    public void remove(K key) {
        if (key == null) {
            return;
        }
        int index = Math.abs(key.hashCode()) % CAPACITY;
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
        int index = Math.abs(key.hashCode()) % CAPACITY;
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
        for (int i = 0; i < CAPACITY; i++) {
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
}
