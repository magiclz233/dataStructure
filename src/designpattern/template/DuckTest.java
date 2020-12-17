package designpattern.template;

import java.util.Arrays;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName DuckTest
 * @date 2020/1/4 19:47
 */
public class DuckTest {
    public static void main(String[] args){
        Duck[] ducks = {new Duck("d1",1),
        new Duck("d2",2),new Duck("d3",1),new Duck("d4",3)};
        display(ducks);
        Arrays.sort(ducks);
        System.out.println("~~~~~~");
        display(ducks);
    }

    static void display(Duck[] ducks){
        for (Duck d :
                ducks) {
           System.out.println(d.toString());
        }
    }
}
