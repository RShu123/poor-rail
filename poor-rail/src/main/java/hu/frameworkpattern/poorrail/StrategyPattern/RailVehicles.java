package hu.frameworkpattern.poorrail.StrategyPattern;

public class RailVehicles {
    private String naam;

    public Control ControlType;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String newName) {
        naam = newName;
    }

    public String tryToControl() {
        return ControlType.controllable();
    }

    public void setControlAbility(Control newControlType) {
        ControlType = newControlType;
    }
}
