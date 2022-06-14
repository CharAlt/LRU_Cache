
package prueba;

import javax.swing.JOptionPane;

public class LRUCache<T> {
    /*
    */
    
    private Hashing<T> tabla = new Hashing<>();
    private ListaDoblementeEnlazada<T> lista = new ListaDoblementeEnlazada<>();
    private Nodo<T>[] vec = tabla.getVector();
    private int n =4, dim =0;   
    public static void main(String[] args) {
        LRUCache<Integer> lruc = new LRUCache<>();
        /*test..*/
        
        lruc.put(0, 3);
        lruc.put(1, 10);
        lruc.put(2, 14);
        
        lruc.imprimirLista();
        System.out.println("");
        
        int clave;
        int dato;
        clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una llave para consultar"));
        while(clave != -1){
            lruc.get(clave);
            lruc.imprimirLista();
            System.out.println("");
            clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una llave para consultar"));
        }
        
        clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una llave para insertar"));
        while(clave != -1){
            dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una valor para insertar"));
            lruc.put(clave, dato);
            lruc.imprimirLista();
            System.out.println("");
            clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una llave para insertar"));
        }
      
        
        System.out.println("consultas");
        clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una llave"));
        while(clave != -1){
            lruc.get(clave);
            lruc.imprimirLista();
            System.out.println("");
            clave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una llave"));
        }
    }
     
    void put(int llave, T dato){
        
        if(llave >=0 && llave <= vec.length-1){
            
            if(vec[llave] != null){
                vec[llave].setDato(dato);
                reacomodar(llave);
            }    
            else{
                if(dim+1 > n)
                    eliminarUltimoMenosUsado();
                else
                    dim++;
                
                lista.insertarDato(dato,llave);
                vec[llave] = lista.getIni();
            }
        }    
    }
    
    private void reacomodar(int clave){
        Nodo<T> nodo = vec[clave];
        if(nodo != lista.getIni()){           
            Nodo<T> ant = nodo.getAnt();
            ant.setSig(nodo.getSig());

            if(lista.getUlt() == nodo)
                lista.setUlt(ant);
            else
                nodo.getSig().setAnt(ant);

            lista.getIni().setAnt(nodo);
            nodo.setAnt(null);
            nodo.setSig(lista.getIni());
            lista.setIni(nodo);
        }        
    }
    
    Nodo<T> get(int clave){
        if(clave >=0 && clave <=vec.length-1){
            reacomodar(clave);
            return vec[clave];
        }
        return null;
    }
    
    void imprimirLista(){
        Nodo<T> aux = lista.getIni();
        
        while(aux != null){
            System.out.println(aux.getDato());
            aux = aux.getSig();
        }
    }
    
    private void eliminarUltimoMenosUsado(){      
        vec[lista.getUlt().getId()] = null;
        lista.setUlt(lista.getUlt().getAnt());
        lista.getUlt().setSig(null);
    }
}
