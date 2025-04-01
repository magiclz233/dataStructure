package algorithm.leetcode.top100.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author magic
 * @since 2025/3/31 13:32 
 */
public class LRU2<K, V> {
    public Node<K, V> head;
    public Node<K, V> tail;
    private final int capacity;
    private  Map<K, Node<K, V>> map;


    public class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> prev;
        public Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRU2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }
}
