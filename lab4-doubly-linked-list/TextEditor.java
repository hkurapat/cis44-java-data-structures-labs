// This is the TextEditor class which manages the history of a text document by using doubly linked list
public class TextEditor {
    
    // This is the Node class that represents each state in the text history
    private static class Node {
        String textState;
        Node prev;
        Node next;
        
        // This is the constructor which creates a new node with text state
        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node currentNode;
    
    // This is the constructor that starts with an empty text state
    public TextEditor() {
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }
    
    // This adds new text to the current state
    public void add(String newText) {
      
        // This creates new text by adding to the current text
        String updatedText = currentNode.textState + newText;
        
        // This creates new node with the updated text
        Node newNode = new Node(updatedText, currentNode, null);
        
        // This links the current node to the new node and clears redo history
        currentNode.next = newNode;
        
        // This moves the current pointer to the new node
        currentNode = newNode;
        
        System.out.println("Added text: \"" + newText + "\"");
    }
    
    // This moves back one step in history
    public String undo() {
        if (currentNode.prev == null) {
            System.out.println("Nothing to undo.");
            return currentNode.textState;
        }
        
        // This moves current pointer back
        currentNode = currentNode.prev;
        System.out.println("Undo successful.");
        return currentNode.textState;
    }
    
    // This moves forward one step in history
    public String redo() {
        if (currentNode.next == null) {
            System.out.println("Nothing to redo.");
            return currentNode.textState;
        }
        
        // This moves current pointer forward
        currentNode = currentNode.next;
        System.out.println("Redo successful.");
        return currentNode.textState;
    }
    
    // This displays the current text state
    public void printCurrent() {
        System.out.println("\n=== Current Text ===");
        if (currentNode.textState.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            System.out.println(currentNode.textState);
        }
        System.out.println("====================\n");
    }
}
