package designpattern.exterior;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/4 17:58
 */
public class Test {
    public static void main(String[] args){
      HomeTheaterFacade facade = new HomeTheaterFacade();
      facade.watchMovie("一代宗师");
    }
}
