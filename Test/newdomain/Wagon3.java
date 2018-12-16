package hu.frameworkpattern.poorrail.newdomain;

public class Wagon3 implements Wagon {
	
	private String naam;
	private long aantalStoelen;
	private String type;
	private String color;
    private Chair chair;

    public Wagon3(String naam, long aantalStoelen, Chair chair) {
		this.naam = naam;
		this.aantalStoelen = aantalStoelen;
		type = "wagon";
		color = "green";
	}

    public long getAantalStoelen() {
		return aantalStoelen;
	}

	public String getNaam() {
		return naam;
	}

    @Override
    public Chair getChair() {
        return chair;
    }

	public void delete() {
		throw new RuntimeException("Method implementation required");
	}
	
	public String toString() {
    	String s = naam + " met aantal stoelen: " + aantalStoelen;
    	return s;
    }

}
