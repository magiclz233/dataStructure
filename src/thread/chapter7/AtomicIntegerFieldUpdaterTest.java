package thread.chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName AtomicIntegerFieldUpdaterTest
 * @date 2020/1/14 17:55
 */
public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");
    public static void main(String[] args){
      User user = new User("magic",23);

      //age增长1
        System.out.println(a.getAndIncrement(user));

        System.out.println(a.get(user));

    }
    static class User{
        private String name;
        public volatile int age;

        public User(String name,int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
