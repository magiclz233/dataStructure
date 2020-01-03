package designpattern.decorator;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/3 15:50
 */
public class Test {
    public static void main(String[] args){
        //111
      Beverage beverage = new Latte();
      System.out.println(beverage.getDescription()+"$"+beverage.cost());

      //222
        System.out.println("~~~~~~~~~~~~~\n");
        Beverage b = new Latte();
        b.setSize(2);

        int size = b.getSize();
        System.out.println(size);
        //加一份糖
        b = new Sugar(b);
        //加一份抹茶
        b = new Mocha(b);
        //再加一份抹茶
        b= new Mocha(b);
        System.out.println(b.getDescription()+"$"+b.cost());

    }
}
