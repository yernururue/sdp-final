package main.java.SmartHome.adapter;

import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.vendor.ZigbeeLight;
import main.java.SmartHome.visitor.DeviceVisitor;

public class ZigbeeLightAdapter implements SmartDevice {
    private final ZigbeeLight zigbeeLight;

    public ZigbeeLightAdapter(ZigbeeLight zigbeeLight) {
        this.zigbeeLight = zigbeeLight;
    }

    @Override public void turnOn()  { zigbeeLight.switchOn(); }
    @Override public void turnOff() { zigbeeLight.switchOff(); }

    @Override
    public String getStatus() {
        return zigbeeLight.queryState().contains("ON") ? "ON" : "OFF";
    }

    @Override
    public String getName() { return "ZigbeeLight [" + zigbeeLight.deviceId() + "]"; }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
