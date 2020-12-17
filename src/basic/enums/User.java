package basic.enums;

import java.util.Arrays;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName USER
 * @date 2020/1/6 21:13
 */
public enum User {

    /*
    user
     */
    MAN("张三",20),WOMAN("李四",23);

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    /**
     * 构造方法
     * @param name 姓名
     * @param age 年龄
     */
    private User(String name,int age){
        this.name = name;
        this.age = age;
    }

    public static User getAgeByName(String name){
        for (User u:User.values()){
            if(u.name.equals(name)){
                return u;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args){
        User[] values = User.values();
        Arrays.asList(values).forEach(v->System.out.println(v.age+v.name));
        User user = User.getAgeByName("张三");

        if(user != null){
            System.out.println(user.age+user.name);
        }
    }
}
