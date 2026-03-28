public class ExpressionTreeDriver {
    public static void main(String[] args) {

        // Build the expression tree for ( (3 + 7) * (9 - 4) )
        //         *
        //        / \
        //       +   -
        //      / \ / \
        //     3  7 9  4

        // Create the root which is the multiply operator
        BinaryTreeNode root = new BinaryTreeNode("*");

        // Create the left and right operator nodes
        BinaryTreeNode nodePlus = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");

        // Connect the operators to the root
        root.left = nodePlus;
        root.right = nodeMinus;
        nodePlus.parent = root;
        nodeMinus.parent = root;

        // Create the leaf nodes which are the operands
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");

        // Connect the leaves to the plus node
        nodePlus.left = node3;
        nodePlus.right = node7;
        node3.parent = nodePlus;
        node7.parent = nodePlus;

        // Connect the leaves to the minus node
        nodeMinus.left = node9;
        nodeMinus.right = node4;
        node9.parent = nodeMinus;
        node4.parent = nodeMinus;

        // Run all three traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();
    }
}
