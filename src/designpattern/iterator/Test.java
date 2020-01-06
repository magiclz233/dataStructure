package designpattern.iterator;


/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/5 17:41
 */
public class Test {
    public static void main(String[] args){
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu d = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu,d);
        //打印菜单
        waitress.printMenu();
    }
}
