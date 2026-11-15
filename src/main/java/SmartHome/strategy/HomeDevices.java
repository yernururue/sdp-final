package main.java.SmartHome.strategy;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.device.SmartDevice;

public record HomeDevices(SmartDevice light,
                          WifiThermostatAdapter thermostat,
                          BluetoothLockAdapter lock) {
}
