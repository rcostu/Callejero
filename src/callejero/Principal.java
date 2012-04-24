/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import cartograph.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto
 * @author cristian
 * @author alvaro
 * @author hui
 * 
 */
public class Principal {
    
    private Mapa mapa = new Mapa();


    
    public void test() {
        Cruce c1 = new Cruce (25,665, "Lisboa");
        Cruce c2 = new Cruce (140,670, "Madrid");
        Cruce c3 = new Cruce (235,655, "Barcelona");
        Cruce c4 = new Cruce (270,500, "París");
        Cruce c5 = new Cruce (240,430, "Londres");
        Cruce c6 = new Cruce (155,380, "Dublín");
        Cruce c7 = new Cruce (60,100, "Reikiavik");
        Cruce c8 = new Cruce (170,350, "Belfast");
        Cruce c9 = new Cruce (215,325, "Edimburgo");
        Cruce c10 = new Cruce (425,630, "Roma");
        Cruce c11 = new Cruce (750,280, "Moscú");
        Cruce c12 = new Cruce (340,615, "Mónaco");
        Cruce c13 = new Cruce (390,575, "Milán");
        Cruce c14 = new Cruce (310,450, "Bruselas");
        Cruce c15 = new Cruce (325,415, "Amsterdam");
        Cruce c16 = new Cruce (500,520, "Viena");
        Cruce c17 = new Cruce (340,475, "Luxemburgo");
        Cruce c18 = new Cruce (355,545, "Berna");

        this.mapa.addCruce(c1);
        this.mapa.addCruce(c2);
        this.mapa.addCruce(c3);
        this.mapa.addCruce(c4);
        this.mapa.addCruce(c5);
        this.mapa.addCruce(c6);
        this.mapa.addCruce(c7);
        this.mapa.addCruce(c8);
        this.mapa.addCruce(c9);
        this.mapa.addCruce(c10);
        this.mapa.addCruce(c11);
        this.mapa.addCruce(c12);
        this.mapa.addCruce(c13);
        this.mapa.addCruce(c14);
        this.mapa.addCruce(c15);
        this.mapa.addCruce(c16);
        this.mapa.addCruce(c17);
        this.mapa.addCruce(c18);
        
        
        c1.addNeighbor(c2);
        c2.addNeighbor(c1);
        c2.addNeighbor(c3);
        c3.addNeighbor(c2);
        c2.addNeighbor(c4);
        c4.addNeighbor(c2);
        c3.addNeighbor(c4);
        c4.addNeighbor(c3);
        c4.addNeighbor(c5);
        c5.addNeighbor(c4);
        c5.addNeighbor(c9);
        c9.addNeighbor(c5);
        c6.addNeighbor(c8);
        c8.addNeighbor(c6);
        c3.addNeighbor(c12);
        c12.addNeighbor(c3);
        c4.addNeighbor(c12);
        c12.addNeighbor(c4);
        c12.addNeighbor(c13);
        c13.addNeighbor(c12);
        c13.addNeighbor(c10);
        c10.addNeighbor(c13);
        c4.addNeighbor(c14);
        c14.addNeighbor(c4);
        c14.addNeighbor(c15);
        c15.addNeighbor(c14);
        c13.addNeighbor(c16);
        c16.addNeighbor(c13);
        c14.addNeighbor(c17);
        c17.addNeighbor(c14);
        c17.addNeighbor(c18);
        c18.addNeighbor(c17);
        c13.addNeighbor(c18);
        c18.addNeighbor(c13);
        c11.addNeighbor(c16);
        c16.addNeighbor(c11);
        c11.addNeighbor(c15);
        c15.addNeighbor(c11);
        
        ArrayList<Cruce> prueba = new ArrayList<Cruce>();
        
        prueba.add(c1);
        prueba.add(c3);
        prueba.add(c10);
        
        mapa.ruta = new Ruta(prueba);
        
        int cantidad = 50;
        mapa.almacen = new Almacen(prueba.get(0).getX(),prueba.get(0).getY(),cantidad,"../images/almacen.png");
        
        Camion camion = new Camion("../images/camion.png");
        
        mapa.addTransporte(camion);
        
        try {
            mapa.ruta.calcular();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ruta no encontrada");
        }
        //r.draw(this.mapa);
        
        mapa.transporte.drive(mapa);
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public static void main(String args[]) {
        Principal p = new Principal();
        p.test();
        
    }
}
