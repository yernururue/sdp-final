package main.java.SmartHome.visitor;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.adapter.ZigbeeLightAdapter;

public class DiagnosticsVisitor implements DeviceVisitor {
    @Override
    public void visit(ZigbeeLightAdapter light) {
        System.out.println("[Diagnostics] Checking Light " + light.getName() + " -> Status: OK, State: " + light.getStatus());
    }

    @Override
    public void visit(WifiThermostatAdapter thermostat) {
        System.out.println("[Diagnostics] Checking Thermostat " + thermostat.getName() + " -> Status: OK, Temp: " + thermostat.getTemperature() + "°C");
    }

    @Override
    public void visit(BluetoothLockAdapter lock) {
        System.out.println("[Diagnostics] Checking Lock " + lock.getName() + " -> Status: OK, State: " + lock.getStatus());
    }
}
