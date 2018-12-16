package hu.frameworkpattern.poorrail.Domain;

public interface Control {
    String bestuurbaar();
}

class Controllable implements Control {

    public String bestuurbaar() {
        return "is steerable";
    }
}

class NottControllable implements Control {

    public String bestuurbaar() {
        return "is not steerable";
    }
}

