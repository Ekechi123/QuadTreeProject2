public class Main {
    public static void main(String[] args) {
        // Define the boundary for the QuadTree
        RectangleWithId = new RectangleWithId(0, 0, 100, 100, "Boundary");

        // Create the QuadTree with the defined boundary (which is a RectangleWithId)
        QuadTree quadTree = new QuadTree(new java.awt.geom.Rectangle2D.Double(0, 0, 100, 100));

        // Insert some rectangles with IDs
        quadTree.insert(new RectangleWithId(10.5, 20.5, 30.5, 40.5, "ID1"));
        quadTree.insert(new RectangleWithId(30.0, 30.0, 25.0, 25.0, "ID2"));
        quadTree.insert(new RectangleWithId(50.0, 50.0, 15.0, 15.0, "ID3"));
        quadTree.insert(new RectangleWithId(70.0, 70.0, 10.0, 10.0, "ID4"));
        quadTree.insert(new RectangleWithId(20.0, 20.0, 30.0, 30.0, "ID5"));

        // Print the contents of the QuadTree
        quadTree.dump();
    }
}

