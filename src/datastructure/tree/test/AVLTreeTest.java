package datastructure.tree.test;

import datastructure.tree.AVLTree;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName AVLTreeTest
 * @date 2019/12/28 19:06
 */
public class AVLTreeTest {
    public static void main(String[] args){
        AVLTree<Integer,Integer> tree = new AVLTree<>();
        tree.add(10,10);
        tree.add(6,6);
        tree.add(3,3);
        tree.add(8,8);
        tree.add(2,2);
        tree.add(5,5);
        tree.add(4,4);
        boolean balanced = tree.isBalanced();
        System.out.println(balanced);
        System.out.println(tree.getRoot());
    }
}
