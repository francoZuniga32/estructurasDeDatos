/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntitas.dinamico;

public class NodoAVL {
    private Comparable elemento;
    private NodoAVL izquirdo;
    private NodoAVL derecho;
    private int altura;
    
    public NodoAVL(Comparable argElemento, NodoAVL argNodoIzquierdo, NodoAVL argNodoDerecho){
        this.elemento = argElemento;
        this.izquirdo = argNodoIzquierdo;
        this.derecho = argNodoDerecho;
        this.altura = 0;
    }
    
    public void setElemento(Comparable argElemento){
        this.elemento = argElemento;
    }
    
    public Comparable getElemento(){
        return this.elemento;
    }
    
    public int getAltura(){
        return this.altura;
    }
    
    public void recalcularAltura(){
        //tiene al menos un hijo por lo cual vamos a comparar sus alturas 
        int alturaDerecho = (this.derecho == null)? -1 : this.derecho.getAltura();
        int alturaIzquierdo = (this.izquirdo == null)? -1 : this.izquirdo.getAltura();
        this.altura = Math.max(alturaIzquierdo, alturaDerecho) + 1;
    }
    
    public void setIzquierdo(NodoAVL argNodoIzquierdo){
        this.izquirdo = argNodoIzquierdo;
    }
    
    public NodoAVL getIzquierdo(){
        return this.izquirdo;
    }
    
    public void setDerecho(NodoAVL argNodoDerecho){
        this.derecho = argNodoDerecho;
    }
    
    public NodoAVL getDerecho(){
        return this.derecho;
    }
}
