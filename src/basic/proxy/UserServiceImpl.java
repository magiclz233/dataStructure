package basic.proxy;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2020/3/31 15:56
 */
public class UserServiceImpl implements UserService {
    @Override
    public void insert() {
        System.out.println("插入操作");
    }

    @Override
    public void select() {
        System.out.println("查询操作");
    }
}
