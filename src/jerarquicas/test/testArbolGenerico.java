
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
        
        //metodo de insercion de arbol generico
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
        
        System.out.print("Lista preorden: ");
        System.out.println(A1.listarPreorden().toString());
        System.out.print("Lista inorden: ");
        System.out.println(A1.listarInorden().toString());
        System.out.print("Lista posorden: ");
        System.out.println(A1.listarPosorden().toString());
        System.out.print("Lista niveles");
        System.out.println(A1.listarNiveles().toString());
        
        System.out.println("\n");
        System.out.println("A1 toString:");
        System.out.println(A1.toString());
    
        ArbolGen A2 = A1.clone();
        System.out.println("A2 toString:");
        System.out.println(A2.toString());
        
        A1.vaciar();
        
        System.out.println("Emos vaciado el arbol A1 pero lo hemos clonado en el arbol A2");
        System.out.println("Altura A1: "+A1.altura());
        System.out.println("Altura A2: "+A2.altura());
        System.out.println("Cremos el arbol A3 con un elemento");
        ArbolGen A3 = new ArbolGen();
        System.out.println("insertamos K como hijo de F:"+(A3.insertar('A', 'A') ? sOk: sErr));
        System.out.println("Altura A3: "+A3.altura());
        System.out.println("Creamos un arbol vacio: ");
    }
}
