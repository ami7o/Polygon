// Ami Oka
// This program uses Polygon class to draw recursive polygons

import java.util.*;
import javax.swing.JFrame;

public class PolygonMain {

   public static void main(String[] args) {
      JFrame frame = new JFrame("Polygon");
      frame.setSize(620, 580);
      LinePanel panel = new LinePanel();
      frame.add(panel);
      
      Scanner console = new Scanner(System.in);
      System.out.print("Polygon number: ");
      int n = console.nextInt();
      System.out.print("Number of layer: ");
      int layer = console.nextInt();
      System.out.print("One side length: ");
      double length = console.nextDouble();
      
      new Polygon(panel, n, layer, length); 
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setVisible(true);
      panel.repaint();  
   }
}