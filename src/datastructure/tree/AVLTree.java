package datastructure.tree;

import java.util.ArrayList;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName AVLTree
 * @date 2019/12/27 18:26
 */
public class AVLTree<K extends Comparable<K>,V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    public V getRoot(){
        return root.value;
    }
    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isNull(){
        return size == 0;
    }

    public void preSort(){
        if(root == null){
            throw new NullPointerException("结构为空");
        }

    }
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i = 1;i <keys.size();i++){
            if(keys.get(i-1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }


    //将Tree的key中序遍历到ArrayList中去
    private void inOrder(Node node,ArrayList<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);

    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balance = getBalance(node);
        if(Math.abs(balance) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    /**
     *     获取节点的高度
     */
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    /**
     *     获取节点平衡因子
     */
    private int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        //向右旋转过程
        x.right = y;
        y.left = T3;

        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
       Node x = y.right;
       Node T2 = x.left;

       //左旋转
       x.left = y;
       y.right = T2;

       y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
       x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;

       return x;
    }
    public void add(K k,V v){
        root = add(root,k,v);
    }
    private Node add(Node node,K key,V value){
        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        } else if(key.compareTo(node.key) >0){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }

        //更新height
            node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
            //计算平衡因子
            int balance = getBalance(node);
        // 平衡维护

        /*
         当该节点不平衡时,并且该节点的左子树的平衡因子大于等于0,也就是说左子树的左孩子高度大于等于右孩子
                y                              x
               / \                           /   \
              x   T4     向右旋转 (y)        z     y
             / \       - - - - - - - ->    / \   / \
            z   T3                       T1  T2 T3 T4
           / \
         T1   T2
         这种结构就复合第一种情况  y的平衡因子为2 他的左孩子 x的平衡因子 2-1=1 >=0
         所以直接将x变成父节点,x的右孩子变成y的左孩子
         */

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        /*
        第二种情况:
        1:父节点y的平衡因子小于-1  是因为y的右子树高度大于左子树1层以上
        2:y的右子树的父节点为x x的平衡因子>=0 即x的左子树高度大于等于右子树的高度
        这种情况下直接使用左旋转
            y                             x
          /  \                          /   \
         T1   x      向左旋转 (y)       y     z
             / \   - - - - - - - ->   / \   / \
            T2  z                     T1 T2 T3 T4
               / \
              T3 T4
         */
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        /*
           第三种情况:
           1:y的平衡因子大于1 即左子树高度大于右子树高度2层以及以上
           2:y的左子树父节点x  x的平衡因子小于0  即x的左子树高度小于右子树高度
           这种情况下,是不能直接右旋转的,先将x进行左旋转 然后结构就变成和第一种一样的了,再进行y的右旋转
                                                                                   y
                                                                                 /   \                          z
                y                              x                                z     T4                      /   \
               / \                           /   \                            /   \                          x      y
              x   T4      x的结构            T1   z     先将x进行左旋转       x     T3    再进行y的右旋转    /   \  /   \
             / \       - - - - - - - ->          / \  ------------------>  /   \       -----------------> T1   T2 T3  T4
            T1  z                               T2 T3                     T1   T2
               / \
              T2  T3
         */
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        /*
        第四种:
        1:y的平衡因子小于-1 即左子树高度小于右子树高度2层以及以上
           2:y的右子树父节点x  x的平衡因子小于0  即x的左子树高度小于右子树高度

         */
        /*
        第二种情况:
        1:父节点y的平衡因子小于-1  是因为y的右子树高度大于左子树1层以上
        2:y的右子树的父节点为x x的平衡因子>=0 即x的左子树高度大于等于右子树的高度
        这种情况下,是不能直接左旋转的,先将x进行右旋转 然后进行y的左旋转
            y                             y                                 z
          /  \                          /   \                             /   \
         T1   x      右旋转 (x)        T1     z       左旋转(y)          y      x
             / \   - - - - - - - ->           / \  ----------->       /   \   /   \
            z  T4                            T2  x                   T1   T2  T3  T4
           / \                                  / \
          T2 T3                                T3  T4
         */
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
            return node;
    }

    /**
     *   返回以node为根节点的二分搜索树中,key所在的节点
     */
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.equals(node.key)){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }else {
            return getNode(node.right,key);
        }

    }
    public boolean contains(K key){
        return getNode(root,key) != null;
    }


    public V get(K k){
        Node node = getNode(root, k);
        return node == null? null:node.value;
    }

    //修改
    public void set(K key,V value){
        Node node = getNode(root, key);
        if(node == null){
          throw new IllegalArgumentException("没有创建该key:"+key);
        }
        node.value = value;
    }

    private Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node){
        if(node.right == null){
            return node;
        }
        return max(node.right);
    }

    public V min(){
        return min(root).value;
    }

    public V max(){
        return max(root).value;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }
        Node reNode;
        if(key .compareTo(node.key) < 0){
            node.left = remove(node.left ,key);
            reNode = node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            reNode = node;
        }else {

            if(node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                reNode = right;
            } else if(node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                reNode = left;

                // 待删除节点左右子树均不为空的情况
            }else {

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node min = min(node.right);

                min.right = remove(node.right,min.key);
                min.left = node.left;

                node.left = node.right = null; //help GC

                reNode = min;
            }
        }
        if(reNode == null){
            return null;
        }

        reNode.height = 1+Math.max(getHeight(reNode.left),getHeight(reNode.right));

        int balance = getBalance(reNode);

        // 平衡维护
        // LL
        if (balance > 1 && getBalance(reNode.left) >= 0)
            return rightRotate(reNode);

        // RR
        if (balance < -1 && getBalance(reNode.right) <= 0)
            return leftRotate(reNode);

        // LR
        if (balance > 1 && getBalance(reNode.left) < 0) {
            reNode.left = leftRotate(reNode.left);
            return rightRotate(reNode);
        }

        // RL
        if (balance < -1 && getBalance(reNode.right) > 0) {
            reNode.right = rightRotate(reNode.right);
            return leftRotate(reNode);
        }

        return reNode;


    }
}
