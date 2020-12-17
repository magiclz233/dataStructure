package designpattern.template;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Duck
 * @date 2020/1/4 19:41
 */
public class Duck implements Comparable<Duck> {
    String name;
    int weight;

    public Duck(String name,int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Duck o) {
        Duck otherDuck = o;
        if(this.weight < otherDuck.weight){
            return -1;
        }else if(this.weight == otherDuck.weight){
            return 0;
        }else {
            return 1;
        }
    }
}
