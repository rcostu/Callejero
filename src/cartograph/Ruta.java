/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartograph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 *
 * @author roberto
 */
public class Ruta{
    
    ArrayList<Cruce> route = new ArrayList<Cruce>();
    ArrayList<Cruce> points;
    
    public Ruta (ArrayList<Cruce> points){
        this.points = points;
    }
    
    /**
     * Calcular una ruta de un origen a un destino
     * @throws Exception 
     */
    public void calcular() throws Exception {
        Cruce cAnt = null;
        for (final Cruce c: points) {
            if (cAnt != null) {
                ArrayList<Cruce> tmp = new Calculo().search(cAnt, c);
                if (tmp == null) {
                    throw new Exception("Ruta no encontrada");
                }
                this.route.addAll(tmp);
            }
            cAnt = c;
        }
    }
    
     /**
     * Calcular una ruta de un origen a un destino pasando
     *por puntos intermedios
     * @throws Exception
     */
    /*public void calcular(ArrayList<Cruce> puntosItermedios) throws Exception {
        this.route = new Calculo().search(origin, destination);
        if (this.route == null) {
            throw new Exception("Ruta no encontrada");
        }
    }*/
    
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        ((Graphics2D)g).setStroke(new BasicStroke(4));
        int i = 0; 
        while (i < this.route.size() - 1) {
            this.route.get(i).paint(g);
            g.setColor(Color.RED);
            this.route.get(i).highlightCruce(g, this.route.get(++i));
        }
        for (final Cruce c: points){
            g.setColor(Color.green);
            c.paint(g);
        }
    }
}