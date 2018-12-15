package hu.frameworkpattern.poorrail.StrategyPattern;

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
        return "it is not steerable";
    }
}

