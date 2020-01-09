package basic.functional;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO Lambda表达式
 * @version 1.0
 * @ClassName LambdaExpressions
 * @date 2020/1/8 16:32
 */
public class LambdaExpressions {
    interface Description {
        String brief();
    }

    interface Body {
        String detailed(String head);
    }

    interface Multi {
        String twoArg(String head, Double d);
    }

    static Body body = h -> h + "head";

    static Body body1 = (head) -> head +"More details";

    static Description des = () -> "Description";

    static Multi multi = (h,n) -> h+n;

    static Description moreLines = () -> { // [5]
        System.out.println("moreLines()");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(body.detailed("Oh!"));
        System.out.println(body1.detailed("Hi!"));
        System.out.println(des.brief());
        System.out.println(multi.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
