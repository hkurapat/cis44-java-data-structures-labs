import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This is the node class for the 2-4 tree
// here each node can hold 1 2 or 3 keys and 2 3 or 4 children
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    // a node is a leaf if it has no children
    public boolean isLeaf() {
        return children.isEmpty();
    }

    // a node is full when it already has 3 keys
    // here it is adding one more would cause an overflow that needs a split
    public boolean isFull() {
        return keys.size() == 3;
    }

    // here it finds which child to go to next based on the key we are inserting
    // this follows the same logic as BST search but for multiple keys
    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // adds a key to this node and keeps them sorted
    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // step 1 is to go down the tree to find the right leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // step 2 is to insert the key into the leaf
        node.insertKey(key);

        // step 3 is to if the node overflowed split it and keep going up
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    // split handles overflow when a node gets 4 keys
    // the middle key gets promoted to the parent
    // the remaining keys split into two new nodes
    // this is the split and promote from the lecture slides
    private void split(TwoFourNode node) {
        int midIndex = 1; 
        int midKey = node.keys.get(midIndex);

        // this creates the new right node and give it the keys after the middle
        TwoFourNode rightNode = new TwoFourNode();
        rightNode.keys.add(node.keys.get(2));
        rightNode.keys.add(node.keys.get(3));

        // move the last two children to the right node if this is not a leaf
        if (!node.isLeaf()) {
            rightNode.children.add(node.children.get(2));
            rightNode.children.add(node.children.get(3));
            node.children.get(2).parent = rightNode;
            node.children.get(3).parent = rightNode;
            node.children.remove(3);
            node.children.remove(2);
        }

        // remove the keys we moved from the original node
        node.keys.remove(3);
        node.keys.remove(2);
        node.keys.remove(1);

        // if there is no parent this node is the root so we need a new root
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.keys.add(midKey);
            newRoot.children.add(node);
            newRoot.children.add(rightNode);
            node.parent = newRoot;
            rightNode.parent = newRoot;
            root = newRoot;
        } else {
            // promote the middle key to the parent
            TwoFourNode parent = node.parent;
            parent.insertKey(midKey);

            // find where to insert the right node in the parent's children list
            int pos = parent.children.indexOf(node);
            parent.children.add(pos + 1, rightNode);
            rightNode.parent = parent;
        }
    }

    // inorder traversal prints keys in sorted order
    // this lets us verify the tree is correct
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}
