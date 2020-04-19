
package jerarquicas.test;
import jerarquicas.dinamico.*;
import lineales.dinamicas.*;
/**
 *
 * @author franco
 */
public class testArbolGenerico {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        ArbolGen A1 = new ArbolGen();
        
        System.out.println("insertamos A como raiz:"+(A1.insertar('A', 'A') ? sOk: sErr));
        System.out.println("insertamos B como hijo de A:"+(A1.insertar('B', 'A') ? sOk: sErr));
        System.out.println("insertamos C como hijo de A:"+(A1.insertar('C', 'A') ? sOk: sErr));
        System.out.println("insertamos D como hijo de A:"+(A1.insertar('D', 'A') ? sOk: sErr));
        System.out.println("insertamos E como hijo de B:"+(A1.insertar('E', 'B') ? sOk: sErr));
        System.out.println("insertamos F como hijo de B:"+(A1.insertar('F', 'B') ? sOk: sErr));
        System.out.println("insertamos H como hijo de C:"+(A1.insertar('H', 'C') ? sOk: sErr));
        System.out.println("insertamos I como hijo de C:"+(A1.insertar('I', 'C') ? sOk: sErr));
        System.out.println("insertamos J como hijo de C:"+(A1.insertar('J', 'C') ? sOk: sErr));
        System.out.println("insertamos K como hijo de F:"+(A1.insertar('K', 'F') ? sOk: sErr));
        
        System.out.print("Lista preorden: ");A1.listarPreorden();
        System.out.print("Lista inorden: ");A1.listarInorden();
        System.out.print("Lista posorden: ");A1.listarPosorden();
        System.out.print("Lista niveles");A1.listarNiveles();
        
        System.out.println("\n");
        System.out.println("A1 toString:");
        System.out.println(A1.toString());
    
        ArbolGen A2 = A1.clone();
        System.out.println("A2 toString:");
        System.out.println(A2.toString());
    }
}
