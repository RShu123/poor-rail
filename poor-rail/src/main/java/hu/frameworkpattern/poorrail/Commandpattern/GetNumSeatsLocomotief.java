package hu.frameworkpattern.poorrail.Commandpattern;

import hu.frameworkpattern.poorrail.Domain.Locomotief;
import hu.frameworkpattern.poorrail.Gui.RichRail;

import java.awt.*;

public class GetNumSeatsLocomotief implements Command {

    Locomotief locomotief;
    Graphics output = RichRail.outputPanel.getGraphics();

    public GetNumSeatsLocomotief(Locomotief newLoco) {
        locomotief = newLoco;
    }

    @Override
    public void execute() {

        RichRail.currentNumberOfOutputs += 20;
        output.setColor(Color.white);
        output.drawString("number of seats in train " + locomotief.getNaam() + ": " + String.valueOf(locomotief.getAantalStoelen()), 5, RichRail.currentNumberOfOutputs);

    }

}
