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

    
    private final ArrayList<Cruce> vecinos = new ArrayList<Cruce>();
    
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
    
    /**
     * 
     * @param x
     * @param y 
     */
    public Cruce (int x, int y){
        
        this.x = x;
        this.y = y;

    }
    
    /**
     * 
     * @param cruce 
     */
    public void addVecino(Cruce cruce) {
        
        vecinos.add(cruce);
        
    }
    
    /**
     * 
     * @param g 
     */
    public void paint(Graphics g) {
        
        g.drawRect(x-3, y-3, 6, 6);
        g.fillRect(this.x-3, this.y-3, 6, 6);
        
    }
    
    /**
     * 
     * @param g 
     */
    public void drawCruce(Graphics g){        
        
        for (Cruce c : this.vecinos){
            g.drawLine(x, y, c.getX(), c.getY());
        }
        
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    public ArrayList<Cruce> getVecinos(){
        return this.vecinos;
    }


}
