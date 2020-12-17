package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author magic_lz
 * Description TODO 二叉查询树
 * @version 1.0
 * @ClassName tree
 * @date 2019/12/24 16:09
 */
public class BinaryTree<T extends Comparable<T>> {
    private int size;
    private Node<T> root;

    public void add(T t){
         root = add(root, t);
    }

    private Node<T> add(Node<T> node,T t){
        if(node == null){
            size++;
            return new Node<T>(t);
        }else {
            if(t.compareTo(node.t) < 0){
                node.left = add(node.left,t);
            }else if(t.compareTo(node.t) > 0){
                node.right = add(node.right,t);
            }
            return node;
        }
    }
    public boolean isNull(){
        return size == 0;
    }

    public boolean contains(T t){
        return contains(root,t);
    }

    private boolean contains(Node<T> node,T t){
        if(node == null){
            return false;
        }
        if(t.compareTo(node.t) == 0){
            return true;
        }else if(t.compareTo(node.t) < 0 ){
            return contains(node.left,t);
        }else{  // t.compareTo(node.t) > 0
            return contains(node.right,t);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preSort(){
        preSort(root);
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inSort(){
        inSort(root);
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postSort(){
        postSort(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树, 递归算法
     * @param node root
     */
    private void preSort(Node<T> node){
     if(node == null){
         return;
     }
     System.out.println(node.t);
     preSort(node.left);
     preSort(node.right);
    }

    /**
     * 使用栈来实现非递归的前序遍历，栈为后进先出，从根节点开始，将left，right，while循环添加到栈中，最后添加的最先遍历出来
     * 就实现了前中后序遍历的需求
     */
    public void preSortNR(){
        if(root == null){
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node<T> cur = stack.pop();
            System.out.println(cur.t);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     * @param node root
     */
    private void inSort(Node<T> node){
        if(node == null){
            return;
        }
        inSort(node.left);
        System.out.println(node.t);
        inSort(node.right);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * @param node root
     */
    private void postSort(Node<T> node){
        if(node == null){
            return;
        }
        inSort(node.left);
        inSort(node.right);
        System.out.println(node.t);

    }

    /**
     * 层序遍历：按照树结构一层一层往下遍历
     */
    public void levelSort(){
        if(root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> cur = queue.remove();
            System.out.println(cur.t);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * @return 树的字符串
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateString(root,0,res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node root
     * @param depth 深度
     * @param res 字符串StringBuilder
     */
    private void generateString(Node<T> node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.t).append("\n");
        generateString(node.left,depth+1,res);
        generateString(node.right,depth+1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++) {
            res.append("--");
        }
        return res.toString();
    }

    /**
     * 二叉搜索树最小值
     * @return T
     */
    public T min(){
        if(size == 0){
            throw new NullPointerException("该树为空");
        }
        return min(root).t;
    }

    private Node<T> min(Node<T> node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    public T max(){
        if(isNull()){
            throw new NullPointerException("该树为空");
        }
        return max(root).t;
    }

    private Node<T> max(Node<T> node){
        if(node.right == null){
            return node;
        }
        return max(node.right);
    }

    /**
     * 删除最小的数
     * @return T
     */
    public T removeMin(){
        T min = min();
        root = removeMin(this.root);
        return min;
    }

    public T removeMax(){
        T max = max();
        root = removeMax(this.root);
        return max;
    }
    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node<T> removeMin(Node<T> node){
        if(node.left == null){
            Node<T> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        /*
        递归找到最左边并且左孩子为空的值,然后把他的右孩子赋值给他
         */
        node.left = removeMin(node.left);
        return node;
    }

    private Node<T> removeMax(Node<T> node){
        if(node.right == null){
            Node<T> leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(T t){
        root = remove(root,t);
    }

//     删除掉以node为根的二分搜索树中值为e的节点, 递归算法
//     返回删除节点后新的二分搜索树的根
    private Node<T> remove(Node<T> node,T t){
        if(node == null) {
            return null;
        }

        if(t.compareTo(node.t) < 0){

            //这块的node的left/right连接上了下面的改变之后的数据结构
            node.left = remove(node.left,t);
            return node;
        }else if(t.compareTo(node.t) > 0){
            node.right = remove(node.right,t);
            return node;
        }else {//t.compareTo(node.t) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node<T> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node<T> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            /*
             待删除节点左右子树均不为空的情况

             找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
             用这个节点顶替待删除节点的位置
             */

            //找到该节点的右子树的最小值
            Node<T> suc = min(node.right);
            //删除右子树最小值后,再把右子树的根节点赋值到suc.right 相当于 suc变成了右子树的父节点
            suc.right = removeMin(node.right);
            suc.left = node.left;

            node.left = node.right = null;// help GC

            return suc;
        }
    }

    public int getSize(){
        return this.size;
    }
}
