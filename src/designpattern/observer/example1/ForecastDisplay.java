package designpattern.observer.example1;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName CurrentConditDisplay
 * @date 2020/1/2 16:57
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float temp;
    private float hum;
    private float pressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("ForecastDisplay目前状况："+temp+"////"+hum);
    }

    @Override
    public void update(float temp, float hum, float pressure) {
        this.temp = temp;
        this.hum = hum;
        this.pressure = pressure;
        display();
    }
}
