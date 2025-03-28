package algorithm.leetcode.top100.LRU;

import java.util.HashMap;

/**
 * @author magic
 * @since 2025/3/28 16:40 
 */
public class LRU1<K, V>{
    public Integer capacity;
    public HashMap<K, Node<K, V>> node;
    public Node<K, V> head;
    public Node<K, V> tail;

    public class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> prev;
        public Node<K, V> next;
    }

    public LRU1(Integer capacity) {
        this.capacity = capacity;
        node = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    public Boolean put(K key, V value) {
        Node<K, V> kvNode = node.get(key);
        if (kvNode != null) {

        }
        return true;
    }
}
