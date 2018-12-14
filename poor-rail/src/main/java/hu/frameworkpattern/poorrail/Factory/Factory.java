package hu.frameworkpattern.poorrail.Factory;

import hu.frameworkpattern.poorrail.Domain.Locomotief;

public class Factory {


    public Locomotief makeLocomotief(String command) {
        String[] splitted = command.split(" ");
        String naam = splitted[2];

        if (command.startsWith("new locomotief")) {
            return new Locomotief(naam);
        } else {
            return null;
        }
    }
}
