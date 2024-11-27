public abstract class Node {
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

