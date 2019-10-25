// Ami Oka
// This program draws fractal polygons using recursion

import java.util.*;
import javax.swing.JFrame;
import java.awt.geom.Line2D;

public class Polygon {
   
   public static final double CIRCLE_DEGREES = 360;
   private LinePanel panel;
   private double newlenFactor;
   private int n;
   
   // Constructs a new hexagon hexagon with given number of layers
   // the given length of one side.
   // It draws from a point that makes the drawing in the center.
   public Polygon(LinePanel panel, int n, int layer, double length) {
      this.panel = panel;
      this.n = n;
      newlenFactor = 1.0 / (verticalLength() + 1) / 2.0;
      
      double x = verticalLength() * length;
      double y = 0;
      
      drawPolygons(layer, length, x, y, 0);
   }
   
   // Draws n polygon with given number of layers left, and the
   // given length of one side starting from the given x and y.
   private void drawPolygons(int layer, double length, double x, double y, double angle) {
      if (length <= 0 || layer < 0) {
         throw new IllegalArgumentException();
      }
      if (layer == 0) {
         drawOnePolygon(length, x, y, angle);
      } else {
         double newLen = length * newlenFactor;

         for (double i = 0; i < n; i++) {
            drawPolygons(layer - 1, newLen, x, y, angle);
            x += length * cos(angle);
            y += length * sin(angle);
            angle += CIRCLE_DEGREES / n;
         }   
      }
   }
   
   // Draws one given n polygon with the given length of one side starting
   // from the given x and y.
   private void drawOnePolygon(double length, double x, double y, double angle) {
      for (double i = 0; i < n; i++) {
         double newX = x + length * cos(angle);
         double newY = y + length * sin(angle);
         panel.addLine(new Line2D.Double(x, y, newX, newY));
         x = newX;
         y = newY;
         angle += CIRCLE_DEGREES / n;
      }
   }
   
   // Finds the maximum vertical length of the polygon from the base line
   private double verticalLength() {
      double x = 0;
      double y = 0;
      double angle = 0;
      double maxX = 0;
      for (double i = 0; i < n; i++) {
         maxX = Math.max(maxX, x);
         x = x + cos(angle);
         y = y + sin(angle);
         angle += CIRCLE_DEGREES / n;
      }
      return maxX - 1;
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