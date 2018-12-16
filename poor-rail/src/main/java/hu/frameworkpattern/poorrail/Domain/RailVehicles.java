package hu.frameworkpattern.poorrail.Domain;

public class RailVehicles {

    public Control ControlType;


    public String tryToControl() {
        return ControlType.controllable();
    }

    public void setControlAbility(Control newControlType) {
        ControlType = newControlType;
    }
}
