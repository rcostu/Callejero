/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tourism;

import cartograph.Cruce;
import cartograph.Spot;
import cartograph.Transporte;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author alvaro
 */
public class paqueteTuristico implements Observer {
    
    private ArrayList<Hotel> hotels = new ArrayList<Hotel>();
    private Cruce c;
    
    public paqueteTuristico (Cruce c) {
        this.c = c;
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof Transporte) {
            Transporte transporte  = (Transporte)o;
            if (transporte.arrives(this.c))
                JOptionPane.showInputDialog(
                    null,
                    "Seleccione un hotel",
                    "Selector de hoteles",
                    JOptionPane.QUESTION_MESSAGE,
                    null,  // null para icono defecto
                    hotels.toArray(), 
                    null);
                //JOptionPane.showMessageDialog(null, "Desea alojarse aqui?");
        }
        if (o instanceof Hotel) {
            if (c.Equals(((Hotel) o).getLocation()))
                hotels.add((Hotel) o);
        }
    }
    
}
