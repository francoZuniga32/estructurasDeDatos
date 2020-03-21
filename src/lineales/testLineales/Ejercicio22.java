
package lineales.testLineales;

import lineales.dinamicas.Pila;

public class Ejercicio22 {
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        
        for (int i = 0; i < 15; i++) {
            pila1.apilar(i);
        }
        
        System.out.println(pila1.toString());
        
        Pila pila2 = pila1.clone();
        
        System.out.println("pila1: "+pila1.toString()+" pila2: "+pila2.toString());
        pila1.desapilar();
        Pila pila3 = pila2.clone();
        pila3.vaciar();
        System.out.println("pila1 desapilada 1 vez: "+pila1.toString());
        System.out.println("pila3 vacia: "+pila3.toString());
    }
}
