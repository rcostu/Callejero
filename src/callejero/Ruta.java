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
/**
 *
 * @author roberto
 */
public class Ruta{
    
    ArrayList<Cruce> route;
    Cruce origin;
    Cruce destination;
    
    public Ruta (Cruce origin, Cruce destination){
        this.origin = origin;
        this.destination = destination;
    }
    
    /**
     * Calcular una ruta de un origen a un destino
     * @throws Exception 
     */
    public void calcular() throws Exception {
        this.route =  new Calculo().search(origin, destination);
        if (this.route == null) {
            throw new Exception("Ruta no encontrada");
        }
    }
    
    public void calculo(ArrayList<Cruce> puntos) throws Exception {
        Cruce cAnt = null;
        for (final Cruce c: puntos) {
            if (cAnt != null) {
                ArrayList<Cruce> tmp = new Calculo().search(cAnt, c);
                if (tmp == null) {
                    throw new Exception("ruta no encontrada");
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
            this.route.get(i).highlightCruce(g, this.route.get(++i));
        }
    }
}