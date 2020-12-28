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
public class NodoVertice {
    private Object elemento;
    private NodoVertice sigVertice;
    private NodoAdy primerAdy;
    
    public NodoVertice(Object elem, NodoVertice nodoVertice, NodoAdy nodoAdy) {
    	this.elemento = elem;
    	this.sigVertice = nodoVertice;
    	this.primerAdy = nodoAdy;
    }
    
    //observadores
    
    public Object getElemento() {
    	return this.elemento;
    }
    
    public NodoVertice getSigVertice(){
    	return this.sigVertice;
    }
    
    public NodoAdy getNodoAdy() {
    	return this.primerAdy;
    }
    
    //modificadores
    
    public void setElemento(Object elem) {
    	this.elemento = elem;
    }
    
    public void setSigVertice(NodoVertice nodo) {
    	this.sigVertice = nodo;
    }
    
    public void setNodoAdy(NodoAdy nodo) {
    	this.primerAdy = nodo;
    }
}
