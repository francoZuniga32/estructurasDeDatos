import conjuntitas.dinamico.ABB;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franco
 */
public class algoritmos {
    static String sOk = "OK!", sErr = "ERROR";
    public static void main(String[] args) {
        //uno de los arboles va a ordenar letras(1) y el otro numeros(2)
        ABB A1 = new ABB();
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
        System.out.println("Listamos A1:\t "+A1.lista().toString());
        ABB A2 = A1.clone();
        ABB A3 = A1.clonarRango('H', 'K');
        System.out.println("Listamos A3:\t"+A3.lista().toString());
        System.out.println("A3 toString: \n"+A3.toString());
        System.out.println("Eliminamos los mayores a J espera OK!:");
        A2.eliminarMenores('C');
        System.out.println("Listamos A2 :"+A2.lista());
        System.out.println("A1: ");
        System.out.println(A2.toString());
        /*
        System.out.println("Eliminamos entre un rango entre C y H:\t"+(A1.eliminarRango('C', 'H')? sOk: sErr));
        System.out.println("Listamos A1: \t"+A1.toString());
        */
    }
}
