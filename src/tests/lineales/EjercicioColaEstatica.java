/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.estaticas.Cola;
import lineales.estaticas.Cola;

/**
 *
 * @author franco
 */
public class EjercicioColaEstatica {
    public static void main(String[] args) {
       Cola cola1 = new Cola();
       
        for (int i = 0; i < 15; i++) {
            if(cola1.poner(i)){
                System.out.println("Elemento apilado");
            }else{
                System.out.println("Pila llena");
            }
        }
        System.out.println("el frente actual: "+cola1.obtenerFrente());
        System.out.println(cola1.toString());
        
        for (int i = 0; i < 5; i++) {
            if(cola1.sacar()){
                System.out.println("Sacando elemento");
            }else{
                System.out.println("Pila vacia");
            }
        }
        
        System.out.println("el frente actual: "+cola1.obtenerFrente());
        System.out.println(cola1.toString());
        
        for (int i = 0; i < 7; i++) {
            if(cola1.poner(i)){
                System.out.println("Elemento apilado");
            }else{
                System.out.println("cola llena");
            }
        }
        
        System.out.println("el frente actual: "+cola1.obtenerFrente());
        System.out.println(cola1.toString());
        
        Cola cola2 = cola1.clone();
        
        System.out.println("el frente actual: "+cola1.obtenerFrente());
        System.out.println(cola2.toString());
        
        cola2.sacar();
        System.out.println("el frente actual:"+cola2.obtenerFrente());
        System.out.println(cola2.toString());
    }
}
