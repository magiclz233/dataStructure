package designpattern.observer.example1;

import java.util.ArrayList;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName WeatherData
 * @date 2020/1/2 16:41
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temp;
    private float hum;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temp, hum, pressure);
        }
    }

    public void change(){
        notifyObservers();
    }

    public void setChange(float temp,float hum,float pressure){
        this.temp = temp;
        this.hum = hum;
        this.pressure = pressure;
        change();
    }
}
