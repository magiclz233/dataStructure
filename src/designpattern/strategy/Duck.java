package designpattern.strategy;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Duck
 * @date 2020/1/2 14:49
 */
public abstract class Duck {
     Fly fly;
     Quack quack;
    public Duck(){

    }

    public abstract void display();

    public void performFly(){
        fly.fly();
    }

    public void performQuack(){
        quack.quack();
    }

    public void setFly(Fly fly){
        this.fly = fly;
    }

    public void setQuack(Quack quack){
        this.quack = quack;
    }
    public void swim(){
        System.out.println("所有的鸭子都会游泳！");
    }
}
