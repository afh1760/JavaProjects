
import processing.core.PApplet;
import java.lang.Math;

public class KaleidoscopePen {

  private TrianglePen[] trianglePens;

  /**
   * Puts in the coordinates of the triangle - points
   * @param drawTo
   * @param numberOfTrianglePens
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    trianglePens = new TrianglePen[numberOfTrianglePens];
    for (int i = 0; i < trianglePens.length; i++) {
      trianglePens[i] = new TrianglePen(drawTo, true);
    }
  }
  
  /**
   * Automatically gives out four other points when clicking or selecting a point by calling the rotate method.
   * @param mouseX - mouse position in x axis
   * @param mouseY - mouse position in y axis
   * @param mousePressed - when mouse is pressed
   * @param keyPressed - when key in keyboard is pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    for (int i = 0; i < trianglePens.length; i++) {
      int tempX = rotate(mouseX, mouseY, i * 2 * Math.PI / trianglePens.length)[0];
      int tempY = rotate(mouseX, mouseY, i * 2 * Math.PI / trianglePens.length)[1];
      trianglePens[i].update(tempX, tempY, mousePressed, keyPressed);
    }
  }


  /**
   * Rotates a position around the center of an 800x600 screen by the specified amount, and then
   * returns an array containing the resulting position.
   * 
   * @param x     position of the point to be rotated (0 to 800 pixels)
   * @param y     position of the point to be rotated (0 to 600 pixels)
   * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI)
   * @return the rotated position array: x @ index 0, y @ index 1
   */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
        (int) (x * Math.cos(angle) - y * Math.sin(angle)),
        (int) (x * Math.sin(angle) + y * Math.cos(angle))};
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
  }


}
