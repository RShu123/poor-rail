package hu.frameworkpattern.poorrail.StrategyPattern;

public class VehiclesGo {

    public static void main(String[] args) {

        RailVehicles r1 = new Train();

        RailVehicles r2 = new Wagon();

        System.out.println("Trein " + r1.tryToControl());
        System.out.println("Wagon " + r2.tryToControl());
    }
}
