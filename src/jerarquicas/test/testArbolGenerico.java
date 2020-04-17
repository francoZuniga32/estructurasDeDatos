
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
        
        A1.listarPreorden();
        
        if(A1.pertenece('G')){
            System.out.println("A pertenece al A1");
        }else{
            System.out.println("A no pertenece a A1");
        }
        
        Lista L1 = A1.ansestros('J');
        System.out.println(L1.toString());
    }
}
