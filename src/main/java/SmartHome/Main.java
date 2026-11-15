package main.java.SmartHome;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.facade.SmartHomeFacade;
import main.java.SmartHome.factory.*;
import main.java.SmartHome.sensor.*;
import main.java.SmartHome.strategy.EcoMode;
import main.java.SmartHome.strategy.HomeDevices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Home System Starting ===\n");

        SmartDevice light                = new LightFactory().getDevice();
        WifiThermostatAdapter thermostat = (WifiThermostatAdapter) new ThermostatFactory().getDevice();
        BluetoothLockAdapter  lock       = (BluetoothLockAdapter)  new LockFactory().getDevice();

        AutomationRule rule          = new AutomationRule(new EcoMode(),
                                                          new HomeDevices(light, thermostat, lock));
        MotionSensor entranceSensor  = new MotionSensor("Front Door");
        TemperatureSensor tempSensor = new TemperatureSensor("Living Room");
        entranceSensor.subscribe(rule);
        tempSensor.subscribe(rule);

        SmartHomeFacade home = new SmartHomeFacade(light, thermostat, lock, rule);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Smart Home Menu ---");
            System.out.println("1. Leave home (Away mode)");
            System.out.println("2. Good night (Night mode)");
            System.out.println("3. Status");
            System.out.println("4. Simulate motion sensor");
            System.out.println("5. Simulate temperature");
            System.out.println("6. Run diagnostics");
            System.out.println("7. Energy usage");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> home.leaveHome();
                case "2" -> home.goodNight();
                case "3" -> home.status();
                case "4" -> entranceSensor.detectMotion();
                case "5" -> {
                    System.out.print("Enter temperature (°C): ");
                    try {
                        double temp = Double.parseDouble(scanner.nextLine().trim());
                        tempSensor.measure(temp);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid temperature!");
                    }
                }
                case "6" -> home.runDiagnostics();
                case "7" -> home.calculateEnergy();
                case "0" -> {
                    System.out.println("Exiting.");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
