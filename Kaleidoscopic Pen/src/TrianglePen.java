import java.util.ArrayList;
import processing.core.PApplet;

public class TrianglePen {

  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private ArrayList<Point> points; //list of points used to create the triangle
  private ArrayList<Triangle> triangles; //list of triangles already initiated
  private PApplet drawTo; //
  private boolean isPointShown; //boolean evaluated true if a point is shown on screen
  private Point currentPoint;
  // private Triangle currentTriangle;

  /**
   * re-initializes the variables once a triangle has been made
   * @param processing
   * @param showPoints
   */
  public TrianglePen(PApplet processing, boolean showPoints) {
    mouseWasPressed = false;
    keyWasPressed = '0';
    points = new ArrayList<Point>();
    triangles = new ArrayList<Triangle>();
    drawTo = processing;
    isPointShown = showPoints;
    currentPoint = null;
    // currentTriangle = null;

  }


  /**
   * Draws a point when mouse is pressed, changes color when key is pressed while mouse is on top of a triangle
   * @param mouseX
   * @param mouseY
   * @param mousePressed
   * @param keyPressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    // process mouse-based user input
    if (mousePressed != mouseWasPressed) {
      if (mousePressed)
        handleMousePress(mouseX, mouseY);
      else
        handleMouseRelease(mouseX, mouseY);
    }

    if (mousePressed)
      handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;

    // process keyboard-based user input
    if (keyPressed != keyWasPressed) {
      handleKeyPress(mouseX, mouseY, keyPressed);
    }

    keyWasPressed = keyPressed;

    // draw everything in its current state
    draw();

  }

  /**
   * Callback method draws continuously this application window display
   */
  private void draw() {
    if (isPointShown) {
      for (int i = 0; i < points.size(); i++) {
        points.get(i).draw(drawTo);
      }
      // System.out.println("this is the " + points.size() + " point");
      // currentPoint.draw(drawTo);
    }

    for (int i = 0; i < triangles.size(); i++) {
      triangles.get(i).draw(drawTo);
    }
    // System.out.println("this is the " + triangles.size() + " triangle");
    // currentTriangle.draw(drawTo);
  }

  /**
   * Sets the color of the triangle according to the key pressed
   * @param mouseX
   * @param mouseY
   * @param keyPressed
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    if (keyPressed >= '0' && keyPressed <= '7') {
      for (int i = 0; i < triangles.size(); i++) {
        if (triangles.get(i).isOver(mouseX, mouseY)) {
          triangles.get(i).setColor(keyPressed - '0');
        }
      }
    }
  }

  /**
   * Drags the triangle point along until the key is released
   * @param mouseX
   * @param mouseY
   */
  private void handleMouseDrag(int mouseX, int mouseY) {
    if (currentPoint != null) {
      currentPoint.setPosition(mouseX, mouseY);
    }
  }

  /**
   * Sets the triangle point position where the mouse key is released.
   * @param mouseX
   * @param mouseY
   */
  private void handleMouseRelease(int mouseX, int mouseY) {
    if (currentPoint != null) {
      // currentPoint.setPosition(mouseX, mouseY);
      currentPoint = null;
    }


  }

  /**
   * Creates the triangle point.
   * @param mouseX
   * @param mouseY
   */
  private void handleMousePress(int mouseX, int mouseY) {
    if (points.size() == 0) {
      currentPoint = new Point(mouseX, mouseY);
      points.add(currentPoint);
      // System.out.println("one more new point");
      // currentPoint = null;
    } else {

      boolean anyPointOverByMouse = false;
      for (int i = 0; i < points.size(); i++) {
        if (points.get(i).isOver(mouseX, mouseY)) {
          currentPoint = points.get(i);
          anyPointOverByMouse = true;
          // System.out.println("you get this point");
          break;
        }
      }

      if (anyPointOverByMouse == false) {
        currentPoint = new Point(mouseX, mouseY);
        points.add(currentPoint);
        // System.out.println("one more new point");
      }

      // currentPoint = null;
      if (points.size() % 3 == 0) {
        Triangle newTriangle = new Triangle(points.get(points.size() - 3),
            points.get(points.size() - 2), points.get(points.size() - 1), 0);
        triangles.add(newTriangle);
        // System.out.println("one more new triangle");
        // currentPoint = null;
      }
    }
  }
}


