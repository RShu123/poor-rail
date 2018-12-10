package hu.frameworkpattern.poorrail.newdomain;

public class Wagon3 implements newWagon {
	
	private String naam;
	private int aantalStoelen;
	private String type;
	private String color;

	public Wagon3(String nm) {
		naam = nm;
		aantalStoelen = 40;
		type = "wagon";
		color = "green";
	}

	public int getStoel() {
		return aantalStoelen;
	}

	public String getNaam() {
		return naam;
	}

	public void delete() {
		throw new RuntimeException("Method implementation required");
	}
	
	public String toString() {
    	String s = naam + " met aantal stoelen: " + aantalStoelen;
    	return s;
    }

}
