package basic.tree.set;

import basic.tree.AVLTree;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 基于AVL树的set结构
 * @version 1.0
 * @ClassName AVLSet
 * @date 2019/12/29 15:23
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E,Object> avl;

    public AVLSet(){
        avl = new AVLTree<>();
    }
    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
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
