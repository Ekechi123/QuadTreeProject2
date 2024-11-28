import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeafNode extends Node {
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
      Iterator<Rectangle> iterator = this.rectangles.iterator();
      while (iterator.hasNext()) {
         Rectangle rect = iterator.next();
         System.out.println(indent + "  " + rect);
      }
   }
}
