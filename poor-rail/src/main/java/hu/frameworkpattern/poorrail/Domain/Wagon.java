package hu.frameworkpattern.poorrail.Domain;

public class Wagon extends RailVehicles {

    private String naam;
    private long aantalStoelen = 20;

    public Wagon() {
        super();

        ControlType = new ItsNotControllable();
    }

    public Wagon(String nm) {
        naam = nm;
        aantalStoelen = 20;
    }

    public Wagon(String nm, long aantStoel) {
        naam = nm;
        aantalStoelen = aantStoel;
    }

    public Wagon withName(String nm) {
        this.naam = nm;
        return this;
    }

    public Wagon withAantalStoelen(long aantStoel) {
        this.aantalStoelen = aantStoel;
        return this;
    }

    public Wagon build() {
        return new Wagon(naam, aantalStoelen);
    }

    public long getStoel() {
        return aantalStoelen;
    }

    public String getNaam() {
        return naam;
    }

    public void delete() {
    }

    ;

    public String toString() {
        String s = naam + " met aantal stoelen: " + aantalStoelen;

        return s;
    }

}
