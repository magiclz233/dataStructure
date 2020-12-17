package designpattern.observer.example3;

import java.util.Vector;

/**
 * @author magic_lz
 * Description TODO
 * @version 1.0
 * @ClassName Observable
 * @date 2020/1/3 10:33
 */
public class Observable implements Subject {

    private boolean changed = false;
    private Vector<Observer> obs;

    public Observable(){
        obs = new Vector<>();
    }
    @Override
    public void notifyObservers(Object o) {
        Object[] arrObs;
        synchronized (this){
            if(!changed){
                return;
            }
            arrObs = obs.toArray();
            changed = false;
        }
        for (int i = arrObs.length-1;i>=0;i--){
            ((Observer)arrObs[i]).update(this,o);
        }
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        if(observer == null){
            throw new NullPointerException("传入的观察者为空");
        }
        if (!obs.contains(observer)){
            obs.add(observer);
        }
    }

    @Override
    public synchronized void deleteObserver(Observer observer) {
        obs.removeElement(observer);
    }

    @Override
    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    @Override
    public synchronized void setChanged() {
        changed = true;
    }

    @Override
    public synchronized int countObservers() {
        return obs.size();
    }

}
