package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public class EcoMode implements HomeMode {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEvent.Type.TEMPERATURE) {
            System.out.println("[EcoMode] 🌿 Adjusting thermostat for energy saving.");
        }
    }

    @Override
    public String getModeName() { return "EcoMode"; }
}
