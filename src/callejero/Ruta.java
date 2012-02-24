/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author roberto
 */
public class Ruta extends javax.swing.JFrame {
    
    ArrayList<Cruce> route;
    Cruce origin;
    Cruce destination;
    
    public Ruta (Cruce origin, Cruce destination){
        this.origin = origin;
        this.destination = destination;
    }
    
    public void calcular(){
        this.route =  new Calculo().search(origin, destination);
    }
    
    
    public void draw (Mapa m){
        Graphics g = m.getGraphics();
        g.setColor(Color.red);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(12));
 
        int i = 0;
        while (i < this.route.size()-1){
            this.route.get(i).paint(g);
            this.route.get(i).highlightCruce(g, this.route.get(++i));
        }
        this.route.get(i).paint(g);
        
    }
    

}

 
