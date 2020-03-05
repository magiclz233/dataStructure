package basic.proxy;

/**
 * @author magic_lz
 * @version 1.0
 * @date 2020/3/4 11:12
 */
public class CommonDaoImpl implements CommonDao {
    @Override
    public int insert(int a, int b) {
        return a + b;
    }

    @Override
    public int delete(int a, int b) {
        return a - b;
    }
}
