package designpattern.observer.example1;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Observer
 * @date 2020/1/2 16:36
 */
public interface Observer {
    public void update(float temp, float hum, float pressure);
}
