package conjuntitas.test;
import conjuntitas.dinamicas.ArbolHeapMaximo;

/**
 *
 * @author franco
 */
public class heapTest {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        ArbolHeapMaximo a = new ArbolHeapMaximo();
        
        for (int i = 0; i < 15; i++) {
            System.out.println("inserta "+i+" en a:"+(a.insertar(i) ? sOk:sErr));
            System.out.println(a.toString());
        }
    }
}
