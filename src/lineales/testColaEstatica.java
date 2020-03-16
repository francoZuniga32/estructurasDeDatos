/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales;

/**
 *
 * @author franco
 */
public class testColaEstatica {
    public static void main(String[] args) {
       ColaEstatica cola1 = new ColaEstatica();
        
        for (int i = 2; i < 15; i++) {
            if(!cola1.poner(i)){
                System.out.println("no se pudo apilar");
            }
            System.out.println("frente"+cola1.frente+"fin"+cola1.fin);
        } 
        
        System.out.println(cola1.toString());
        cola1.sacar();
        System.out.println(cola1.toString());
        cola1.poner(15);
        System.out.println(cola1.toString());
    }
}
