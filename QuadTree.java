import java.awt.geom.Rectangle2D;

public class QuadTree {
    private Rectangle2D.Double bounds;

    // Constructor: We are using Rectangle2D.Double to represent the bounds of the QuadTree
    public QuadTree(Rectangle2D.Double bounds) {
        this.bounds = bounds;
    }

    // Insert method for adding a rectangle to the QuadTree (currently just prints for now)
    public void insert(Rectangle2D.Double rect) {
        // Example logic for inserting the rectangle (just printing for now)
        System.out.println("Inserting rectangle at: " + rect);
    }

    // Method to dump the QuadTree bounds (for testing purposes)
    public void dump() {
        System.out.println("QuadTree bounds: " + bounds);
    }

    // Additional methods for QuadTree as needed
}

