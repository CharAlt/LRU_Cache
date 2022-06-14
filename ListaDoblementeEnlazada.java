
package prueba;


public class ListaDoblementeEnlazada <T>{
    /*all this is the implement of a Doubly linked List */
    
    private Nodo<T> ini;
    private Nodo<T> ult;
    
    void insertarDato(T dato, int id){
        Nodo<T> aux;
        aux = new Nodo<>(dato,id);
        
        if(ini == null){
            ini = aux;
            aux.setSig(null);
            ult = aux;
        }
        else{
            getIni().setAnt(aux);
            aux.setSig(ini);
            ini = aux;
        }
        ini.setAnt(null);
    }
    

    public Nodo<T> getIni() {
        return ini;
    }

    public Nodo<T> getUlt() {
        return ult;
    }

    public void setIni(Nodo<T> ini) {
        this.ini = ini;
    }

    public void setUlt(Nodo<T> ult) {
        this.ult = ult;
    }
   
}
