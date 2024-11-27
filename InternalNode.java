public class InternalNode extends Node {
    private Node[] children;

    public InternalNode(double x, double y, double width, double height) {
        super(x, y, width, height);
        children = new Node[4];
    }

    @Override
    public void insert(Rectangle rectangle) {
        // Implement logic to distribute the rectangle among child nodes
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

