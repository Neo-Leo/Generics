import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Node<K,V> {
    K k;
    V v;
    Node<K,V> prev;
    Node<K,V> next;

    Node(K k, V v) {
        this.k = k;
        this.v = v;
        this.prev = this.next = null;
    }
}

class DLL<K,V> {

    public Node<K,V> head, tail;
    public final int capacity;
    public int size;

    DLL(int capacity) {
        this.capacity = capacity;
        this.head = this.tail = null;
        size = 0;
    }

    public void remove(Node<K,V> node) {
        if(head == node && tail == node) { // Case with just one node.
            head = tail = null;
        } else if(node == head) {
            Node<K,V> nextNode = head.next;
            nextNode.prev = null;
            head.next = null;
            head = nextNode;
        } else if(node == tail) {
            Node<K,V> prevNode = tail.prev;
            prevNode.next = null;
            tail.prev = null;
            tail = prevNode;
        } else {
            Node<K,V> nextNode = node.next;
            Node<K,V> prevNode = node.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
    }

    public void addToTail(Node<K,V> node) {
        if(head == null && tail==null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
}

class GenericLRU<K,V> {

    int capacity;
    DLL<K,V> dll;
    Map<K, Node<K,V>> map;

    GenericLRU(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.dll = new DLL<>(capacity);
    }

    public V get(K k) {
        if(!map.containsKey(k)) return null;
        Node<K,V> node = map.get(k);
        dll.remove(node);
        dll.addToTail(node);
        return node.v;
    }

    public void put(K k, V v) {
        if(dll.size == capacity && !map.containsKey(k)) { // Eviction
            Node<K,V> oldest = dll.head;
            dll.remove(oldest);
            map.remove(oldest.k);
        }

        if(map.containsKey(k)) {
            get(k);
            map.get(k).v = v;
        } else {
            Node<K,V> newNode = new Node<>(k,v);
            map.put(k, newNode);
            dll.addToTail(newNode);
        }
    }

    public void remove(K k) {
        if(!map.containsKey(k)) return;
        Node<K,V> node = map.get(k);
        dll.remove(node);
        map.remove(k);
    }
}

public class CustomLRU {
    public static void main(String[] args) {
        GenericLRU<String, Integer> lru = new GenericLRU<>(3);
        // Nilanshu -> Arjun -> Saurabh
        lru.put("Nilanshu", 1);
        lru.put("Arjun", 2);
        lru.put("Saurabh", 3);
        // Nilanshu -> Arjun -> Saurabh
        System.out.println(lru.get("Nilanshu"));
        System.out.println(lru.get("Arjun"));
        System.out.println(lru.get("Saurabh"));
        // Arjun -> Saurabh -> Nilanshu
        lru.put("Nilanshu", 4);
        // Arjun -> Saurabh -> Nilanshu
        System.out.println(lru.get("Nilanshu"));
        // Saurabh -> Nilanshu -> KP
        lru.put("KP",5);
        // Saurabh -> KP -> Nilanshu
        System.out.println(lru.get("Nilanshu"));
        // KP -> Nilanshu -> Mishra
        lru.put("Mishra", 6);
        System.out.println(lru.get("Nilanshu"));
        System.out.println(lru.get("Arjun"));
        System.out.println(lru.get("Saurabh"));
        System.out.println(lru.get("KP"));
        System.out.println(lru.get("Mishra"));
    }
}
