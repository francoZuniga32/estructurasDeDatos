

package tests.lineales;
import lineales.dinamicas.Lista;

public class pruevas {
    
    static String sOk = "OK!", sErr = "ERROR";
    
    public static void main(String[] args) {
        Lista l1 = new Lista();
        
        System.out.println("Muestra lista vacia: \t\t\t\t\t--> " + l1.toString());
	        System.out.println("Longitud de lista vacia:\t\t\t" + l1.longitud());
	        System.out.print("Inserta 5 pos 5 espera FALSE: \t\t\t" + ((l1.insertar(5, 5)) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
                System.out.println("Longitud de lista vacia:\t\t\t" + l1.longitud());
                System.out.print("Inserta 2 pos 1 espera TRUE: \t\t\t" + ((l1.insertar(2, 1)) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
    }
}
