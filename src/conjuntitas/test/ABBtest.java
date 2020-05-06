
package conjuntitas.test;
import conjuntitas.dinamico.ABB;
/**
 *
 * @author franco
 */
public class ABBtest {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        ABB A1 = new ABB();

        //vamos a insetar algunos elementos en el arbol
        System.out.println("insertamos F en arbol: "+(A1.insertar('F') ? sOk: sErr));
        System.out.println("insertamos A en arbol: "+(A1.insertar('A') ? sOk: sErr));
        System.out.println("insertamos B en arbol: "+(A1.insertar('B') ? sOk: sErr));
        System.out.println("insertamos C en arbol: "+(A1.insertar('C') ? sOk: sErr));
        System.out.println("insertamos G en arbol: "+(A1.insertar('G') ? sOk: sErr));
        System.out.println("insertamos H en arbol: "+(A1.insertar('H') ? sOk: sErr));
        System.out.println("insertamos F en arbol: "+(A1.insertar('F') ? sOk: sErr));
        System.out.println("El arbol es: "+A1.lista().toString());
        System.out.println("Eliminamos C del arbol: "+(A1.eliminar('C')? sOk: sErr));
        System.out.println("El arbol es: "+A1.lista().toString());
    }
}
