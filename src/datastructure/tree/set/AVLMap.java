package datastructure.tree.set;

import datastructure.tree.AVLTree;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName AVLMap
 * @date 2019/12/29 16:16
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {

    private AVLTree<K,V> avl;

    public AVLMap(){
        avl = new AVLTree<>();
    }
    @Override
    public void add(K key, V value) {
        avl.add(key,value);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V value) {
        avl.set(key,value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isNull();
    }
}
