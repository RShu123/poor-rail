package hu.frameworkpattern.poorrail.Domain;

public class RailVehicle {

    public Control Bestuurtype;

    public String proberenTeBesturen() {

        return Bestuurtype.bestuurbaar();
    }

    public void setBestuurA(Control newBestuurtype) {

        Bestuurtype = newBestuurtype;
    }
}
