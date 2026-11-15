package main.java.SmartHome.adapter;

import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.vendor.BluetoothLock;
import main.java.SmartHome.visitor.DeviceVisitor;

public class BluetoothLockAdapter implements SmartDevice {
    private final BluetoothLock lock;

    public BluetoothLockAdapter(BluetoothLock lock) {
        this.lock = lock;
    }

    @Override public void turnOn()  { lock.sendUnlockSignal(); }
    @Override public void turnOff() { lock.sendLockSignal(); }

    @Override
    public String getStatus() { return lock.getLockState() ? "LOCKED" : "UNLOCKED"; }

    @Override
    public String getName() { return "BluetoothLock [" + lock.macAddress() + "]"; }

    public void lock()   { lock.sendLockSignal(); }
    public void unlock() { lock.sendUnlockSignal(); }

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}
