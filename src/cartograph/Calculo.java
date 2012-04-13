/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartograph;

import java.util.ArrayList;

/**
 *
 * @author roberto
 */
public class Calculo {
    
    private ArrayList<Cruce> resultado = new ArrayList<Cruce>(); 
    private ArrayList<Cruce> explorados = new ArrayList<Cruce>();
    
    public ArrayList<Cruce> recursiveSearch(Cruce inicio, Cruce fin){
        
        if(explorados.contains(inicio))
            return null;

        if(inicio.Equals(fin)) {
            resultado.add(fin);
            return resultado;
        }
        explorados.add(inicio);
        ArrayList<Cruce> neighbors = inicio.getNeighbors();
        ArrayList<Cruce> tmp;
        
        for(int i=0;i<neighbors.size() && !resultado.contains(fin);i++){
            tmp = recursiveSearch(neighbors.get(i), fin);
            System.out.println(i+" "+tmp);
            if (tmp!=null && tmp.contains(fin) && neighbors.get(i)!=fin)
                resultado.add(0,neighbors.get(i));   
        }
        return resultado;
    }
    
    public ArrayList<Cruce> search(Cruce inicio, Cruce fin){
        recursiveSearch(inicio, fin);
        resultado.add(0,inicio);
        if (!resultado.contains(fin)) {
            return null;
        }
        System.out.println(resultado);
        return resultado;
    }

    /**
     * Encontrar una ruta del punto inicio al punto fin pasando
     * por los puntos intermedios
     * @param inicio
     * @param fin
     * @param puntosIntermedios
     * @return 
     */
    public ArrayList<Cruce> search(Cruce inicio, Cruce fin, ArrayList<Cruce> puntosIntermedios) {
        for(int i = 0; i < puntosIntermedios.size(); i++){
            this.search(inicio, puntosIntermedios.get(i));
            
        }
          return resultado;
    }
    
}
