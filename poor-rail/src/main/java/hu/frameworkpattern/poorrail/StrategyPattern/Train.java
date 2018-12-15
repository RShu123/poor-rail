package hu.frameworkpattern.poorrail.StrategyPattern;

public class Train extends RailVehicles {

    public Train() {
        super();

        ControlType = new ItsControllable();

    }
}
