/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import java.awt.*;
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
        g.drawString(this.name, this.x+5, this.y-8);
        
    }
    
    /**
     * 
     * @param g 
     */
    public void drawCruce(Graphics g){        
        
        for (Cruce c : this.neighbors){
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
        result.append("(");
        result.append(x);
        result.append(",");
        result.append(y);
        result.append(")");
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
