package hu.frameworkpattern.poorrail.Factory;

import hu.frameworkpattern.poorrail.Domain.Locomotief;

import java.util.ArrayList;

public class LocomotiefFactory {
    private ArrayList<Locomotief> alleLocomotieven = new ArrayList<>();
    private Locomotief locomotyfus = new Locomotief("test");
    boolean locomotiefExists = false;

    public void checkIfExists(String naam) {
        for (Locomotief loco : alleLocomotieven) {
            if (loco.getNaam().equals(naam)) {
                locomotiefExists = true;
            }
        }
    }

    public Locomotief makeLocomotief(String command) {
        String[] splitted = command.split(" ");
        String naam = splitted[2];

        checkIfExists(naam);

        if (command.startsWith("new train")) {
            if (!locomotiefExists) {
                Locomotief locomotief = new Locomotief(naam);
                alleLocomotieven.add(locomotief);
                return locomotief;
            }

        }
        return null;

    }

    public String getList() {
        String s = "";
        for (Locomotief loco : alleLocomotieven) {
            s += loco + "\t";
        }
        return s;

    }
}
