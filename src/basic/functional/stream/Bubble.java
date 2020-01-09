package basic.functional.stream;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Bubble
 * @date 2020/1/9 10:29
 */
public class Bubble {
    public final int i;

    public Bubble(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Bubble{" +
                "i=" + i +
                '}';
    }

    public static int count = 0;
    public static Bubble bubbler(){
        return new Bubble(count++);
    }
}
