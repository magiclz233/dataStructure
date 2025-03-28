package algorithm.offer.Topic_0062_圆圈中剩下最后的数字;

/**
 * @author magic_lz
 * @version 1.0
 * @classname Main
 * @date 2021/1/11 : 10:26
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }
    public static int lastRemaining(int n, int m) {
        if(n == 1){
            return 0;
        }
        int x = lastRemaining(n-1,m);
        return (m + x) % n;
    }
}
