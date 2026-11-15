package main.java.SmartHome.factory;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.vendor.BluetoothLock;

public class LockFactory extends DeviceFactory {
    @Override
    public SmartDevice createDevice() {
        return new BluetoothLockAdapter(new BluetoothLock());
    }
}