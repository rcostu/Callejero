/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package callejero;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author roberto
 * @author cristian
 * @author alvaro
 * @author hui
 * 
 */
public class Principal extends javax.swing.JFrame {
    
    private Mapa mapa = new Mapa();

    /**
     * Creates new form Principal
     */
    public Principal() {
        mapa.setPreferredSize(new Dimension(900,900));
        this.add(mapa, BorderLayout.CENTER);
        this.pack();
        initComponents();
    }
    
    public void test() {
        Cruce c1 = new Cruce (20,40, "C1");
        Cruce c2 = new Cruce (60,40, "C2");
        Cruce c3 = new Cruce (20,80, "C3");
        Cruce c4 = new Cruce (60,80, "C4");
        Cruce c5 = new Cruce (120,80, "C5");
        Cruce c6 = new Cruce (250,140, "C6");
        Cruce c7 = new Cruce (230,400, "C7");
        Cruce c8 = new Cruce (500,60, "C8");
        Cruce c9 = new Cruce (600,300, "C9");

        this.mapa.addCruce(c1);
        this.mapa.addCruce(c2);
        this.mapa.addCruce(c3);
        this.mapa.addCruce(c4);
        this.mapa.addCruce(c5);
        this.mapa.addCruce(c6);
        this.mapa.addCruce(c7);
        this.mapa.addCruce(c8);
        this.mapa.addCruce(c9);

        c1.addNeighbor(c2);
        c2.addNeighbor(c1);
        c1.addNeighbor(c3);
        c3.addNeighbor(c1);
        c2.addNeighbor(c4);
        c4.addNeighbor(c2);
        c3.addNeighbor(c4);
        c4.addNeighbor(c3);
        c5.addNeighbor(c6);
        c6.addNeighbor(c5);
        c4.addNeighbor(c5);
        c5.addNeighbor(c4);
        c6.addNeighbor(c7);
        c7.addNeighbor(c6);
        c6.addNeighbor(c8);
        c8.addNeighbor(c6);
        c5.addNeighbor(c8);
        c8.addNeighbor(c5);
                
        mapa.ruta = new Ruta(c1,c8);
        
        mapa.camion = new Camion(mapa.ruta.origin.getX(), mapa.ruta.origin.getY());
        
        try {
            mapa.ruta.calcular();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ruta no encontrada");
        }
        //r.draw(this.mapa);
        
        for(final Cruce c : mapa.ruta.route) {
            mapa.camion.move(c);
        }
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            final Principal principal = new Principal();
            @Override
            public void run() {
                principal.setVisible(true);
                principal.test();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}