package datastructure.tree;

/**
 * @author magic_lz
 * Description TODO 红黑树
 * @version 1.0
 * @ClassName RedBlackTree
 * @date 2019/12/29 16:20
 */
public class RBTree<K extends Comparable<K>,V> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;

    private int size;

    public int getSize(){
        return size;
    }
    public RBTree(){
        this.root = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }

    public void add(K key,V value){
        root = add(root,key,value);
        root.color = BLACK;
    }

    private Node add(Node node,K key,V value){
        if(node == null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }
        if(isRed(node.right) & !isRed(node.left)){
            node = leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;

    }
    /*
       node                     x
      /   \     左旋转         /  \
     T1   x   --------->   node   T3
         / \              /   \
        T2 T3            T1   T2
     */
    private Node leftRotate(Node node){
        Node x = node.right;

        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;

    }
    /*
        node                          x
        /  \        右旋转           /  \
        X   T3      -------->       T1  node
       /\                               /  \
     T1 T2                              T2   T3
     */
    private Node rightRotate(Node node){
        Node x = node.right;

        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    //颜色翻转
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.equals(node.key)){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else {
            return getNode(node.right,key);
        }
    }

    public boolean contains(K key){
        Node node = getNode(root, key);
        return node != null;
    }

    public V get(K key){
        Node node = getNode(root,key);
        return node == null ? null:node.value;
    }

    public void set(K key,V value){
        Node node = getNode(root, key);
        if(node == null){
           throw new IllegalArgumentException("无此key对应的数据,key="+key);
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

    public Node remove(Node node,K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            return node;
        }else {
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node min = min(node.right);
            min.right = removeMin(node.right);
            min.left = node.left;

            node.left = node.right = null;
            return  min;
        }

    }

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }
}
