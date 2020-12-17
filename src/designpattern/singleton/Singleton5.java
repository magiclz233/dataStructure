package designpattern.singleton;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Singleton5
 * @date 2019/12/30 20:11
 */
public enum Singleton5 {
    INSTANCE;

    public void otherMethods(){
        System.out.println("调用枚举的方法");
    }

    public static void main(String[] args){
      Singleton5.INSTANCE.otherMethods();
    }
}
