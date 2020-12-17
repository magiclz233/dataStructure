package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName BuilderPatternDemo
 * @date 2020/1/2 14:13
 */
public class BuilderPatternDemo {
    public static void main(String[] args){
      MealBuilder builder = new MealBuilder();

        Meal vegMeal = builder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Cost:"+vegMeal.getCost());

        System.out.println("\n\n");
        Meal nonVegMeal = builder.prepareNonVegMeal();
        nonVegMeal.showItems();
        System.out.println(nonVegMeal.getCost());
    }
}
