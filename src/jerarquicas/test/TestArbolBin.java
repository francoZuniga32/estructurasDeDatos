/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.test;
import jerarquicas.dinamico.ArbolBin;
import lineales.dinamicas.*;
/**
 *
 * @author franco
 */
public class TestArbolBin {
    static String sOk = "OK!", sErr = "ERROR";
    
    /***
     * el test de arbol binario, probamos los metodos del emismo
     * @param args 
     */
    public static void main(String[] args) {
        ArbolBin A1 = new ArbolBin();
    
        /***
         * A : HI: B HD: C
         * B : HI: D HD: -
         * D : HI: - HD: -
         * C : HI: E HD: F
         * E : HI: G HD: H
         * G: HI:- HD:-
         * H: HI:- HD:-
         * F: HI:- HD:-
         */

        System.out.println("vamos a iniciar el test:");
        
        //test de insercion
        //raiz nivel 1
        System.out.println("Instanciamos el arbol, se llama A1");
        System.out.println("Insertamos: A como raiz: \t\t\t\t\t"+(A1.insertar('A', 'A', 'D') ? sOk : sErr));
        //nivel 2
        System.out.println("Insertamos B como HI de A: espera OK!\t\t\t\t"+(A1.insertar('B', 'A', 'I') ? sOk: sErr));
        System.out.println("Insertamos C como HD de A: espera OK!\t\t\t\t"+(A1.insertar('C', 'A', 'D') ? sOk: sErr));
        //nivel 3
        System.out.println("Insertamos D como HI de B: espera OK!\t\t\t\t"+(A1.insertar('D', 'B', 'I') ? sOk: sErr));
        System.out.println("Insertamos E como HI de C: espera OK!\t\t\t\t"+(A1.insertar('E', 'C', 'I') ? sOk: sErr));
        System.out.println("Insertemos F como HD de C: espera OK!\t\t\t\t"+(A1.insertar('F', 'C', 'D') ? sOk: sErr));
        //nivel 4
        System.out.println("Insertamos G como HI de E: espera OK!\t\t\t\t"+(A1.insertar('G', 'E', 'I') ? sOk: sErr));
        System.out.println("Insertamos H como HD de E: espera OK!\t\t\t\t"+(A1.insertar('H', 'E', 'D') ? sOk: sErr));
        
        
        //test de insercion mal
        System.out.println("Insertamos G como HI de E ya ocupado: espera ERROR\t\t"+(A1.insertar('G', 'E', 'I') ? sOk: sErr));
        System.out.println("Insertamos Z como HD de W, pero W no existe: espera ERROR\t"+(A1.insertar('Z', 'W', 'D') ? sOk: sErr));
        
        //metodos toString
        System.out.println("---------------------------------------------------");
        System.out.println("Probemos el toString del arbol:");
        System.out.println(A1.toString());
        System.out.println("---------------------------------------------------");
        System.out.println("Probemos el metodo clone, el arbol se llama A2");
        ArbolBin A2 = A1.clone();
        System.out.println("A2 toString:");
        A2 = A1.clone();
        System.out.println(A2.toString());
        System.out.println("Creamos un Arbol vacio A3, y otro con un solo elemento A4");
        ArbolBin A3 = new ArbolBin();
        ArbolBin A4 = new ArbolBin();
        A4.insertar(1, 1, 'I');
        System.out.println("A3 toString:");
        System.out.println(A3.toString());
        System.out.println("A4 toString:");
        System.out.println(A4.toString());
        
        //modificacion para altura
        System.out.println("---------------------------------------------------");
        System.out.println("Modificamos el arbol clonado para poder probar el metodo altura");
        System.out.println("Insertamos I como HI de H: espera OK!\t\t\t\t"+(A2.insertar('I', 'H', 'I') ? sOk: sErr));
        System.out.println("Insertamos J como HD de H: espera OK!\t\t\t\t"+(A2.insertar('J', 'H', 'D') ? sOk: sErr));
        System.out.println("mostramos el arbol A2:");
        System.out.println(A2.toString());
        
        //test altura
        System.out.println("La altura de A1:"+A1.altura());
        System.out.println("La altura de A2:"+A2.altura());
        System.out.println("La altura de A3:"+A3.altura());
        System.out.println("La altura de A4:"+A4.altura());
        
        //test padre
        System.out.println("---------------------------------------------------");
        System.out.println("Probamos el metodo padre: usamos el arbol A1");
        System.out.println("El padre de A es:"+A1.padre('A'));
        System.out.println("El padre de B es:"+A1.padre('B'));
        System.out.println("El padre de C es:"+A1.padre('C'));
        System.out.println("El padre de D es:"+A1.padre('D'));
        System.out.println("El padre de E es:"+A1.padre('E'));
        System.out.println("El padre de F es:"+A1.padre('F'));
        System.out.println("El padre de G es:"+A1.padre('G'));
        System.out.println("El padre de H es:"+A1.padre('H'));
        System.out.println("---------------------------------------------------");
        System.out.println("Probamos el metodo nivel: usamos el arbol A2");
        System.out.println("El nivel de A es:"+A1.nivel('A'));
        System.out.println("El nivel de B es:"+A1.nivel('B'));
        System.out.println("El nivel de C es:"+A1.nivel('C'));
        System.out.println("El nivel de D es:"+A1.nivel('D'));
        System.out.println("El nivel de E es:"+A1.nivel('E'));
        System.out.println("El nivel de F es:"+A1.nivel('F'));
        System.out.println("El nivel de G es:"+A1.nivel('G'));
        System.out.println("El nivel de H es:"+A1.nivel('H'));
        System.out.println("Usando el arbol A3");
        System.out.println("El nivel de A es:"+A3.nivel('A'));
        
        //test listar
        System.out.println("recorremos en los ordenes dados por la teoria de arboles:");
        System.out.println("preorden:"+A1.listarPreorden().toString());
        System.out.println("inorden:"+A1.listarInorden().toString());
        System.out.println("posorden"+A1.listarPosorden().toString());
        System.out.println("por niveles"+A1.porNivel().toString());
       
        //test toString
        System.out.println("A1:");
        System.out.println(A1.toString());
        System.out.println("A3");
        System.out.println(A3.toString());
        
        //test patron
        Lista patron = new Lista();
        System.out.println("insetamos A en la lista: "+(patron.insertar('A', 1)? sOk: sErr));
        System.out.println("insetamos B en la lista: "+(patron.insertar('C', 2)? sOk: sErr));
        System.out.println("insetamos D en la lista: "+(patron.insertar('E', 3)? sOk: sErr));
        System.out.println("insetamos D en la lista: "+(patron.insertar('G', 4)? sOk: sErr));
        System.out.println(patron.toString());
        if(A1.vericarPatron(patron)){
            System.out.println("la lista: "+patron.toString()+" esta en A1");
        }else{
            System.out.println("la lista:"+patron.toString()+"no esta en A1");
        }
        Lista frontera = A1.frontera();
        System.out.println(frontera.toString());
        
        //test de ansestros
        System.out.println("Pronamos ansestros");
        System.out.println("Ansestros de A1 elemento H espera [A,C,E,H]: "+A1.ansestros('H'));
        System.out.println("Ansestros de A1 elemento Z espera Lista Vacia: "+A1.ansestros('Z'));
        System.out.println("Ansestros de A1 elemento D espera [A,B,D]: "+A1.ansestros('D'));
        System.out.println("Ansestros de A1 elemento A espera [A]: "+A1.ansestros('A'));
    }
}
