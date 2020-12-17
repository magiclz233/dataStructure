package designpattern.observer.example2;

import java.util.Observable;

/**
 * @author magic_lz
 * Description TODO 继承Observable的具体主题
 * @version 1.0
 * @ClassName WeatherData
 * @date 2020/1/2 20:20
 */
public class WeatherData extends Observable {
    /*
    首先，继承Observable类，然后：
    1：先调用setChanged方法，改变标记状态为true
    2：然后调用两种notifyObservers()/notifyObservers(Object o)之一 （Object传的是主题发给观察者的任意数据）

    注意：在调用notifyObservers()方法之前必须调用setChanged方法。否则观察者不会收到数据消息，这样可以让你在更新主题时
    有更多的弹性，比如，主题每秒都会变化生成数据，但是数据太小时不需要通知，那么可以定义。当数据变化超过多少，setChanged为true，
    或者每隔多少秒setChanged为true。

    当调用完notifyObservers()方法之后，会设置标记状态为false。
     */

    private float temp;
    private float hum;
    private float pressure;

    public WeatherData(){}

    public void change(){
        //改变标记状态为true
        setChanged();
        //当没有传入数据时，表示使用的方式时观察者拉取数据
        notifyObservers();
    }

    public void setChange(float temp,float hum,float pressure){
        this.hum = hum;
        this.temp = temp;
        this.pressure = pressure;
        change();
    }

    public float getTemp(){
        return this.temp;
    }

    public float getHum() {
        return hum;
    }

    public float getPressure() {
        return pressure;
    }

}
