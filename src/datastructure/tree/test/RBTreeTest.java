package datastructure.tree.test;

import datastructure.tree.RBTree;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName RBTreeTest
 * @date 2019/12/30 16:38
 */
public class RBTreeTest {
    public static void main(String[] args){
        RBTree<Integer,Integer> tree = new RBTree<>();
        tree.add(10,10);
        tree.add(6,6);
        tree.add(3,3);
        System.out.println(tree.contains(10));
        System.out.println(tree.contains(6));
        System.out.println(tree.contains(3));
    }
}
