package hu.frameworkpattern.poorrail.Domain;

public class Railvoertuig {

    public Besturen Bestuurtype;

    public String proberenTeBesturen() {

        return Bestuurtype.bestuurbaar();
    }

    public void setBestuurA(Besturen newBestuurtype) {

        Bestuurtype = newBestuurtype;
    }
}
