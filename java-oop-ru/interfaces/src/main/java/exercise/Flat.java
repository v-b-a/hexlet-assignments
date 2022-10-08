package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int flor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = flor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (area > anotherArea) return 1;
        if (area < anotherArea) return -1;
        if (area == anotherArea) return 0;
        return 99;
    }

    public String toString() {
        return String.format("Квартира площадью %a метров на %f этаже", getArea(), floor);
//        return "Квартира площадью " + (area + balconyArea) + " метров на " + floor + " этаже";
    }
}
// END
