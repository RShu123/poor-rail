package hu.frameworkpattern.poorrail.Factory;

import hu.frameworkpattern.poorrail.Domain.Wagon;

import java.util.ArrayList;

public class WagonFactory {

    private ArrayList<Wagon> alleWagons = new ArrayList<>();
    boolean wagonExists = false;

    public void checkIfExists(String naam) {
        for (Wagon w : alleWagons) {
            if (w.getNaam().equals(naam)) {
                wagonExists = true;
            }
        }
    }

    public Wagon makeWagon(String command) {

        if (command.startsWith("new")) {
            String[] splitted = command.split(" ");
            String naam = splitted[2];

            checkIfExists(naam);

            if (command.startsWith("new wagon") && !command.contains("numseats")) {
                if (!wagonExists) {
                    Wagon w1 = new Wagon(naam);
                    System.out.println(w1);
                    alleWagons.add(w1);
                    return w1;
                }
            }

            if (command.startsWith("new wagon") && command.contains("numseats")) {
                if (!wagonExists) {
                    int aantalStoelen = Integer.parseInt(splitted[4]);
                    Wagon w2 = new Wagon()
                            .withName(naam)
                            .withAantalStoelen(aantalStoelen)
                            .build();
                    System.out.println(w2);
                    alleWagons.add(w2);
                    return w2;
                }
            }
        }
        return null;
    }

    public ArrayList<Wagon> getList() {
        return alleWagons;
    }

    public void deleteWagon(Wagon wagon) {
        this.alleWagons.remove(wagon);
    }


}