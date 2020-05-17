
package conjuntitas.test;
import conjuntitas.dinamico.ABB;
/**
 *
 * @author franco
 */
public class ABBtest {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        //uno de los arboles va a ordenar letras(1) y el otro numeros(2)
        ABB A1 = new ABB();
        ABB A2 = new ABB();
        //probamos los metodos de insercion
        System.out.println("metodos de insercion:");
        System.out.println("Arbol A1 letras:");
        System.out.println("Insertamos G espera OK!:\t\t\t"+(A1.insertar('G')? sOk: sErr));
        System.out.println("Insertamos C espera OK!:\t\t\t"+(A1.insertar('C')? sOk: sErr));
        System.out.println("Insertamos I espera OK!:\t\t\t"+(A1.insertar('I')? sOk: sErr));
        System.out.println("Insertamos A espera OK!:\t\t\t"+(A1.insertar('A')? sOk: sErr));
        System.out.println("Insertamos D espera OK!:\t\t\t"+(A1.insertar('D')? sOk: sErr));
        System.out.println("Insertamos H espera OK!:\t\t\t"+(A1.insertar('H')? sOk: sErr));
        System.out.println("Insertamos J espera OK!:\t\t\t"+(A1.insertar('J')? sOk: sErr));
        System.out.println("Insertamos B espera OK!:\t\t\t"+(A1.insertar('B')? sOk: sErr));
        System.out.println("Insertamos F espera OK!:\t\t\t"+(A1.insertar('F')? sOk: sErr));
        System.out.println("Insertamos K espera OK!:\t\t\t"+(A1.insertar('K')? sOk: sErr));
        System.out.println("Insertamos F espera ERROR:\t\t\t"+(A1.insertar('F')? sOk: sErr));
        System.out.println("Insertamos B espera ERROR!:\t\t\t"+(A1.insertar('B')? sOk: sErr));
        System.out.println("Insertamos J espera ERROR!:\t\t\t"+(A1.insertar('J')? sOk: sErr));
        System.out.println("Arbol A2 numeros");
        for (int i = 10; i < 15; i++) {
            System.out.println("Insertamos "+i+" espera OK!:\t\t\t"+(A2.insertar(i)? sOk: sErr));
            System.out.println("Insertamos "+i*2+" espera OK!:\t\t\t"+(A2.insertar(i*2)? sOk: sErr));
        }
        for (int j = 9; j > 5; j--) {
            System.out.println("Insertamos "+j+" espera OK!:\t\t\t"+(A2.insertar(j)? sOk: sErr));
            System.out.println("Insertamos "+j*2+" espera OK!:\t\t\t"+(A2.insertar(j*2+1)? sOk: sErr));
        }
        
        System.out.println("--------------------------------------");
        System.out.println("Metodo pertenece:");
        System.out.println("Pertenece F al Arbol espera OK!:\t\t"+(A1.pertenece('F')? sOk: sErr));
        System.out.println("Pertenece B al Arbol espera OK!:\t\t"+(A1.pertenece('B')? sOk: sErr));
        System.out.println("Pertenece J al Arbol espera OK!:\t\t"+(A1.pertenece('J')? sOk: sErr));
        System.out.println("Pertenece L al Arbol espera ERROR:\t\t"+(A1.pertenece('L')? sOk: sErr));
        System.out.println("Pertenece Z al Arbol espera ERROR:\t\t"+(A1.pertenece('Z')? sOk: sErr));
        System.out.println("Pertenece E al Arbol espera ERROR:\t\t"+(A1.pertenece('E')? sOk: sErr));
        
        System.out.println("--------------------------------------");
        System.out.println("Metodo listar:");
        System.out.println("A1 listado en orden:\t\t\t"+A1.lista().toString());
        System.out.println("A2 listado en orden:\t\t\t"+A2.lista().toString());
        System.out.println("Metodo listar rango");
        System.out.println("Listado entre B y F :\t\t\t"+A1.listarRango('B', 'F').toString());
        System.out.println("Listado entre F y J :\t\t\t"+A1.listarRango('F', 'J').toString());
        System.out.println("Listado entre G y J :\t\t\t"+A1.listarRango('G', 'J').toString());
        System.out.println("Listado entre A y C :\t\t\t"+A1.listarRango('A', 'C').toString());
        System.out.println("Listado entre F y B espera lista Vacia:\t\t"+A1.listarRango('F', 'B').toString());
        
        System.out.println("--------------------------------------");
        System.out.println("eliminamos");
        System.out.println("Eliminamos B espera OK!: \t\t"+(A1.eliminar('B')? sOk: sErr));
        System.out.println(A1.lista());
        System.out.println("Eliminamos C espera OK!: \t\t"+(A1.eliminar('C')? sOk: sErr));
        System.out.println(A1.lista());
        System.out.println("Eliminamos J espera OK!: \t\t"+(A1.eliminar('J')? sOk: sErr));
        System.out.println(A1.lista());
        System.out.println("Eliminamos G espera OK!: \t\t"+(A1.eliminar('G')? sOk: sErr));
        System.out.println(A1.lista());
    }
}
