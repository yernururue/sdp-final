package main.java.SmartHome.device;

import main.java.SmartHome.visitor.DeviceVisitor;

public interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
    String getName();
    void accept(DeviceVisitor visitor);
}
