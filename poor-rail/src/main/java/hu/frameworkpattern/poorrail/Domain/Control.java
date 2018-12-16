package hu.frameworkpattern.poorrail.Domain;

public interface Control {
    String controllable();
}

class ItsControllable implements Control {

    public String controllable() {
        return "is steerable";
    }
}

class ItsNotControllable implements Control {

    public String controllable() {
        return "is not steerable";
    }
}

