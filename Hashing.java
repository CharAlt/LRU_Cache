
package prueba;

public class Hashing<T> {
    private Nodo<T> vec[] = new Nodo[12];
      
    void insertarClave(int pos, Nodo<T>nodo){
        vec[pos] = nodo;
    }
    
    Nodo<T>[] getVector(){
        return vec;
    }        
    
    /* we could use (n mod x) in case we have id's not going from 0 to 12
    example if we had 80 or 13, but we'll assume that our id's will go from 0 to 12
     so we are gonna store each id in the corresponding posicion of the array
     for example for the id 0 we are gonna put it in the pos 0 of the array  
    */
     
}
