// Ami Oka
// This is Panel for drawing Hexagons

import java.util.*;
import java.awt.Color;
// Ami Oka
// This is LinePanel class that can add lines and draw it

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class LinePanel extends JPanel {
   
   private List<Line2D> lines;
   
   // Constructs new LinePanel
   public LinePanel() {
      lines = new ArrayList<Line2D>();
   }
   
   // Draws all lines in the line list
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLACK);
      Graphics2D g2 = (Graphics2D) g;
      for (Line2D line : lines) {
         g2.draw(line);
      }
   }
   
   // Adds one line to the lines list
   public void addLine(Line2D line) {
      lines.add(line);
   }
}