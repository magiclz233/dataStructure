package designpattern.exterior;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName HomeTheaterFacade
 * @date 2020/1/4 17:46
 */
public class HomeTheaterFacade {
    DVD dvd;
    //爆米花
    Popcorn popcorn;
    //投影仪
    Projector projector;
    Sound sound;
    public HomeTheaterFacade(){
        dvd = new DVD();
        popcorn = new Popcorn();
        projector = new Projector();
        sound = new Sound();
    }
    public void watchMovie(String movie){
        popcorn.start();
        popcorn.make();
        sound.start();
        dvd.start();
        projector.start();
        projector.set();
        projector.work();
        dvd.play(movie);
    }

    void endMovie(){
        /*
        不详细写了
         */
    }
}
