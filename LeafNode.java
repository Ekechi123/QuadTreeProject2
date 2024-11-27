import java.util.ArrayList;
import java.util.List;

public class LeafNode extends Node {
    private List<Rectangle> rectangles;

    public LeafNode(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.rectangles = new ArrayList<>();
    }

    @Override
    public void insert(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    @Override
    public void dump(String indent) {
        System.out.println(indent + "LeafNode: " + x + ", " + y + ", " + width + "x" + height);
        for (Rectangle rectangle : rectangles) {
            System.out.println(indent + "  " + rectangle);
        }
    }
}

