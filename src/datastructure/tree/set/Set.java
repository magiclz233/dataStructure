package datastructure.tree.set;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Set
 * @date 2019/12/29 15:26
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}
