package basic.base;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Parcel1
 * @date 2020/1/6 18:37
 */
public class Parcel1 {
    class Contents{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }

        String readLabel(){
            return label;
        }
    }

    void ship(String dest){
        Contents c = new Contents();
        System.out.println(c.value());
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }
    public static void main(String[] args){
      Parcel1 p = new Parcel1();
      p.ship("dest");
    }
}
