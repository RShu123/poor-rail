package hu.frameworkpattern.poorrail.Domain;

public interface Control {
    String bestuurbaar();
}

class Controllable implements Control {

    public String bestuurbaar() {
        return "is bestuurbaar.";
    }
}

class NottControllable implements Control {

    public String bestuurbaar() {
        return "is niet bestuurbaar.";
    }
}

