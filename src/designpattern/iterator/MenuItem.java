package designpattern.iterator;

/**
 * @author magic_lz
 * Description TODO 菜单
 * @version 1.0
 * @ClassName MenuItem
 * @date 2020/1/5 17:53
 */
public class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(){}

    public MenuItem(String name,
            String description,
            boolean vegetarian,
            double price){
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
