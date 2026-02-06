public class Pentagon implements Polygon {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }

    @Override
    public double area() {
        return 0.25 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }
}