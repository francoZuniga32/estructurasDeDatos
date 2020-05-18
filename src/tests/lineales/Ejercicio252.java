package tests.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Nodo;
/**
 * @author franco
 */
public class Ejercicio252 {
    /**
     * este es el test lista donde probamos las funcionalidades de la clase lista
     * 
     * @param args 
     */
    static String sOk = "OK!", sErr = "ERROR";
    
    public static Lista concatenar(Lista l1, Lista l2){
        Lista retorno = new Lista();
        int i = 0;
        
        while(i <= l1.longitud()+l2.longitud()){
            if(i <= l1.longitud()){
                retorno.insertar(l1.recuperar(i), i);
            }else{
                retorno.insertar(l2.recuperar(i-l1.longitud()), i-l1.longitud());
            }
            i++;
        }
        
        return retorno;
    }
    
    public static void main(String[] args) {
       //cremos nuetra lista
       Lista L1 = new Lista();
       
       //cargamos la lista con 10 elementos
        System.out.println("Insertamos 10 elementos en la lista:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Se inserta :"+i+"\t\t\t\t\t\t"+((L1.insertar(i, i))? sOk : sErr));
        }
        System.out.println("Resultado esperado [0,1,2,3,4,5,6,7,8,9]:\t\t"+L1.toString());
        System.out.println("---------------------------------");
        System.out.println("Clonamos la lista creada:");
        Lista L2 = L1.clone();
        System.out.println("Mostramos el contenido de L2 clonada:\t\t\t"+L2.toString());
        System.out.println("---------------------------------");
        System.out.println("Eliminamos 5 elementos de la lista comenzando por el final, usamos el metodo longitud de la lista:");
        for (int j = L1.longitud(); j > 5; j--) {
            System.out.println("Se elimina :"+j+"\t\t\t\t\t\t"+((L1.eliminar(j))? sOk : sErr));
        }
        System.out.println("Resultado esperado [0,1,2,3,4]:\t\t\t"+L1.toString());
        System.out.println("---------------------------------");
        System.out.println("Eliminanos algo en una pocicion no valida Ej en la 55:");
        System.out.println("Eliminando...\t\t\t\t\t\t"+((L1.eliminar(55))? sOk : sErr));
        System.out.println("Resultado esperado [0,1,2,3,4] y ERROR:\t\t\t\t"+L1.toString());
        System.out.println("---------------------------------");
        System.out.println("Eliminanos algo en una pocicion cualquiera Ej en la 3:");
        System.out.println("Eliminando...\t\t\t\t\t\t"+((L1.eliminar(3))? sOk : sErr));
        System.out.println("Resultado esperado [0,1,3,4]:\t\t\t\t"+L1.toString());
        System.out.println("---------------------------------");
        System.out.println("Vamos a isertar sobre la 1 pocicion desplazando la lista:");
        for(int k = 0; k < 5; k++){
            System.out.println("Se inserta :"+k+"\t\t\t\t\t\t"+((L1.insertar(k, 0))? sOk : sErr));
        }
        System.out.println("Resultado esperado [4,3,2,1,0,0,1,3,4]:\t\t\t"+L1.toString());
        System.out.println("---------------------------------");
        System.out.println("Vamos a mostrar el contenido de L2:\t\t\t"+L2.toString());
        System.out.println("Podemos ver que L2 no se modifico");
        System.out.println("---------------------------------");
        System.out.println("Concatenamos las dos listas antes de vaciarlas:");
        System.out.println(concatenar(L1, L2).toString());
        System.out.println("---------------------------------");
        System.out.println("Vaciamos L1:");
        L1.vaciar();
        System.out.println("Verificamos si la Lista L1 esta vacia (OK! vacia, ERROR no):"+((L1.esVacia())? sOk : sErr));
        System.out.println("Verificamos si la Lista L2 esta vacia (OK! vacia, ERROR no):"+((L2.esVacia())? sOk : sErr));
        System.out.println("---------------------------------");
    }
}
