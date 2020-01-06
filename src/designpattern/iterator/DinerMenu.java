package designpattern.iterator;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName DinerMenu
 * @date 2020/1/5 18:01
 */
public class DinerMenu {
    public static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];

        addItems("套餐一","炒面,啤酒",true,10);
        addItems("套餐二","炸鸡,可乐",false,20);
    }


    public void addItems(String name,String desc,boolean ve,double price){
        MenuItem m = new MenuItem(name,desc,ve,price);
        if(numberOfItems >= MAX_ITEMS){
            System.out.println("数组已满,无法插入菜单");
        }else {
            menuItems[numberOfItems] = m;
            numberOfItems = numberOfItems + 1;
        }
    }

    //会暴露内部的结构实现
//    public MenuItem[] getMenuItems(){
//        return menuItems;
//    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
