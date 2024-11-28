import java.awt.geom.Rectangle2D;

public class Main {
    public static void main(String[] args) {
        // Create a Rectangle2D.Double object (x, y, width, height)
        Rectangle2D.Double rect = new Rectangle2D.Double(10.5, 20.5, 30.5, 40.5);

        // Create a QuadTree with bounds as a Rectangle2D.Double (x, y, width, height)
        QuadTree quadTree = new QuadTree(new Rectangle2D.Double(0, 0, 100, 100));

        // Insert the rectangle into the QuadTree
        quadTree.insert(rect);

        // Dump the QuadTree contents to check the insertion
        quadTree.dump();
    }
}
