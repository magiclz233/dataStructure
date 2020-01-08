package datastructure.tree.set;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Map
 * @date 2019/12/29 15:31
 */
public interface Map<K,V> {
    void add(K key,V value);
    boolean contains(K key);
    V get(K key);
    void set(K key,V value);
    V remove(K key);
    int getSize();
    boolean isEmpty();
}
