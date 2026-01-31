import java.util.Scanner;

public class Calculator {
    private double result;
    private double savedNumber;
    private String operator;
    
    public Calculator() {
        result = 0;
        savedNumber = 0;
        operator = "";
    }
    
    public double getResult() {
        return result;
    }
    
    public void enter(String input) {
        if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("=")) {
            if (!operator.equals("")) {
                if (operator.equals("+")) {
                    result = result + savedNumber;
                } else if (operator.equals("-")) {
                    result = result - savedNumber;
                } else if (operator.equals("*")) {
                    result = result * savedNumber;
                } else if (operator.equals("/")) {
                    result = result / savedNumber;
                }
            }
            operator = input;
        } else {
            double number = Double.valueOf(input);
            savedNumber = number;
            if (operator.equals("")) {
                result = number;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();
        
        System.out.println("Simple Calculator");
        System.out.println("Enter numbers and operators (+, -, *, /, =)");
        System.out.println("Type 'exit' to quit");
        System.out.println();
        
        while (true) {
            System.out.print("Enter input: ");
            String input = scanner.next();
            
            if (input.equals("exit")) {
                break;
            }
            
            calc.enter(input);
            System.out.println("Screen: " + calc.getResult());
            System.out.println();
        }
        
        scanner.close();
    }
}
