
import processing.core.PApplet;

public class Triangle {

  private Point point1, point2, point3; // The points of the triangle
  private int color; // color of the triangle corresponding to key press
  // int packed w/8 bits of ARGB
  // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
  private static final int[] COLORS =
      new int[] {-1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476};

  /**
   * Assigning the points clicked to first second and third to create the triangle
   * @param refPoint1
   * @param refPoint2
   * @param refPoint3
   * @param colorIndex
   */
  public Triangle(Point refPoint1, Point refPoint2, Point refPoint3, int colorIndex) {
    point1 = refPoint1;
    point2 = refPoint2;
    point3 = refPoint3;
    color = COLORS[colorIndex];
  }

  /**
   * Setting the color of the triangle
   * @param colorIndex
   */
  public void setColor(int colorIndex) {
    color = COLORS[colorIndex];
  }

  /**
   * Draws the triangle based on the three points in the triangle method
   * @param drawTo
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(color);
    drawTo.triangle(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(),
        point3.getY());

  }

  /**
   * Function to check if the point is in the triangle by making an instance of the isPointInTriangle function
   * @param x
   * @param y
   * @return
   */
  public boolean isOver(int x, int y) {
    return isPointInTriangle(x, y, point1.getX(), point1.getY(), point2.getX(), point2.getY(),
        point3.getX(), point3.getY());
  }

  /**
   * Method to check if point is in triangle.
   * @param px
   * @param py
   * @param t1x
   * @param t1y
   * @param t2x
   * @param t2y
   * @param t3x
   * @param t3y
   * @return
   */
  public boolean isPointInTriangle(int px, int py, int t1x, int t1y, int t2x, int t2y, int t3x,
      int t3y) {
    // int t1x = point1.getX();
    // int t1y = point1.getY();
    // int t2x = point2.getX();
    // int t2y = point2.getY();
    // int t3x = point3.getX();
    // int t3y = point3.getY();
    // int px = x;
    // int py = y;
    px -= t1x;
    py -= t1y;
    t2x -= t1x;
    t2y -= t1y;
    t3x -= t1x;
    t3y -= t1y;
    double dotp2 = px * t2x + py * t2y;
    double dotp3 = px * t3x + py * t3y;
    double dot22 = t2x * t2x + t2y * t2y;
    double dot23 = t2x * t3x + t2y * t3y;
    double dot33 = t3x * t3x + t3y * t3y;
    double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
    double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
    double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
    return (a >= 0) && (b >= 0) && (a + b < 1);
  }


  // public boolean isOver(int x, int y) {
  // double dotp2 = (x - point1.getX()) * (point2.getX() - point1.getX())
  // + (y - point1.getY()) * (point2.getY() - point1.getY());
  // double dotp3 = (x - point1.getX()) * (point3.getX() - point1.getX())
  // + (y - point1.getY()) * (point3.getY() - point1.getY());
  // double dot22 = (point2.getX() - point1.getX()) * (point2.getX() - point1.getX())
  // + (point2.getY() - point1.getY()) * (point2.getY() - point1.getY());
  // double dot23 = (point2.getX() - point1.getX()) * (point3.getX() - point1.getX())
  // + (point2.getY() - point1.getY()) * (point3.getY() - point1.getY());
  // double dot33 = (point3.getX() - point1.getX()) * (point3.getX() - point1.getX())
  // + (point3.getY() - point1.getY()) * (point3.getY() - point1.getY());
  // double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
  // double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
  // double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
  // return (a >= 0) && (b >= 0) && (a + b < 1);
  // }

}
