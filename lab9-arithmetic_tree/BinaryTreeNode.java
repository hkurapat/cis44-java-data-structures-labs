public class BinaryTreeNode {
    String value;
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Preorder visits the parent first then left then right
    // This gives us prefix notation from the lecture slides
    public void traversePreorder() {
        System.out.print(this.value + " ");
        if (left != null) left.traversePreorder();
        if (right != null) right.traversePreorder();
    }

    // Inorder visits left first then parent then right
    // This gives us infix notation with parentheses just like the slides showed
    public void traverseInorder() {
        if (left != null) {
            System.out.print("(");
            left.traverseInorder();
        }
        System.out.print(this.value + " ");
        if (right != null) {
            right.traverseInorder();
            System.out.print(")");
        }
    }

    // Postorder visits left then right then parent
    // This gives us postfix notation from the lecture slides
    public void traversePostorder() {
        if (left != null) left.traversePostorder();
        if (right != null) right.traversePostorder();
        System.out.print(this.value + " ");
    }
}
