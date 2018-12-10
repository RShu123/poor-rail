package hu.frameworkpattern.poorrail.newdomain;

public class FactoryPattern {
    public static void main(String[] args) {
        WagonFactory wagonFactory = new WagonFactory();

        newWagon wagon1 = wagonFactory.getWagon("orange");

        System.out.println(wagon1);

        newWagon wagon2 = wagonFactory.getWagon("blue");

        System.out.println(wagon2);

        newWagon wagon3 = wagonFactory.getWagon("green");

        System.out.println(wagon3);
    }
}
