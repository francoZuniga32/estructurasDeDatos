

package tests.lineales;
import lineales.dinamicas.Lista;

public class pruevas {
    public static void main(String[] args) {
        Lista L1 = new Lista();
        
        for (int i = 0; i < 10; i++) {
            L1.insertar(i, i);
        }
        System.out.println(L1.toString());
        Lista L2 = L1.invertir();
        System.out.println(L2.toString());
        System.out.println(L1.toString());
        if( L1.eliminarApariciones(3)){
            System.out.println("Se elimino");
        }else{
            System.out.println("No se elimino");
        }
        System.out.println(L1.toString());
    }
}
