package designpattern.observer.example1;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName CurrentConditDisplay
 * @date 2020/1/2 16:57
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temp;
    private float hum;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay目前状况："+temp+"////"+hum);
    }

    @Override
    public void update(float temp, float hum, float pressure) {
        this.temp = temp;
        this.hum = hum;
        display();
    }
}
