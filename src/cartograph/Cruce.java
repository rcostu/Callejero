/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartograph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 *
 * @author roberto
 * @author cristian
 * @author alvaro
 * @author hui
 * 
 */
public class Cruce {

    private int x;
    private int y;
    private String name;
    private final ArrayList<Cruce> neighbors = new ArrayList<Cruce>();

    

    /**
     * 
     * @param x
     * @param y 
     */
    public Cruce (int x, int y, String name){
        
        this.x = x;
        this.y = y;
        this.name = name;

    }
    
    /**
     * 
     * @param cruce 
     */
    public void addNeighbor(Cruce cruce) {
        neighbors.add(cruce);
    }
    
    /**
     * 
     * @param g 
     */
    public void paint(Graphics g) {
        g.drawRect(x-3, y-3, 6, 6);
        g.fillRect(this.x-3, this.y-3, 6, 6);
        g.setColor(Color.BLACK);
        g.drawString(this.name, this.x+5, this.y-8);
        
    }
    
    /**
     * 
     * @param g 
     */
    public void drawCruce(Graphics g){        
        
        for (Cruce c : this.neighbors){
            Graphics2D g2d = (Graphics2D) g;

            // Road
            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(9));
            g.drawLine(x, y, c.getX(), c.getY());

            // Dashed line
            g2d.setColor(Color.white);
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
            g.drawLine(x, y, c.getX(), c.getY());
        }        
    }
    
    public void highlightCruce(Graphics g, Cruce b){
        
        g.drawLine(x, y, b.getX(), b.getY());
        
    }
    
        
    
    public boolean Equals(Cruce c){
        
        return this.x == c.x && this.y == c.y;
        
    }
    
    
    @Override
    public String toString(){
        
        StringBuilder result = new StringBuilder();
        result.append(this.name);
        return result.toString();
        
    }
    
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public ArrayList<Cruce> getNeighbors(){
        return this.neighbors;
    }


}
