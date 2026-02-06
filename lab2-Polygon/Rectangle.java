public class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        super(length, width, length, width);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * length + 2 * width;
    }
}