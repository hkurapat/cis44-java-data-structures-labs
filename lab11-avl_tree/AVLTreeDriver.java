public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // here it is inserting 10, 20, 30 triggers a Right to Right case which does a left rotation
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        // here it is inserting 5 then 4 triggers a Left-Left case which does a right rotation
        tree.insert(5);
        tree.insert(4);

        //here it is inserting 8 triggers a Left-Right zig-zag case which does a double rotation
        tree.insert(8);

        //here it is inserting 25 triggers a Right-Left zig-zag case which does a double rotation
        tree.insert(25);

        //this prints all three traversals to verify the tree is correct
        System.out.print("Inorder: ");
        tree.inorder(); // Expected: 4 5 8 10 20 25 30

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();
    }
}
