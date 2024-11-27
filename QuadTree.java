public class QuadTree {
    private Node root;

    public QuadTree() {
        root = new LeafNode(-50, -50, 100, 100);
    }

    public void insert(Rectangle rectangle) {
        root.insert(rectangle);
    }

    public void dump() {
        root.dump("");
    }
}

