package main.java.SmartHome.sensor;

import main.java.SmartHome.strategy.HomeMode;

public class AutomationRule implements SensorObserver {
    private HomeMode currentMode;

    public AutomationRule(HomeMode initialMode) {
        this.currentMode = initialMode;
    }

    public void setMode(HomeMode newMode) {
        System.out.println("[AutomationRule] Mode switched to: " + newMode.getModeName());
        this.currentMode = newMode;
    }

    public HomeMode getCurrentMode() { return currentMode; }

    @Override
    public void onEvent(SensorEvent event) {
        System.out.println("[AutomationRule] Event received — delegating to " + currentMode.getModeName());
        currentMode.handleEvent(event);
    }
}