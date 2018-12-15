package hu.frameworkpattern.poorrail.Commandpattern;

import hu.frameworkpattern.poorrail.Domain.Locomotief;
import hu.frameworkpattern.poorrail.Factory.LocomotiefFactory;
import hu.frameworkpattern.poorrail.Gui.RichRail;

public class DeleteLocomotief implements Command {

    private LocomotiefFactory locomotiefFactory = new LocomotiefFactory();
    private Locomotief locomotief;

    public DeleteLocomotief(Locomotief newLoco) {

        locomotief = newLoco;

    }

    @Override
    public void execute() {
        RichRail.locomotiefFactory.deleteLocomotief(locomotief);
        System.out.println("gelukt");
    }
}