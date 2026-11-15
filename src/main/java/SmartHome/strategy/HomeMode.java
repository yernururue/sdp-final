package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public interface HomeMode {
    void handleEvent(SensorEvent event);
    String getModeName();
}