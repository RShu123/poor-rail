package hu.frameworkpattern.poorrail.paf.ass2;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::start);
    }

    private static void start() {
        PoorRail inst = new PoorRail();
        inst.setLocationRelativeTo(null);
        inst.setVisible(true);
    }

}