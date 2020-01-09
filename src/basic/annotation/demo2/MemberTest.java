package basic.annotation.demo2;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/8 12:24
 */
public class MemberTest {
    @SqlString(30)
    String firstName;

    @SqlString(50)
    String lastName;

    @SqlInteger
    Integer age;

    @SqlString(value = 30,constraints = @Constraints(primaryKey = true))
    String reference;

    static int memberCount;

    @Override
    public String toString() {
        return "MemberTest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", reference='" + reference + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getReference() {
        return reference;
    }
}
