package main.java.SmartHome.sensor;

public class TemperatureSensor extends Sensor {
    private final String location;

    public TemperatureSensor(String location) { this.location = location; }

    public void measure(double celsius) {
        System.out.println("[TempSensor] Temperature at " + location + ": " + celsius + "°C");
        notifyObservers(new SensorEvent(SensorEvent.Type.TEMPERATURE, location, celsius));
    }
}
