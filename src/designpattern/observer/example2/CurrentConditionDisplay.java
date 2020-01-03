package designpattern.observer.example2;

import designpattern.observer.example1.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName CurrentConditionDisplay
 * @date 2020/1/2 21:16
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temp;
    private float hum;

    public CurrentConditionDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay:"+temp+"////"+hum);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.hum = weatherData.getHum();
            display();
        }
    }
}
