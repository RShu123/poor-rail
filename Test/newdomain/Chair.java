package hu.frameworkpattern.poorrail.newdomain;

public class Chair {

    private static final String DEFAULT_CHAIR_COLOUR = "Blauw";

    private double weight;
    private double width;
    private double height;
    private String colour;
    private boolean belt;
    private boolean available;

    public Chair() {
    }

    public Chair(double weight) {
        this(weight, 0.5);
    }

    public Chair(double weight, double width) {
        this(weight, width, 1.5);
    }

    public Chair(double weight, double width, double height) {
        this(weight, width, height, DEFAULT_CHAIR_COLOUR);
    }

    public Chair(double weight, double width, double height, String colour) {
        this(weight, width, height, colour, false);
    }

    public Chair(double weight, double width, double height, String colour, boolean belt) {
        this(weight, width, height, colour, belt, true);
    }

    public Chair(double weight, double width, double height, String colour, boolean belt, boolean available) {
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.colour = colour;
        this.belt = belt;
        this.available = available;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isBelt() {
        return belt;
    }

    public void setBelt(boolean belt) {
        this.belt = belt;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", color='" + colour + '\'' +
                ", belt=" + belt +
                ", available=" + available +
                '}';
    }

    public static class ChairBuilder {

        private double weight;
        private double width;
        private double height;
        private String color;
        private boolean belt;
        private boolean available;

        public ChairBuilder withWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public ChairBuilder withWidth(double width) {
            this.width = width;
            return this;
        }

        public ChairBuilder withHeight(double height) {
            this.height = height;
            return this;
        }

        public ChairBuilder withColour(String colour) {
            this.color = colour;
            return this;
        }

        public ChairBuilder withBelt(boolean belt) {
            this.belt = belt;
            return this;
        }

        public ChairBuilder withAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public Chair build() {
            return new Chair(weight, width, height, color, belt, available);
        }
    }

}
