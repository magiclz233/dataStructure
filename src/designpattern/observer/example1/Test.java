package designpattern.observer.example1;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName test
 * @date 2020/1/2 17:01
 */
public class Test {
    public static void main(String[] args){
      WeatherData weatherData = new WeatherData();
      //订阅的观察者
       new CurrentConditionDisplay(weatherData);
       new ForecastDisplay(weatherData);

      weatherData.setChange(80,65,30.4f);
      weatherData.setChange(100,100,30f);
    }
}
