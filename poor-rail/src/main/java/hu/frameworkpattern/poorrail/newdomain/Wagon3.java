package hu.frameworkpattern.poorrail.newdomain;

public class Wagon3 implements newWagon {
	
	private String naam;
	private int aantalStoelen;
	private String type;
	private String color;
	
	public Wagon3(String nm, int stoel) {
		naam = nm;
		aantalStoelen = stoel;
		type = "wagon";
		color = "green";
	}

	public int getStoel() {
		throw new RuntimeException("Method implementation required");
	}

	public String getNaam() {
		throw new RuntimeException("Method implementation required");
	}

	public void delete() {
		throw new RuntimeException("Method implementation required");
	}
	
	public String toString() {
    	String s = naam + " met aantal stoelen: " + aantalStoelen;
    	
    	return s;
    }

}
