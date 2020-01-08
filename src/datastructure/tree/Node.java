package datastructure.tree;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Node
 * @date 2019/12/25 16:39
 */
public class Node<T> {

        Node<T> left;
        Node<T> right;
        T t;

        Node(){
        }

        Node(T t){
            this.left = null;
            this.right = null;
            this.t = t;
        }
        Node(T t,Node<T> left,Node<T> right){
            this.t = t;
            this.left = left;
            this.right = right;
        }
}
