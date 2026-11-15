package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public class AwayMode implements HomeMode {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEvent.Type.MOTION) {
            System.out.println("[AwayMode] ⚠️  ALARM! Motion at: " + event.getSource());
            System.out.println("[AwayMode] 📱 Sending alert to owner...");
        }
    }

    @Override
    public String getModeName() { return "AwayMode"; }
}
