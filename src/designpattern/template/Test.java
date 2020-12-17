package designpattern.template;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/4 20:07
 */
public class Test {
    public static void main(String[] args){
      Tea tea = new Tea();
      tea.prepareRecipe();
      Coffee coffee = new Coffee();
      coffee.prepareRecipe();

      TeaHook teaHook = new TeaHook();
      teaHook.prepareRecipe();
    }
}
