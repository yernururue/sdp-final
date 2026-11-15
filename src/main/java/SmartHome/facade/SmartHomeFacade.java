package main.java.SmartHome.facade;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.sensor.AutomationRule;
import main.java.SmartHome.strategy.AwayMode;
import main.java.SmartHome.strategy.NightMode;
import main.java.SmartHome.visitor.DeviceVisitor;
import main.java.SmartHome.visitor.DiagnosticsVisitor;
import main.java.SmartHome.visitor.EnergyConsumptionVisitor;

import java.util.List;

public class SmartHomeFacade {
    private final SmartDevice light;
    private final WifiThermostatAdapter thermostat;
    private final BluetoothLockAdapter lock;
    private final AutomationRule automationRule;
    private final List<SmartDevice> devices;

    public SmartHomeFacade(SmartDevice light, WifiThermostatAdapter thermostat,
                           BluetoothLockAdapter lock, AutomationRule automationRule) {
        this.light = light;
        this.thermostat = thermostat;
        this.lock = lock;
        this.automationRule = automationRule;
        this.devices = List.of(light, thermostat, lock);
    }

    public void leaveHome() {
        System.out.println("\n=== leaveHome() ===");
        automationRule.setMode(new AwayMode());
        light.turnOff();
        thermostat.setTemperature(18.0);
        lock.lock();
    }

    public void goodNight() {
        System.out.println("\n=== goodNight() ===");
        automationRule.setMode(new NightMode());
        light.turnOff();
        thermostat.setTemperature(20.0);
        lock.lock();
    }

    public void status() {
        System.out.println("\n=== status() ===");
        System.out.println("Mode   : " + automationRule.getCurrentMode().getModeName());
        System.out.println("Light  : " + light.getStatus());
        System.out.println("Thermo : " + thermostat.getStatus());
        System.out.println("Lock   : " + lock.getStatus());
    }

    public void runDiagnostics() {
        System.out.println("\n=== Running System Diagnostics (Visitor) ===");
        DeviceVisitor diagnostics = new DiagnosticsVisitor();
        for (SmartDevice device : devices) {
            device.accept(diagnostics);
        }
    }

    public void calculateEnergy() {
        System.out.println("\n=== Calculating Energy Consumption (Visitor) ===");
        EnergyConsumptionVisitor energy = new EnergyConsumptionVisitor();
        for (SmartDevice device : devices) {
            device.accept(energy);
        }
        System.out.println("Total power: " + energy.getTotalWatts() + " W");
    }
}
