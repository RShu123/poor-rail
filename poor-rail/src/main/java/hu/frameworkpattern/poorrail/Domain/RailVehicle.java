package hu.frameworkpattern.poorrail.Domain;

public class RailVehicle {

    public Besturen Bestuurtype;

    public String proberenTeBesturen() {

        return Bestuurtype.bestuurbaar();
    }

    public void setBestuurA(Besturen newBestuurtype) {

        Bestuurtype = newBestuurtype;
    }
}
