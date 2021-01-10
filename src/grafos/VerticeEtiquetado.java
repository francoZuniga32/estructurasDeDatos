package grafos;

public class VerticeEtiquetado {
	private Object elemento;
    private VerticeEtiquetado sigVertice;
    private AdyacenteEtiquetado primerAdy;
    
    public VerticeEtiquetado(Object elem, VerticeEtiquetado nodoVertice, AdyacenteEtiquetado nodoAdy) {
    	this.elemento = elem;
    	this.sigVertice = nodoVertice;
    	this.primerAdy = nodoAdy;
    }
    
    public Object getElemento() {
    	return this.elemento;
    }
    
    public VerticeEtiquetado getSigVertice(){
    	return this.sigVertice;
    }
    
    public AdyacenteEtiquetado getAdyacente() {
    	return this.primerAdy;
    }
    
    public void setElemento(Object elem) {
    	this.elemento = elem;
    }
    
    public void setSigVertice(VerticeEtiquetado nodo) {
    	this.sigVertice = nodo;
    }
    
    public void setAdyacente(AdyacenteEtiquetado nodo) {
    	this.primerAdy = nodo;
    }
    
    public boolean equals(VerticeEtiquetado elem) {
    	return this.elemento.equals(elem.elemento);
    }
}
