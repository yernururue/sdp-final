package main.java.SmartHome.visitor;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.adapter.ZigbeeLightAdapter;

public class EnergyConsumptionVisitor implements DeviceVisitor {
    private double totalWatts = 0.0;

    @Override
    public void visit(ZigbeeLightAdapter light) {
        double watts = light.getStatus().equals("ON") ? 10.0 : 0.5;
        totalWatts += watts;
        System.out.println("[Energy] Light power usage: " + watts + " W");
    }

    @Override
    public void visit(WifiThermostatAdapter thermostat) {
        double watts = 250.0;
        totalWatts += watts;
        System.out.println("[Energy] Thermostat power usage: " + watts + " W");
    }

    @Override
    public void visit(BluetoothLockAdapter lock) {
        double watts = 1.5;
        totalWatts += watts;
        System.out.println("[Energy] Lock power usage: " + watts + " W");
    }

    public double getTotalWatts() {
        return totalWatts;
    }
}
