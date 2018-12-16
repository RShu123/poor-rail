package hu.frameworkpattern.poorrail.newdomain;

public class Wagon1 implements Wagon {
	
	private String naam;
	private long aantalStoelen;
	private String type;
	private String color;
    private Chair chair;

    public Wagon1(String nm, Chair newchair) {
		naam = nm;
		aantalStoelen = 100;
		type = "wagon";
		color = "orange";
        chair = newchair;
    }

    public long getAantalStoelen() {
		return aantalStoelen;
	}

	public String getNaam() {
		return naam;
	}

	public void delete() {
	}

    @Override
    public Chair getChair() {
        return chair;
    }

	public String toString() {
        String s = naam + " met aantal stoelen: " + aantalStoelen + getChair();
    	return s;
    }

}
