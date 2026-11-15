package main.java.SmartHome.sensor;

public class SensorEvent {
    public enum Type { MOTION, TEMPERATURE, DOOR }

    private final Type type;
    private final String source;
    private final double value;

    public SensorEvent(Type type, String source, double value) {
        this.type = type;
        this.source = source;
        this.value = value;
    }

    public Type getType()     { return type; }
    public String getSource() { return source; }
    public double getValue()  { return value; }

    @Override
    public String toString() {
        return "SensorEvent{type=" + type + ", source='" + source + "', value=" + value + "}";
    }
}
