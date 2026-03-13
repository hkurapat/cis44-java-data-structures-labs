import javax.swing.*;
import java.awt.*;

public class FractalTree extends JPanel {
    private final int MAX_DEPTH = 9;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // This starts the recursion from the bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);
    }

    // This is the recursive method that draws each branch of the tree
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {

        // This is the Base case where when depth hits 0 we stop drawing branches
        if (depth == 0) {
            return;
        }

        // Here the branch length gets smaller as we go deeper into the recursion
        int length = depth * 10;

        //This calculates the end point of this branch using trig just like the template says
        int x2 = (int) (x1 + length * Math.cos(Math.toRadians(angle)));
        int y2 = (int) (y1 + length * Math.sin(Math.toRadians(angle)));

        // This here draws the current branch as a line
        g.drawLine(x1, y1, x2, y2);

        // This is the recursive step where it calls drawTree twice for left and right sub branches
        // This is binary recursion where there is two recursive calls per step just like Fibonacci
        drawTree(g, x2, y2, angle - 20, depth - 1); // left branch
        drawTree(g, x2, y2, angle + 30, depth - 1); // right branch
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
