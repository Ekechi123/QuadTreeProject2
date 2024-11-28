import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    private static final int MAX_CAPACITY = 4;
    private Rectangle2D.Double boundary;
    private List<Rectangle2D.Double> objects;
    private boolean divided;
    private QuadTree northeast, northwest, southeast, southwest;

    // Constructor
    public QuadTree(Rectangle2D.Double boundary) {
        this.boundary = boundary;
        this.objects = new ArrayList<>();
        this.divided = false;
    }

    // Insert a rectangle into the QuadTree
    public boolean insert(Rectangle2D.Double rect) {
        if (!boundary.intersects(rect)) {
            return false; // Ignore objects outside the boundary
        }

        if (objects.size() < MAX_CAPACITY) {
            objects.add(rect);
            return true;
        }

        if (!divided) {
            subdivide();
        }

        // Recursively insert into the appropriate quadrant
        return (northeast.insert(rect) || northwest.insert(rect) ||
                southeast.insert(rect) || southwest.insert(rect));
    }

    // Subdivide the current QuadTree into four quadrants
    private void subdivide() {
        double x = boundary.x;
        double y = boundary.y;
        double w = boundary.width / 2;
        double h = boundary.height / 2;

        northeast = new QuadTree(new Rectangle2D.Double(x + w, y, w, h));
        northwest = new QuadTree(new Rectangle2D.Double(x, y, w, h));
        southeast = new QuadTree(new Rectangle2D.Double(x + w, y + h, w, h));
        southwest = new QuadTree(new Rectangle2D.Double(x, y + h, w, h));
        divided = true;
    }

    // Dump the contents of the QuadTree
    public void dump() {
        System.out.println("Objects in this QuadTree:");
        for (Rectangle2D.Double rect : objects) {
            System.out.println("Rectangle: " + rect);
        }

        if (divided) {
            System.out.println("Northeast:");
            northeast.dump();
            System.out.println("Northwest:");
            northwest.dump();
            System.out.println("Southeast:");
            southeast.dump();
            System.out.println("Southwest:");
            southwest.dump();
        }
    }
}
