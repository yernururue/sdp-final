package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public class AwayMode implements HomeMode {
    private static final double FROST_LIMIT  = 10.0;
    private static final double FROST_TARGET = 12.0;

    @Override
    public void handleEvent(SensorEvent event, HomeDevices devices) {
        switch (event.getType()) {
            case MOTION -> {
                System.out.println("[AwayMode] ALARM: motion at " + event.getSource());
                devices.lock().lock();
                devices.light().turnOn();
                System.out.println("[AwayMode] Owner notified: door locked, light on");
            }
            case TEMPERATURE -> {
                double temp = event.getValue();
                if (temp < FROST_LIMIT) {
                    System.out.println("[AwayMode] " + temp + "°C is below " + FROST_LIMIT
                            + "°C, heating to " + FROST_TARGET + "°C");
                    devices.thermostat().setTemperature(FROST_TARGET);
                } else {
                    System.out.println("[AwayMode] " + temp + "°C, nobody home, no action");
                }
            }
            default -> { }
        }
    }

    @Override
    public String getModeName() { return "AwayMode"; }
}
