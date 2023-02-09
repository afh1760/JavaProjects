import processing.core.PApplet;

public class Point {

  private final static int POINT_DIAMETER = 8;

  private int xPos; // mouse position in x axis
  private int yPos; // mouse position in y axis

  /**
   * sets point at the xy coordinate
   * @param x
   * @param y
   */
  public Point(int x, int y) {
    xPos = x;
    yPos = y;
  }

  /**
   * getting x position of mouse
   * @return
   */
  public int getX() {
    return xPos;
  }

  /**
   * getting y position of mouse
   * @return
   */
  public int getY() {
    return yPos;
  }

  /**
   * keeping track of mouse position and assigning xPos and yPos to x and y
   * @param x
   * @param y
   */
  public void setPosition(int x, int y) {
    xPos = x;
    yPos = y;
  }

  // draw a white circle at this point's position
  public void draw(PApplet drawTo) {
    drawTo.fill(-1);
    // drawTo.ellipse(xPos, yPos, POINT_DIAMETER, POINT_DIAMETER);
    drawTo.circle(xPos, yPos, POINT_DIAMETER);
  }


  // returns true when the position x, y
  // is within the circle drawn to visualize this point, otherwise returns false
  public boolean isOver(int x, int y) {
    double d = Math.sqrt((x - xPos) * (x - xPos) + (y - yPos) * (y - yPos));
    if (d < POINT_DIAMETER / 2)
      return true;
    else
      return false;
  }


}
