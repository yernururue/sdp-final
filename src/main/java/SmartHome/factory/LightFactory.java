package main.java.SmartHome.factory;

import main.java.SmartHome.adapter.ZigbeeLightAdapter;
import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.vendor.ZigbeeLight;

public class LightFactory extends DeviceFactory {
    @Override
    public SmartDevice createDevice() {
        return new ZigbeeLightAdapter(new ZigbeeLight());
    }
}