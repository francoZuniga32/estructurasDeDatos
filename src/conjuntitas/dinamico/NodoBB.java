package conjuntitas.dinamico;

/**
 * @author franco
 */
public class NodoBB {
    private Comparable elemento;
    private NodoBB nodoIzquierdo;
    private NodoBB nodoDerecho;
    
    public NodoBB(Comparable argElemento, NodoBB argNodoIzquierdo, NodoBB argNodoDerecho){
        this.elemento = argElemento;
        this.nodoIzquierdo = argNodoIzquierdo;
        this.nodoDerecho = argNodoDerecho;
    }
    
    public void setElemento(Comparable argElemento){
        this.elemento = argElemento;
    }
    
    public Comparable getElemento(){
        return this.elemento;
    }
    
    public void setNodoIzquierdo(NodoBB argNodoIzquierdo){
        this.nodoIzquierdo = argNodoIzquierdo;
    }
    
    public NodoBB getNodoIzquierdo(){
        return this.nodoIzquierdo;
    }
    
    public void setNodoDerecho(NodoBB argNodoDerecho){
        this.nodoDerecho = argNodoDerecho;
    }
    
    public NodoBB getNodoDerecho(){
        return this.nodoDerecho;
    }
}
