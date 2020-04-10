/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.test;
import jerarquicas.dinamico.ArbolBin;
/**
 *
 * @author franco
 */
public class TestArbolBin {
    public static void main(String[] args) {
        ArbolBin A1 = new ArbolBin();
        ArbolBin A2 = new ArbolBin();
    
        /***
         * 1
         * 21
         * 4567
         */

        //raiz nivel 1
        A1.insertar('A', 'A', 'D');
        //nivel 2
        A1.insertar('B', 'A', 'I');
        A1.insertar('C', 'A', 'D');
        //nivel 3
        A1.insertar('D', 'B', 'I');
        A1.insertar('E', 'C', 'I');
        A1.insertar('F', 'C', 'D');
        //nivel 4
        A1.insertar('G', 'E', 'I');
        A1.insertar('H', 'E', 'D');
        
        System.out.println("recorremos en los ordenes dados por la teoria de arboles:");
        System.out.println("preorden:");
        A1.preorden();
        System.out.println("inorden:");
        A1.inorden();
        System.out.println("posorden");
        A1.posorden();
        System.out.println("por niveles");
        A1.porNivel();
        
        ArbolBin A3 = A1.clone();
        
        System.out.println("A1:");
        System.out.println(A1.toString());
        System.out.println("A3");
        System.out.println(A3.toString());
        
    }
}
