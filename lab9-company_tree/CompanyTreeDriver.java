public class CompanyTreeDriver {
    public static void main(String[] args) {

        // This builds the tree starting from the root which is the CEO
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // This creates the two VP nodes as children of the CEO
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        //This adds children for VP of Sales
        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        // This adds children for VP of Engineering
        GeneralTreeNode devLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devLead);
        vpEngineering.addChild(qaLead);

        // This adds developers under Dev Team Lead
        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        // This runs preorder traversal  
        //parent first then children
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        // This runs postorder traversal 
        //children first then parent
        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}
