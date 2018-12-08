package hu.frameworkpattern.richrailgrammer;

import hu.frameworkpattern.poorrail.grammar.RichRailBaseListener;
import hu.frameworkpattern.poorrail.grammar.RichRailParser;

public class RichRailCommand extends RichRailBaseListener {
	
	@Override
	public void enterCommand(RichRailParser.CommandContext ctx) {
		System.out.println("Command entered " + ctx.getText());
	}
	
	@Override public void enterNewcommand(RichRailParser.NewcommandContext ctx) {
		System.out.println("Now creating new train " + ctx.getText());
	}

	@Override public void enterDelcommand(RichRailParser.DelcommandContext ctx) {
		System.out.println("Now deleting train " + ctx.getText());
	}
}
