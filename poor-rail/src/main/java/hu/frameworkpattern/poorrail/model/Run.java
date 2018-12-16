package hu.frameworkpattern.poorrail.model;

import hu.frameworkpattern.poorrail.Gui.RichRail;

import java.awt.*;

public class Run {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				RichRail frame = new RichRail();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}