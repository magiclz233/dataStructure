package thread.chapter7;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName AtomicReferenceTest
 * @date 2020/1/14 16:13
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args){
        User user = new User("magic",23);
        atomicReference.set(user);
        User updateUser = new User("zhangsan",22);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getName());
        System.out.println(atomicReference.get().getAge());
    }
    static class User{
        private String name;
        private int age;

        User(String name,int age){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
