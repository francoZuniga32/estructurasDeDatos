package conjuntitas.dinamico;

/**
 * @author franco
 */
public class NodoBB {
    private Comparable elemento;
    private NodoBB izquirdo;
    private NodoBB derecho;
    
    public NodoBB(Comparable argElemento, NodoBB argNodoIzquierdo, NodoBB argNodoDerecho){
        this.elemento = argElemento;
        this.izquirdo = argNodoIzquierdo;
        this.derecho = argNodoDerecho;
    }
    
    public void setElemento(Comparable argElemento){
        this.elemento = argElemento;
    }
    
    public Comparable getElemento(){
        return this.elemento;
    }
    
    public void setIzquierdo(NodoBB argNodoIzquierdo){
        this.izquirdo = argNodoIzquierdo;
    }
    
    public NodoBB getIzquierdo(){
        return this.izquirdo;
    }
    
    public void setDerecho(NodoBB argNodoDerecho){
        this.derecho = argNodoDerecho;
    }
    
    public NodoBB getDerecho(){
        return this.derecho;
    }
}
