package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public class EcoMode implements HomeMode {
    private static final double MIN_COMFORT = 19.0;
    private static final double MAX_COMFORT = 24.0;
    private static final double ECO_TARGET  = 21.0;

    @Override
    public void handleEvent(SensorEvent event, HomeDevices devices) {
        switch (event.getType()) {
            case MOTION -> {
                System.out.println("[EcoMode] Motion at " + event.getSource() + ", turning light on");
                devices.light().turnOn();
            }
            case TEMPERATURE -> {
                double temp = event.getValue();
                if (temp < MIN_COMFORT || temp > MAX_COMFORT) {
                    System.out.println("[EcoMode] " + temp + "°C is out of range "
                            + MIN_COMFORT + "-" + MAX_COMFORT + "°C, setting thermostat to " + ECO_TARGET + "°C");
                    devices.thermostat().setTemperature(ECO_TARGET);
                } else {
                    System.out.println("[EcoMode] " + temp + "°C is in range, no action");
                }
            }
            default -> { }
        }
    }

    @Override
    public String getModeName() { return "EcoMode"; }
}
