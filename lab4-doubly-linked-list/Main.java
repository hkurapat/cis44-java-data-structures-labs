import java.util.Scanner;
// This is the main class which gives a menu to interact with the text editor
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Simple Text Editor!");
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // This removes the extra newline
            
            switch (choice) {
                case 1:
                    // This adds new text
                    System.out.print("Enter text to add: ");
                    String text = scanner.nextLine();
                    editor.add(text);
                    break;
                    
                case 2:
                    // This executes undo
                    editor.undo();
                    break;
                    
                case 3:
                    // This executes redo
                    editor.redo();
                    break;
                    
                case 4:
                    // This displays the current text
                    editor.printCurrent();
                    break;
                    
                case 5:
                    // This exits the program
                    System.out.println("Thanks for using Text Editor!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }  
        scanner.close();
    }
}
