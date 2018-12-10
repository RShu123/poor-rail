package hu.frameworkpattern.poorrail.newdomain;

public class Wagon1 implements newWagon {
	
	private String naam;
	private int aantalStoelen;
	private String type;
	private String color;
	
	public Wagon1(String nm) {
		naam = nm;
		aantalStoelen = 20;
		type = "wagon";
		color = "orange";
	}

	public int getStoel() {
		return aantalStoelen;
	}

	public String getNaam() {
		return naam;
	}

	public void delete() {
	}
	
	public String toString() {
    	String s = naam + " met aantal stoelen: " + aantalStoelen;
    	return s;
    }

}
