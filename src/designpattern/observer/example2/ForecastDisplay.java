package designpattern.observer.example2;

import designpattern.observer.example1.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author magic_lz
 * Description TODO 观察者实现Observer接口，重写update方法
 * @version 1.0
 * @ClassName ForecastDisplay
 * @date 2020/1/2 20:57
 */
public class ForecastDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temp;
    private float hum;
    private float pressure;
    /**
     * @param o 传入订阅的主题
     * @param arg 订阅的主题携带的数据对象，没有则为空
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.pressure = weatherData.getPressure();
            this.hum = weatherData.getHum();
            display();
        }
    }

    public ForecastDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("ForecastDisplay:"+temp+"////"+hum+"////"+pressure);
    }
}
