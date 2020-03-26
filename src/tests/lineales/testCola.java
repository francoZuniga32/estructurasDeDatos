
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
        System.out.println("Sacamos el ");
        
        System.out.print("espera \t0,1,2,3,4,5,6,7,8,9 (dinamico)\n \t0,1,2,3,4,5,6,7,8(estatico)");
        System.out.println("\t\t\t--> " + cola1.toString());
        
        System.out.println("Probamos la funcion sacar: sacamos 5 elementos del frente:");
        for (int j = 0; j < 4; j++) {
            int tomado = (int) cola1.obtenerFrente();
            System.out.println("Se saca :"+tomado+"\t\t"+((cola1.sacar()) ? sOk : sErr)+"\t\t\t\t--> " + cola1.toString());
        }
        
        System.out.println("Probamos el metodo clon:");
        Cola cola2 = cola1.clone();
        System.out.println("Cola1: espera \t5,6,7,8,9(dinamico)\n \t4,5,6,7,8(estatico) \t\t\t\t-->"+cola1.toString());
        System.out.println("Cola2: espera \t5,6,7,8,9(dinamico)\n \t4,5,6,7,8(estatico) \t\t\t\t-->"+cola2.toString());
        
        System.out.println("Probamos los metodos poner para ver la funcionalidad de la cola:");
        for (int k = 0; k < 4; k++) {
            System.out.println("Se pone :"+k+"\t\t\t\t\t\t"+((cola1.poner(k)) ? sOk : sErr));
        }
        System.out.println("Pone 9 espera ok!(dinamico), ERROR(estatico)"+"\t\t"+((cola1.poner(4)) ? sOk : sErr));
        
        System.out.println("Vemos que la cola2 nos se modifica:");
        System.out.println("Cola1: espera \t5,6,7,8,9,0,1,2,3,4(dinamico) \n \t\t5,6,7,8,0,1,2,3(estatico) \t\t-->"+cola1.toString());
        System.out.println("Cola2: espera \t5,6,7,8,9(dinamico)\n \t\t4,5,6,7,8(estatico) \t\t\t-->"+cola2.toString());
        System.out.println("vaciamos la cola2:");
        cola2.vaciar();
        System.out.println("Cola1: espera \t5,6,7,8,9,0,1,2,3,4(dinamico) \n \t\t5,6,7,8,0,1,2,3(estatico) \t\t-->"+cola1.toString());
        System.out.println("Cola2: Cola Vacia! o [] \t\t\t\t-->"+cola2.toString());
        System.out.println("Probamos metodo esVacia:");
        System.out.println("Cola1: espera ERROR! \t\t\t\t\t-->"+((cola1.esVacia()) ? sOk : sErr));
        System.out.println("Cola2: espera Ok! \t\t\t\t\t-->"+((cola2.esVacia()) ? sOk : sErr));
    }
}
