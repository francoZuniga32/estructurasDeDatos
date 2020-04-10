/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamico;

/**
 *
 * @author franco
 */
public class NodoArbol {
    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol(Object elemento, NodoArbol izquierdo, NodoArbol derecho){
        this.elemento = elemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    //observadores
    /***
     * retornamos el elemento del nodo arbol
     * @return Object
     */
    public Object getElemento(){
        return this.elemento;
    }
    
    /***
     * retornamos el nodo arbol izquierdo
     * @return 
     */
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    /***
     * retornamos el nodo derecho
     * @return NodoArbol
     */
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
    //modificadores
    /***
     * almacenamos el elemento en el nodo arbol
     * @param elemento 
     */
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    /***
     * almacenamos un nodo arbol en el nodo izquierdo
     * @param izquierdo 
     */
    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo = izquierdo;
    }
    
    /***
     * almacenamos el nodo arbol del nodo derecho
     * @param derecho 
     */
    public void setDerecho(NodoArbol derecho){
        this.derecho = derecho;
    }
}
