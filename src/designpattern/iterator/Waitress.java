package designpattern.iterator;

/**
 * @author magic_lz
 * Description TODO 服务员
 * @version 1.0
 * @ClassName Waitress
 * @date 2020/1/5 18:15
 */
public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu p,DinerMenu d){
        this.pancakeHouseMenu = p;
        this.dinerMenu = d;
    }

    public void printMenu(){
        Iterator pancakeHouseMenuIterator = (Iterator) pancakeHouseMenu.createIterator();
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        System.out.println("煎饼屋菜单");
        printMenu(pancakeHouseMenuIterator);
        System.out.println("晚餐菜单");
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getDescription());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.isVegetarian());
        }
    }
}
