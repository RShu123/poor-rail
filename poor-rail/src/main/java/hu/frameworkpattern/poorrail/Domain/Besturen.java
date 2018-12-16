package hu.frameworkpattern.poorrail.Domain;

public interface Besturen {
    String bestuurbaar();
}

class Bestuurbaar implements Besturen {

    public String bestuurbaar() {
        return "is steerable";
    }
}

class NietBestuurbaar implements Besturen {

    public String bestuurbaar() {
        return "is not steerable";
    }
}

