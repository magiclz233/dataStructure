package basic.functional;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Strategize
 * @date 2020/1/8 16:01
 */
public class Strategize {
    interface Strategy {
        String approach(String msg);
    }

    class Soft implements Strategy {
        @Override
        public String approach(String msg) {
            return msg.toLowerCase() + "?";
        }
    }

    static class Unrelated {
        static String twice(String msg) {
            return msg + " " + msg;
        }
    }

    Strategy strategy;
    String msg;

    Strategize(String msg) {
        strategy = new Soft();
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy s) {
        this.strategy = s;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {new Strategy() {
            @Override
            public String approach(String msg) {
                return msg.toUpperCase() + "~~";
            }
        },
                msg -> msg.substring(0,5),
                Unrelated::twice
        };

        Strategize strategize = new Strategize("hello magic");
        strategize.communicate();
        for (Strategy strategy:
                strategies
             ) {
            strategize.changeStrategy(strategy);
            strategize.communicate();
        }
    }
}
