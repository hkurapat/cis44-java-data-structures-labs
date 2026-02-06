public class Hexagon implements Polygon {
    private double side;

    public Hexagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 6 * side;
    }

    @Override
    public double area() {
        return 2.6 * side * side;
    }
}