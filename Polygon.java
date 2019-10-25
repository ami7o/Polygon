// Ami Oka
// This program draws fractal hexagons using recursion

import java.util.*;
import javax.swing.JFrame;
import java.awt.geom.Line2D;

public class Polygon {
   
   private LinePanel panel;
   public static final double CIRCLE_DEGREES = 300;
   
   public static void main(String[] args) {
      new Polygon();   
   }
   
   // Constructs a new hexagon hexagon with given number of layers
   // the given length of one side.
   // It draws from a point that makes the drawing in the center.
   public Polygon() {
      JFrame frame = new JFrame("Polygon");
      frame.setSize(620, 580);
      panel = new LinePanel(new ArrayList<Line>());
      frame.add(panel);
      
      Scanner console = new Scanner(System.in);
      System.out.print("Polygon number: ");
      int n = console.nextInt();
      //int n = 7;
      System.out.print("Number of layer: ");
      int layer = console.nextInt();
      //int layer = 1;
      System.out.print("One side length: ");
      double length = console.nextDouble();
      //double length = 200;
      double x = cos(360 / n) * length;
      double y = 0;
      
      drawPolygons(n, layer, length, x, y, 0);
      frame.repaint();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setVisible(true);
      panel.repaint();
   }
   
   // Draws n polygon with given number of layers left, and the
   // given length of one side starting from the given x and y.
   private void drawPolygons(int n, int layer, double length, double x, double y, double angle) {
      if (length <= 0 || layer < 0) {
         throw new IllegalArgumentException();
      }
      if (layer == 0) {
         drawOnePolygon(n, length, x, y, angle);
      } else {
         //drawOnePolygon(n, length, x, y, angle);
         
         double height = length / 2 * tan(CIRCLE_DEGREES / 2 / n);
         double newlen = height / sin(CIRCLE_DEGREES / n);

         for (double i = 0; i < n; i++) {
            drawPolygons(n, layer - 1, newlen, x, y, angle);
            x += length * cos(angle);
            y += length * sin(angle);
            angle += CIRCLE_DEGREES / n;
         }   
      }
   }
   
   // Draws one given n polygon with the given length of one side starting
   // from the given x and y.
   private void drawOnePolygon(int n, double length, double x, double y, double angle) {
      for (double i = 0; i < n; i++) {
         double newx = x + length * cos(angle);
         double newy = y + length * sin(angle);
         panel.addLine(new Line2D.Double(x, y, newx, newy));
         x = newx;
         y = newy;
         angle += CIRCLE_DEGREES / n;
      }
   }
   
   // returns sine of given angle in degrees
   private double sin(double angle) {
      return Math.sin(Math.toRadians(angle));
   }
   
   // returns cosine of given angle in degrees
   private double cos(double angle) {
      return Math.cos(Math.toRadians(angle));
   }
   
   // returns cosine of given angle in degrees
   private double tan(double angle) {
      return Math.tan(Math.toRadians(angle));
   }
}