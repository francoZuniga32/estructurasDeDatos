package conjuntitas.test;
import conjuntitas.estaticas.*;

/**
 *
 * @author franco
 */
public class heapTest {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        /**
         * probar el arbol heap con 5 elementos iniciales
         * inseratar en la cima
         * insertar en una hoja
         * insertar en un nodo intermedio
         */
        Heap a = new Heap();
        ArbolHeapMaximo b = new ArbolHeapMaximo();
        
        //vamosa insertar el arbol heap maximo
        for (int i = 15; i > 0; i--) {
            System.out.println("inserta "+i+" en a:"+(a.insertar(i) ? sOk:sErr));
            System.out.println("la cima es: "+a.obtenerCima());
        }
        System.out.println(a.toString());
        for (int i = 0; i < 5; i++) {
            System.out.println("eliminamos la cima"+(a.eliminar() ? sOk: sErr));
            System.out.println("la cima es: "+a.obtenerCima());
        }
        System.out.println(a.toString());
        
        Object e1 = 'a';
        Object e2 = 'b';
        Comparable ee1 = (Comparable) e1;
        Comparable ee2 = (Comparable) e2;
        if(ee1.compareTo(e2) > 0){
            System.out.println(ee1.toString()+" es mayor a "+ee2.toString());
        }else{
            System.out.println(ee2.toString()+" es mayor a "+ee1.toString());
        }
    }
}
