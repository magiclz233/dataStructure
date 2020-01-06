package designpattern.combination;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/5 19:59
 */
public class Test {
    public static void main(String[] args){
        Employee CEO = new Employee("张三","CEO", 30000);

        Employee headSales = new Employee("李四","Head Sales", 20000);

        Employee headMarketing = new Employee("王五","Head Marketing", 20000);

        Employee clerk1 = new Employee("赵六","Marketing", 10000);
        Employee clerk2 = new Employee("孙七","Marketing", 10000);

        Employee salesExecutive1 = new Employee("王八","Sales", 10000);
        Employee salesExecutive2 = new Employee("阿九","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //打印CEO该组织的所有员工
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
