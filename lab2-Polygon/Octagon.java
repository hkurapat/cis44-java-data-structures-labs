public class Octagon implements Polygon {
    private double side;

    public Octagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 8 * side;
    }

    @Override
    public double area() {
        return 4.83 * side * side;
    }
}