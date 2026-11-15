package main.java.SmartHome.strategy;

import main.java.SmartHome.sensor.SensorEvent;

public class NightMode implements HomeMode {
    private static final double TOO_COLD   = 18.0;
    private static final double TOO_WARM   = 24.0;
    private static final double WARM_UP_TO = 20.0;
    private static final double COOL_TO    = 22.0;

    @Override
    public void handleEvent(SensorEvent event, HomeDevices devices) {
        switch (event.getType()) {
            case MOTION -> {
                System.out.println("[NightMode] Motion at " + event.getSource() + ", turning night light on");
                devices.light().turnOn();
            }
            case TEMPERATURE -> {
                double temp = event.getValue();
                if (temp < TOO_COLD) {
                    System.out.println("[NightMode] " + temp + "°C is too cold, setting thermostat to " + WARM_UP_TO + "°C");
                    devices.thermostat().setTemperature(WARM_UP_TO);
                } else if (temp > TOO_WARM) {
                    System.out.println("[NightMode] " + temp + "°C is too warm, setting thermostat to " + COOL_TO + "°C");
                    devices.thermostat().setTemperature(COOL_TO);
                } else {
                    System.out.println("[NightMode] " + temp + "°C is in range, no action");
                }
            }
            default -> { }
        }
    }

    @Override
    public String getModeName() { return "NightMode"; }
}
