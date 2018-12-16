package hu.frameworkpattern.poorrail.newdomain;

import hu.frameworkpattern.poorrail.newdomain.Chair.ChairBuilder;

public class BuilderPattern {

    public static void main(String[] args) {
        // Create object with constructor
        Chair chair1 = new Chair(25.50, 1, 2, "Green", false, true);

        // Create object with setter methods
        Chair chair2 = new Chair();
        chair2.setWeight(25.50);
        chair2.setWeight(1);
        chair2.setHeight(2);
        chair2.setColour("Pink");
        chair2.setBelt(false);
        chair2.setAvailable(true);

        // Create object with builder pattern
        Chair chair3 = new ChairBuilder()
                .withWeight(25.50)
                .withWidth(1)
                .withHeight(2)
                .withColour("RED")
                .withBelt(false)
                .withAvailable(true)
                .build();

        System.out.println(chair1);
        System.out.println(chair2);
        System.out.println(chair3);
    }
}
