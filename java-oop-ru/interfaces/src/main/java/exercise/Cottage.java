package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int flourCount;

    public Cottage(double area, int flourCount) {
        this.area = area;
        this.flourCount = flourCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (area > anotherArea) return 1;
        if (area < anotherArea) return -1;
        return 0;
    }

    public String toString() {
        return String.format("%s этажный коттедж площадью %s метров", flourCount, area);
//        return flourCount+ " этажный коттедж площадью " + area +" метров";
    }

}
// END
