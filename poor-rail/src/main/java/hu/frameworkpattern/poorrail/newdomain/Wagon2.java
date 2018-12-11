package hu.frameworkpattern.poorrail.newdomain;

public class Wagon2 implements newWagon {
	
	private String naam;
	private long aantalStoelen;
	private String type;
	private String color;

	public Wagon2(String naam, long aantalStoelen) {
		this.naam = naam;
		this.aantalStoelen = aantalStoelen;
		type = "wagon";
		color = "blue";
	}

	public long getStoel() {
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
