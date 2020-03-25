/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.estaticas.Pila ;

/**
 *
 * @author franco
 */

public class Ejercicio21 {
    public static void main(String[] args) {
       //probamos todos los metodos
       Pila pila1 = new Pila();
       //apilamos mas de lo que la pila puede
        for (int i = 0; i < 11; i++) {
            if(pila1.apilar(i)){
                System.out.println("se apilo el elemento: "+i);
            }else{
                System.out.println("statck overflow ");
            }
        }
        
        //clonamos la pila y probamos el toString
        Pila pila2 = pila1.clone();
        System.out.println("la pila1: "+pila1.toString()+" la pila2: "+pila2.toString());
        
        //desapilamos la pila 2
        for (int j = 0; j < 11; j++) {
            if(pila2.desapilar()){
                System.out.println("se desapilo el tope actual");
            }else{
                System.out.println("pila vacia");
            }
        }
        
        //mostramos la pila1 y la pila2
        System.out.println("la pila1: "+pila1.toString()+" la pila2: "+pila2.toString());
        
        //obtenemos el tope de la pila1
        System.out.println("El tope de la pila1 es:"+pila1.obtenerTope());
        //desapilamos una vez
        if(pila1.desapilar()){
            System.out.println("El tope de la pila1 desapilada una vez es:"+pila1.obtenerTope());
        }else{
            System.out.println("La pila esta vacia");
        }
        
        //creamos una pila3 la clonamos y la vaciamos
        Pila pila3 = pila1.clone();
        System.out.println("la pila1: "+pila1.toString()+" la pila3: "+pila3.toString());
        System.out.println("Vaciamos la pila3");
        pila3.vaciar();
        System.out.println("la pila1: "+pila1.toString()+" la pila3: "+pila3.toString());
        
        Pila capicua = new Pila();
        capicua.apilar("hola");
        capicua.apilar("ads");
        capicua.apilar("asdasd");
        
        if(Capicua(capicua)){
            System.out.println("la pila es capicua");
        }else{
            System.out.println("la pila no es capicua");
        }
    }
    
    public static boolean Capicua(Pila evaluar){
        boolean retorno = true; 
        Pila aux = new Pila();
        //clonamos la pila en un auxiliar con el que vamos a trabajar
        Pila desapiladoAuxiliar = evaluar.clone();
        Pila desapiladoEvalaucion = evaluar.clone();
        //desapilasmo y apilamos en aux1
        while(!desapiladoAuxiliar.esVacia()){
            /*
            de esta manera obtenemos una pila inversa a la entrada por parametro
            */
            
            //obtenemos el tope de la pila
            Object elemento = desapiladoAuxiliar.obtenerTope();
            //apilamos en aux1
            aux.apilar(elemento);
            //desapilamos el tope
            desapiladoAuxiliar.desapilar();
        }
        /*
        * desapilamos las dos y comparamos los elementos
        */
        
        while(!desapiladoEvalaucion.esVacia()&& retorno){
            //obtenemos el tope de las dos pilas
            if(desapiladoEvalaucion.obtenerTope().toString().compareTo(aux.obtenerTope().toString()) != 0){
                //si son distintas
                retorno = false;
            }
            
            desapiladoEvalaucion.desapilar();
            aux.desapilar();
        }
        
        return retorno;
    }
}
