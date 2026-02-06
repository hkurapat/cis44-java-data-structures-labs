public class Quadrilateral implements Polygon {
    protected double side1;
    protected double side2;
    protected double side3;
    protected double side4;

    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3 + side4;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt((s - side1) * (s - side2) * (s - side3) * (s - side4));
    }
}