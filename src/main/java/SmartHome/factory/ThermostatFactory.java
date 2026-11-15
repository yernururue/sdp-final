package main.java.SmartHome.factory;

import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.vendor.WifiThermostat;

public class ThermostatFactory extends DeviceFactory {
    @Override
    public SmartDevice createDevice() {
        return new WifiThermostatAdapter(new WifiThermostat());
    }
}
