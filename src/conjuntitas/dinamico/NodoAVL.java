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
        int alturaDerecho = 0;
        int alturaIzquierdo = 0;
        if(this.izquirdo != null){
            alturaIzquierdo = this.izquirdo.getAltura();
        }
        
        if(this.derecho != null){
            alturaDerecho = this.derecho.getAltura();
        }
        
        this.altura = Math.max(alturaIzquierdo, alturaDerecho);
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
