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
public class Calculo {
    
    private ArrayList<Cruce> resultado; 
    private ArrayList<Cruce> explorados;
    
    public ArrayList<Cruce> recursiveSearch(ArrayList<Cruce> resultado, ArrayList<Cruce> explorados, Cruce inicio, Cruce fin){
        
        if(explorados.contains(inicio))
            return null;

        if(inicio.Equals(fin))
            return resultado;
        
        
        explorados.add(inicio);
        ArrayList<Cruce> neighbors = inicio.getNeighbors();
        ArrayList<Cruce> tmp;
        
        for(int i=0;i<neighbors.size() && !resultado.contains(fin);i++){
            tmp = recursiveSearch(resultado, explorados, neighbors.get(i), fin);
            explorados.add(neighbors.get(i));
            if (tmp!=null)
                resultado.add(0,neighbors.get(i));
            
        }
        
        return resultado;
        
    }
    
    public ArrayList<Cruce> search(Cruce inicio, Cruce fin){
        resultado = new ArrayList<Cruce>();
        explorados = new ArrayList<Cruce>();
        resultado = recursiveSearch(resultado, explorados, inicio, fin);
        resultado.add(0,inicio);
        return resultado;
    }
    
}
