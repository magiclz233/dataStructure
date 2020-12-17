package designpattern.builder;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName MealBuilder
 * @date 2020/1/2 14:05
 */
public class MealBuilder {
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
