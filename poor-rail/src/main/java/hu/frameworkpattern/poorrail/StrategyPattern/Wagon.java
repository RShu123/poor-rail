package hu.frameworkpattern.poorrail.StrategyPattern;

public class Wagon extends RailVehicles {

    public Wagon() {
        super();

        ControlType = new ItsNotControllable();

    }
}
