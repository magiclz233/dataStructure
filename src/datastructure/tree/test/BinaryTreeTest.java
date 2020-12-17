package datastructure.tree.test;

import datastructure.tree.BinaryTree;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName BinaryTreeTest
 * @date 2019/12/27 15:59
 */
public class BinaryTreeTest {
    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(7);
        tree.add(4);
        tree.add(3);
        tree.add(6);
        tree.add(10);
        tree.add(8);
        tree.add(2);
        tree.add(9);
        tree.add(11);

        tree.inSort();
        System.out.println("size:"+tree.getSize());
        System.out.println("~");
//        Integer m = tree.removeMin();
//        System.out.println(m+"~~");
//        tree.preSort();
//        System.out.println("~");
//        tree.inSort();
//        System.out.println("~");
//        tree.levelSort();
//        System.out.println("~");
//        System.out.println(tree.toString());

        tree.remove(4);
        System.out.println("size:"+tree.getSize());

        tree.inSort();
        tree.preSort();
    }
}
