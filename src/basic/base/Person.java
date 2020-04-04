package basic.base;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/27 18:30
 */
public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void cross(Person person){
        System.out.println(person.getName());
        person = new Person();
        person.setName("岳云鹏");
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("马化腾");
        cross(p);
        System.out.println("1"+p.getName());
    }
}