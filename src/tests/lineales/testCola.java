
package tests.lineales;

import lineales.dinamicas.Cola;

/**
 * @author franco
 */
public class testCola {
    static String sOk = "OK!", sErr = "ERROR";
    
    public static void main(String[] args) {
        //cremaos una cola y le apilamos 10 valores:
        
        Cola cola1 = new Cola();
        //apilamos 10 elementos:
        for(int i = 0; i < 9; i++){
            System.out.println("Se pone :"+i+"\t\t\t\t\t\t"+((cola1.poner(i)) ? sOk : sErr));
        }
        System.out.println("Pone 9 espera ok!(dinamico), ERROR(estatico)"+"\t\t"+((cola1.poner(9)) ? sOk : sErr));
        
        System.out.print("espera \t1,2,3,4,5,6,7,8,9");
        System.out.println("\t\t\t\t--> " + cola1.toString());
        
        System.out.println("Probamos el metodo clone de la cola:");
        
        System.out.println("Probamos la funcion sacar: sacamos 5 elementos del frente:");
        for (int j = 0; j < 5; j++) {
            int tomado = (int) cola1.obtenerFrente();
            System.out.println("Se saca :"+tomado+"\t\t"+((cola1.sacar()) ? sOk : sErr)+"\t\t\t\t--> " + cola1.toString());
        }
    }
}
