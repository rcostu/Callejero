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
import javax.swing.ImageIcon;

/**
 *
 * @author hui
 */
public class Mapa extends javax.swing.JPanel {
    
    private ArrayList<Cruce> cruces = new ArrayList<Cruce>();
    public Ruta ruta; 
    public Transporte transporte;
    public Spot almacen;
    private int x, y;
    /**
     * Creates new form Mapa
     */
    public Mapa() {
        initComponents();
    }
    /**
     * Sobreescribir el metodo paintcomponent
     * @param g 
     */
   @Override
    public void paint(Graphics g) {
       //se dibuja las cruces
        super.paint(g);
        for (final Cruce c : cruces) {
            c.paint(g);
            c.drawCruce(g);
        }
        // se dibuja la ruta
        this.ruta.paint(g);
        // se dibuja el almacen
        this.almacen.paint(g);
        // se dibuja el camion
        this.transporte.paint(g);             
    }
   
   public void addTransporte(Transporte t){
       this.transporte = t;
       this.transporte.move(ruta.points.get(0));
   }
    /**
     *
     * @param c
     */  
    public void addCruce(Cruce c) {
        this.cruces.add(c);
    }

       /**
        * 
        */
       public int obtenerX(){
           return this.x;
       }
       
       /**
        * 
        */
       public int obtenerY(){
           return this.y;
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 207));
        setPreferredSize(new java.awt.Dimension(900, 900));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
        System.out.println(x);
        System.out.println(y);
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
