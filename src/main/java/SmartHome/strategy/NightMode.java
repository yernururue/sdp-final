package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public class NightMode implements HomeMode {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEvent.Type.MOTION) {
            System.out.println("[NightMode] 🌙 Motion detected — dimming lights softly.");
        } else if (event.getType() == SensorEvent.Type.TEMPERATURE && event.getValue() < 18) {
            System.out.println("[NightMode] ❄️  Too cold! Raising thermostat.");
        }
    }

    @Override
    public String getModeName() { return "NightMode"; }
}