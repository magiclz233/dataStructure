package designpattern.iterator;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName DinnerMenuIterator
 * @date 2020/1/5 17:48
 */
public class DinerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    //记录当前数组遍历位置
    int position = 0;

    public DinerMenuIterator(MenuItem[] m){
        this.menuItems = m;
    }
    @Override
    public boolean hasNext() {
        if(position >= menuItems.length || menuItems[position] == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position = position + 1;
        return menuItem;
    }
}
