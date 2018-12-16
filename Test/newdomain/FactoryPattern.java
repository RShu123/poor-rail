package hu.frameworkpattern.poorrail.newdomain;

public class FactoryPattern {
    public static void main(String[] args) {
        WagonFactory wagonFactory = new WagonFactory();

        Wagon wagon1 = wagonFactory.getWagon(50);

        System.out.println(wagon1);

        Wagon wagon2 = wagonFactory.getWagon(350);

        System.out.println(wagon2);

        Wagon wagon3 = wagonFactory.getWagon(700);

        System.out.println(wagon3);
    }
}
