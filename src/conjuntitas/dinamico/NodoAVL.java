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
        int altura = 0;
        if(this.izquirdo != null || this.derecho != null){
            
            int alturaIzquierdo = this.izquirdo.getAltura();
            int alturaDerecho = this.derecho.getAltura();
            //tomamos al altura mas grande de los hijos
            if(alturaIzquierdo >= alturaDerecho){
                altura = alturaIzquierdo + 1;
            }else{
                altura = alturaDerecho + 1;
            }
            
        }
        this.altura = altura;
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
