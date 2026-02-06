import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Polygon Calculator");
        System.out.println("1 - Triangle");
        System.out.println("2 - Isosceles Triangle");
        System.out.println("3 - Equilateral Triangle");
        System.out.println("4 - Quadrilateral");
        System.out.println("5 - Rectangle");
        System.out.println("6 - Square");
        System.out.println("7 - Pentagon");
        System.out.println("8 - Hexagon");
        System.out.println("9 - Octagon");
        System.out.print("Enter choice: ");
        
        int choice = input.nextInt();
        Polygon shape = null;
        
        if (choice == 1) {
            System.out.print("Enter side 1: ");
            double s1 = input.nextDouble();
            System.out.print("Enter side 2: ");
            double s2 = input.nextDouble();
            System.out.print("Enter side 3: ");
            double s3 = input.nextDouble();
            shape = new Triangle(s1, s2, s3);
        }
        else if (choice == 2) {
            System.out.print("Enter equal side: ");
            double equal = input.nextDouble();
            System.out.print("Enter base: ");
            double base = input.nextDouble();
            shape = new IsoscelesTriangle(equal, base);
        }
        else if (choice == 3) {
            System.out.print("Enter side: ");
            double side = input.nextDouble();
            shape = new EquilateralTriangle(side);
        }
        else if (choice == 4) {
            System.out.print("Enter side 1: ");
            double s1 = input.nextDouble();
            System.out.print("Enter side 2: ");
            double s2 = input.nextDouble();
            System.out.print("Enter side 3: ");
            double s3 = input.nextDouble();
            System.out.print("Enter side 4: ");
            double s4 = input.nextDouble();
            shape = new Quadrilateral(s1, s2, s3, s4);
        }
        else if (choice == 5) {
            System.out.print("Enter length: ");
            double length = input.nextDouble();
            System.out.print("Enter width: ");
            double width = input.nextDouble();
            shape = new Rectangle(length, width);
        }
        else if (choice == 6) {
            System.out.print("Enter side: ");
            double side = input.nextDouble();
            shape = new Square(side);
        }
        else if (choice == 7) {
            System.out.print("Enter side: ");
            double side = input.nextDouble();
            shape = new Pentagon(side);
        }
        else if (choice == 8) {
            System.out.print("Enter side: ");
            double side = input.nextDouble();
            shape = new Hexagon(side);
        }
        else if (choice == 9) {
            System.out.print("Enter side: ");
            double side = input.nextDouble();
            shape = new Octagon(side);
        }
        
        if (shape != null) {
            System.out.println("Area: " + shape.area());
            System.out.println("Perimeter: " + shape.perimeter());
        }
        
        input.close();
    }
}