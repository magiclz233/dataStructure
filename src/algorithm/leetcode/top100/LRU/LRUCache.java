package algorithm.leetcode.top100.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;

    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> prev;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key); 
        if(node != null){
           node.value = value;
           moveToHead(node); 
        } else {
            node = new Node<>(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                Node<K, V> removedNode = removeTail();
                map.remove(removedNode.key);
            }
        }
    }


    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private Node<K, V> removeTail() {
        Node<K, V> lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(2);
        cache.put("A", 1);
        cache.put("B", 2);
        System.out.println(cache.get("A")); // 输出: 1
        cache.put("C", 3);
        System.out.println(cache.get("B")); // 输出: null
    }
}