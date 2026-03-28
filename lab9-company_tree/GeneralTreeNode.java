import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name;
    GeneralTreeNode parent;
    List<GeneralTreeNode> children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // This adds a child node to this node and sets its parent
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // Preorder visits the parent first then recursively visits each child
    // This is the parent first approach
    public void traversePreorder() {
        System.out.println(this.name);
        for (GeneralTreeNode child : children) {
            child.traversePreorder();
        }
    }

    // Postorder visits all children first then the parent
    // This is the children-first approach 
    public void traversePostorder() {
        for (GeneralTreeNode child : children) {
            child.traversePostorder();
        }
        System.out.println(this.name);
    }
}
