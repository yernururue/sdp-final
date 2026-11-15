package main.java.SmartHome.factory;

import main.java.SmartHome.device.SmartDevice;

public abstract class DeviceFactory {
    public abstract SmartDevice createDevice();

    public SmartDevice getDevice() {
        SmartDevice device = createDevice();
        System.out.println("[Factory] Device created: " + device.getName());
        return device;
    }
}