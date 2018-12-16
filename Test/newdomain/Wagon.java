package hu.frameworkpattern.poorrail.newdomain;

public interface Wagon {


    public long getAantalStoelen();

	public String getNaam();
	
	public void delete();

    public Chair getChair();

}
