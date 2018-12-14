package hu.frameworkpattern.poorrail.Domain;

public class Wagon {

    private String naam;
    private long aantalStoelen;
    private String type;

    public Wagon(String nm) {
        naam = nm;
        aantalStoelen = 20;
        type = "wagon";
    }

    public Wagon(String nm, long aantStoel) {
        naam = nm;
        aantalStoelen = aantStoel;
        type = "wagon";
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
