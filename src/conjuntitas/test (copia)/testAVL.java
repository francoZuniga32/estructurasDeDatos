
package conjuntitas.test;
import conjuntitas.dinamico.*;
/**
 *
 * @author franco
 */
public class testAVL {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        //uno de los arboles va a ordenar letras(1) y el otro numeros(2)
        AVL A1 = new AVL();
        AVL A2 = new AVL();
        //probamos los metodos de insercion
        System.out.println("metodos de insercion:");
        System.out.println("Arbol A1 letras:");
        System.out.println("Insertamos G espera OK!:\t\t\t"+(A1.insertar('G')? sOk: sErr));
        System.out.println("Insertamos F espera OK!:\t\t\t"+(A1.insertar('F')? sOk: sErr));
        System.out.println("Insertamos D espera OK!:\t\t\t"+(A1.insertar('D')? sOk: sErr));
        System.out.println("Insertamos C espera OK!:\t\t\t"+(A1.insertar('C')? sOk: sErr));
        System.out.println("Insertamos B espera OK!:\t\t\t"+(A1.insertar('B')? sOk: sErr));
        System.out.println("Insertamos A espera OK!:\t\t\t"+(A1.insertar('A')? sOk: sErr));
        System.out.println("Insertamos H espera OK!:\t\t\t"+(A1.insertar('H')? sOk: sErr));
        System.out.println("Insertamos I espera OK!:\t\t\t"+(A1.insertar('I')? sOk: sErr));
        System.out.println("Insertamos J espera OK!:\t\t\t"+(A1.insertar('J')? sOk: sErr));
        System.out.println("Insertamos K espera OK!:\t\t\t"+(A1.insertar('K')? sOk: sErr));
        System.out.println("Insertamos F espera ERROR:\t\t\t"+(A1.insertar('F')? sOk: sErr));
        System.out.println("Insertamos B espera ERROR!:\t\t\t"+(A1.insertar('B')? sOk: sErr));
        System.out.println("Insertamos J espera ERROR!:\t\t\t"+(A1.insertar('J')? sOk: sErr));
        System.out.println("-------------------------------");
        System.out.println(A1.toString());
    }
}
