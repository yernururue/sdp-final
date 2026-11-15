package main.java.SmartHome.sensor;

public class MotionSensor extends Sensor {
    private final String location;

    public MotionSensor(String location) { this.location = location; }

    public void detectMotion() {
        System.out.println("[MotionSensor] Motion detected at: " + location);
        notifyObservers(new SensorEvent(SensorEvent.Type.MOTION, location, 1.0));
    }
}