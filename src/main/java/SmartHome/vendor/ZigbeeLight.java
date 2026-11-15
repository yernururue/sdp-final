package main.java.SmartHome.vendor;

public class ZigbeeLight {
    private boolean on = false;

    public void switchOn()     { this.on = true;  System.out.println("[ZigbeeLight] zigbee_cmd: SWITCH_ON"); }
    public void switchOff()    { this.on = false; System.out.println("[ZigbeeLight] zigbee_cmd: SWITCH_OFF"); }
    public String queryState() { return on ? "ZIGBEE_STATE_ON" : "ZIGBEE_STATE_OFF"; }
    public String deviceId()   { return "ZIGBEE-LIGHT-001"; }
}