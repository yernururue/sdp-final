package main.java.SmartHome.sensor;

public interface SensorObserver {
    void onEvent(SensorEvent event);
}