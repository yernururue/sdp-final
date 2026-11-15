package main.java.SmartHome.adapter;

import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.vendor.WifiThermostat;
import main.java.SmartHome.visitor.DeviceVisitor;

public class WifiThermostatAdapter implements SmartDevice {
    private final WifiThermostat thermostat;

    public WifiThermostatAdapter(WifiThermostat thermostat) {
        this.thermostat = thermostat;
    }

    @Override public void turnOn()  { thermostat.sendSetTemp(22.0); }
    @Override public void turnOff() { thermostat.sendSetTemp(18.0); }

    @Override
    public String getStatus() {
        return "Thermostat: " + thermostat.readTemp() + "°C | online=" + thermostat.isOnline();
    }

    @Override
    public String getName() { return "WifiThermostat [" + thermostat.ipAddress() + "]"; }

    public void setTemperature(double celsius) { thermostat.sendSetTemp(celsius); }
    public double getTemperature()             { return thermostat.readTemp(); }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
