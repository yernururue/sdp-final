package main.java.SmartHome.sensor;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    private final List<SensorObserver> observers = new ArrayList<>();

    public void subscribe(SensorObserver observer)   { observers.add(observer); }
    public void unsubscribe(SensorObserver observer) { observers.remove(observer); }

    protected void notifyObservers(SensorEvent event) {
        for (SensorObserver observer : observers) {
            observer.onEvent(event);
        }
    }
}