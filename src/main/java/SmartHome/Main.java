package main.java.SmartHome;

import main.java.SmartHome.adapter.BluetoothLockAdapter;
import main.java.SmartHome.adapter.WifiThermostatAdapter;
import main.java.SmartHome.device.SmartDevice;
import main.java.SmartHome.facade.SmartHomeFacade;
import main.java.SmartHome.factory.*;
import main.java.SmartHome.sensor.*;
import main.java.SmartHome.strategy.EcoMode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Smart Home System Starting ===\n");

        SmartDevice light                = new LightFactory().getDevice();
        WifiThermostatAdapter thermostat = (WifiThermostatAdapter) new ThermostatFactory().getDevice();
        BluetoothLockAdapter  lock       = (BluetoothLockAdapter)  new LockFactory().getDevice();

        AutomationRule rule          = new AutomationRule(new EcoMode());
        MotionSensor entranceSensor  = new MotionSensor("Front Door");
        TemperatureSensor tempSensor = new TemperatureSensor("Living Room");
        entranceSensor.subscribe(rule);
        tempSensor.subscribe(rule);

        SmartHomeFacade home = new SmartHomeFacade(light, thermostat, lock, rule);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║      Smart Home Menu          ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  1. Leave Home (Away Mode)    ║");
            System.out.println("║  2. Good Night (Night Mode)   ║");
            System.out.println("║  3. Status                    ║");
            System.out.println("║  4. Simulate Motion Sensor    ║");
            System.out.println("║  5. Simulate Temperature      ║");
            System.out.println("║  6. Run Diagnostics (Visitor) ║");
            System.out.println("║  7. Energy Usage (Visitor)    ║");
            System.out.println("║  0. Exit                      ║");
            System.out.println("╚══════════════════════════════╝");
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
                    System.out.println("Goodbye! 👋");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
