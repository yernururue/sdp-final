package main.java.SmartHome.vendor;

public class BluetoothLock {
    private boolean locked = true;

    public void sendLockSignal()   { this.locked = true;  System.out.println("[BluetoothLock] BT_CMD: LOCK"); }
    public void sendUnlockSignal() { this.locked = false; System.out.println("[BluetoothLock] BT_CMD: UNLOCK"); }
    public boolean getLockState()  { return locked; }
    public String macAddress()     { return "AA:BB:CC:DD:EE:FF"; }
}