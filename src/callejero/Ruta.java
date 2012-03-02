/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

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
}