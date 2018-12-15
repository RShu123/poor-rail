package hu.frameworkpattern.poorrail.Commandpattern;

import hu.frameworkpattern.poorrail.Domain.Locomotief;
import hu.frameworkpattern.poorrail.Domain.Wagon;
import hu.frameworkpattern.poorrail.Factory.LocomotiefFactory;
import hu.frameworkpattern.poorrail.Factory.WagonFactory;

import java.util.ArrayList;

public class AddWagonToTrain implements Command {

    private LocomotiefFactory locoFactory = new LocomotiefFactory();
    private WagonFactory wagonFactory = new WagonFactory();

    private ArrayList<Locomotief> locomotieven;
    private ArrayList<Wagon> wagons;
    private Locomotief locomotief;
    private Wagon wagon;
    boolean locomotiefExists = false;
    boolean wagonExists = false;

    public AddWagonToTrain(Locomotief newLoco, Wagon newWagon) {
        locomotief = newLoco;
        wagon = newWagon;
    }

    ;

    @Override
    public void execute() {
        locomotief.addWagon(wagon);
        System.out.println("gelukt");
    }
}
