import java.util.EmptyStackException;

// This is the stack interface
interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E element);
    E top();
    E pop();
}

// This is the ArrayStack implementation
class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int t = -1;

    // This constructor sets up the array with the given capacity
    public ArrayStack(int capacity) {
        data = new Object[capacity];
    }

    // This here returns how many elements are in the stack
    public int size() {
        return (t + 1);
    }

    // This returns true if stack is empty meaning nothing is in it 
    public boolean isEmpty() {
        return (t == -1);
    }

    // This adds element to the top of the stack
    public void push(E element) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = element;
    }

    // This returns top element without removing it
    @SuppressWarnings("unchecked")
    public E top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return (E) data[t];
    }

    // This removes and returns the top element
    @SuppressWarnings("unchecked")
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        E answer = (E) data[t];
        data[t--] = null;
        return answer;
    }
}

public class SyntaxChecker {

 // this method checks if the symbols in a line of code are balanced

    public static boolean isBalanced(String line) {
      
        // this here creates a stack to hold opening symbols
        // Here we are using line.length() as max capacity since we cant have more symbols than characters
      
        Stack<Character> buffer = new ArrayStack<>(line.length());

        // Here we go through each character in the string one at a time
        for (char c : line.toCharArray()) {

            // Here if its an opening symbol push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c);
            }
            // For this if its a closing symbol we need to check if it matches
            else if (c == ')' || c == '}' || c == ']') {

                // FOr this if stack is empty there is nothing to match so its unbalanced
                if (buffer.isEmpty()) {
                    return false;
                }

                // Here we pop the top opening symbol off the stack
                char top = buffer.pop();

                // This checks if the opening and closing symbols match each other
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
            // So basically any other character we just ignore and skip
        }

        // For this if stack is empty all symbols were matched
        // For this if stack still has something there were unmatched opening symbols
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false 
        String line4 = "List list = new ArrayList<{String>();"; // Should be false
        String line5 = "if (x > 0) {"; // Should be false 

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
