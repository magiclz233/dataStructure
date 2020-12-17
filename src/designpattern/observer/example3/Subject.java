package designpattern.observer.example3;


/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Observable
 * @date 2020/1/3 10:23
 */
public interface Subject {
    void notifyObservers(Object o);
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void deleteObservers();
    void setChanged();
    int countObservers();
}
