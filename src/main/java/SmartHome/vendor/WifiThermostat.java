package main.java.SmartHome.vendor;

public class WifiThermostat {
    private double temperature = 22.0;

    public void sendSetTemp(double celsius) {
        this.temperature = celsius;
        System.out.println("[WifiThermostat] HTTP POST /setTemp -> " + celsius + "°C");
    }
    public double readTemp()  { return temperature; }
    public String ipAddress() { return "192.168.1.42"; }
    public boolean isOnline() { return true; }
}