package designpattern.observer.example2;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @version 1.0
 * @ClassName Test
 * @date 2020/1/2 21:21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
      WeatherData weatherData = new WeatherData();
      new CurrentConditionDisplay(weatherData);
      new ForecastDisplay(weatherData);

      weatherData.setChange(22,22,11f);

      Thread.sleep(1000);
      weatherData.setChange(100,200,111);
    }
}
