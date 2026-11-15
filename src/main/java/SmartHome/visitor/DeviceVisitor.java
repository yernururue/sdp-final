package main.java.SmartHome.visitor;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.adapter.ZigbeeLightAdapter;

public interface DeviceVisitor {
    void visit(ZigbeeLightAdapter light);
    void visit(WifiThermostatAdapter thermostat);
    void visit(BluetoothLockAdapter lock);
}
