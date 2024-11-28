import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuadTreeProject {

    // Rectangle class
    public static class Rectangle {
        private double x, y, width, height;

        public Rectangle(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public double getX() { return x; }
        public double getY() { return y; }
        public double getWidth() { return width; }
        public double getHeight() { return height; }

        @Override
        public String toString() {
            return "Rectangle: " + x + ", " + y + ", " + width + "x" + height;
        }
    }

    // Abstract Node class
    public static abstract class Node {
        protected double x, y, width, height;

        public Node(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public abstract void insert(Rectangle rectangle);
        public abstract void dump(String indent);
    }

    // LeafNode class (extends Node)
    public static class LeafNode extends Node {
        private List<Rectangle> rectangles = new ArrayList<>();

        public LeafNode(double x, double y, double width, double height) {
            super(x, y, width, height);
        }

        public int getRectangleCount() {
            return this.rectangles.size();
        }

        public List<Rectangle> getRectangles() {
            return new ArrayList<>(this.rectangles);
        }

        @Override
        public void insert(Rectangle rectangle) {
            this.rectangles.add(rectangle);
        }

        @Override
        public void dump(String indent) {
            System.out.println(indent + "LeafNode: " + this.x + ", " + this.y + ", " + this.width + "x" + this.height);
            for (Rectangle rect : this.rectangles) {
                System.out.println(indent + "  " + rect);
            }
        }
    }

    // InternalNode class (extends Node)
    public static class InternalNode extends Node {
        private Node[] children;

        public InternalNode(double x, double y, double width, double height) {
            super(x, y, width, height);
            children = new Node[4];
            initializeChildren();
        }

        private void initializeChildren() {
            double halfWidth = width / 2;
            double halfHeight = height / 2;

            children[0] = new LeafNode(x, y + halfHeight, halfWidth, halfHeight); // Top-left
            children[1] = new LeafNode(x + halfWidth, y + halfHeight, halfWidth, halfHeight); // Top-right
            children[2] = new LeafNode(x, y, halfWidth, halfHeight); // Bottom-left
            children[3] = new LeafNode(x + halfWidth, y, halfWidth, halfHeight); // Bottom-right
        }

        @Override
        public void insert(Rectangle rectangle) {
            for (Node child : children) {
                if (rectangle.getX() >= child.x && rectangle.getX() < child.x + child.width &&
                    rectangle.getY() >= child.y && rectangle.getY() < child.y + child.height) {
                    child.insert(rectangle);
                    return;
                }
            }
        }

        @Override
        public void dump(String indent) {
            System.out.println(indent + "InternalNode: " + x + ", " + y + ", " + width + "x" + height);
            for (Node child : children) {
                if (child != null) {
                    child.dump(indent + "  ");
                }
            }
        }
    }

    // QuadTree class
    public static class QuadTree {
        private Rectangle2D.Double bounds;

        // Constructor: We are using Rectangle2D.Double to represent the bounds of the QuadTree
        public QuadTree(Rectangle2D.Double bounds) {
            this.bounds = bounds;
        }

        // Insert method for adding a rectangle to the QuadTree (currently just prints for now)
        public void insert(Rectangle2D.Double rect) {
            System.out.println("Inserting rectangle at: " + rect);
        }

        // Method to dump the QuadTree bounds (for testing purposes)
        public void dump() {
            System.out.println("QuadTree bounds: " + bounds);
        }
    }

    // Main class (with the main method)
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

