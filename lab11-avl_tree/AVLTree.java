// AVL Node class that stores the key, height, and left and right children
class AVLNode {
    int key, height;
    AVLNode left, right;

    // constructor sets up the node with height 1 since it starts as a leaf
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // returns the height of a node, returns 0 if null
    int height(AVLNode N) {
        if (N == null) return 0;
        return N.height;
    }

    // this returns the bigger of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // balance factor tells us if a node is left heavy, right heavy, or balanced
    // positive means left heavy and negative means right heavy
    int getBalance(AVLNode N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }

    // right rotation fixes the Left-Left case from the lecture slides
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // this performs the rotation
        x.right = y;
        y.left = T2;

        // update heights after rotation
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x; // x is the new root of this subtree
    }

    // left rotation fixes the Right-Right case from the lecture slides
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // perform the rotation
        y.left = x;
        x.right = T2;

        // update heights after rotation
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y; // y is the new root of this subtree
    }

    // left-right rotation fixes the Left-Right zig-zag case
    // first do a left rotation on the left child then a right rotation on the node
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z);
    }

    // right to left rotation fixes the Right-Left zig-zag case
    // first do a right rotation on the right child then a left rotation on the node
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y);
    }

    // public insert method that starts the recursive insertion
    public void insert(int key) {
        root = insert(root, key);
    }

    // recursive insert that also rebalances the tree after each insertion
    private AVLNode insert(AVLNode node, int key) {

        // normal BST insertion first
        if (node == null) return new AVLNode(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; 
        }

        //  this here updates the height of this node
        node.height = 1 + max(height(node.left), height(node.right));

        // check the balance factor to see if this node became unbalanced
        int balance = getBalance(node);

        // Left to Left case 
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right to Right case 
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left to Right case 
        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }

        // Right to Left case 
        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }

        return node;
    }

    // inorder traversal visits left then node then right
    // this gives us sorted order which is useful to verify the BST property
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // preorder traversal visits node first then left then right
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // postorder traversal visits left then right then node
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }
}
