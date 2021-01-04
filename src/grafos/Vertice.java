/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author franco
 */
public class Vertice {
    private Object elemento;
    private Vertice sigVertice;
    private Adyacente primerAdy;
    
    public Vertice(Object elem, Vertice nodoVertice, Adyacente nodoAdy) {
    	this.elemento = elem;
    	this.sigVertice = nodoVertice;
    	this.primerAdy = nodoAdy;
    }
    
    //observadores
    
    public Object getElemento() {
    	return this.elemento;
    }
    
    public Vertice getSigVertice(){
    	return this.sigVertice;
    }
    
    public Adyacente getAdyacente() {
    	return this.primerAdy;
    }
    
    //modificadores
    
    public void setElemento(Object elem) {
    	this.elemento = elem;
    }
    
    public void setSigVertice(Vertice nodo) {
    	this.sigVertice = nodo;
    }
    
    public void setAdyacente(Adyacente nodo) {
    	this.primerAdy = nodo;
    }
}
