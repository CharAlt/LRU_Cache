
package prueba;

public class Nodo <T>{
    /*implementation of dobuly linked list's node*/
    
    private Nodo<T> sig,ant;
    private T dato;
    private int id;
    
    
    public Nodo(T dato, int id){
        setDato(dato);
        setId(id);
    }  
    
    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo anto) {
        this.ant = anto;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
      
}
