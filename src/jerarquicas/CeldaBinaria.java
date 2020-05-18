/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author franco
 */
public class CeldaBinaria {
    private Object elemento;
    private int izquierdo;
    private int derecho;
    private boolean ocupado;
    
    public CeldaBinaria(){
        this.elemento = null;
        this.izquierdo = -1;
        this.derecho = -1;
        this.ocupado = false;
    }
    
    public  CeldaBinaria(Object argElemento, int argIzquierdo, int argDerecho){
        this.elemento = argElemento;
        this.izquierdo = argIzquierdo;
        this.derecho = argDerecho;
        this.ocupado = true;
    }
    
    //observadores
    public Object getElemento(){
        return this.elemento;
    }
    
    public int getIzquierdo(){
        return this.izquierdo;
    }
    
    public int getDerecho(){
        return this.derecho;
    }
    
    public boolean getOcupado(){
        return this.ocupado;
    }
    
    //modificadores
    public void setElemento(Object argElemento){
        this.elemento = argElemento;
    }
    
    public void setIzquierdo(int argIzquierdo){
        this.izquierdo = argIzquierdo;
    }
    
    public void setDerecho(int argDerecho){
        this.derecho = argDerecho;
    }
}
