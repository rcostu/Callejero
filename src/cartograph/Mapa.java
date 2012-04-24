/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartograph;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author hui
 */
public class Mapa extends javax.swing.JFrame {

    private ArrayList<Cruce> cruces = new ArrayList<Cruce>();
    public Ruta ruta;
    public Transporte transporte;
    public Spot almacen;
    private int x, y;
    private Image image = null; 

    public Mapa() {
        super("Callejero");
        setSize(900, 900);
        setVisible(true);
    }
    
    public Mapa(String background) {
        this();
        this.image = new ImageIcon(background).getImage();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Dimension tamanio = getSize();
        if (this.image!=null){
            ImageIcon imagenFondo = new ImageIcon(getClass().getResource("../images/europe.png"));        
            g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        }
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
        

        //super.paintComponent(g);
        
    }

    public void addTransporte(Transporte t) {
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
    public int obtenerX() {
        return this.x;
    }

    /**
     *
     */
    public int obtenerY() {
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

        setBackground(null);
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
