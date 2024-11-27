public class InternalNode extends Node {
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
                if (child instanceof LeafNode && ((LeafNode) child).getRectangleCount() > 5) {
                    split((LeafNode) child);
                }
                return;
            }
        }
    }

    private void split(LeafNode leaf) {
        InternalNode internal = new InternalNode(leaf.x, leaf.y, leaf.width, leaf.height);
        for (Rectangle rect : leaf.getRectangles()) {
            internal.insert(rect);
        }
        replaceChild(leaf, internal);
    }

    private void replaceChild(Node oldChild, Node newChild) {
        for (int i = 0; i < children.length; i++) {
            if (children[i] == oldChild) {
                children[i] = newChild;
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
