
package lineales.test;
import lineales.dinamicas.*;
/**
 * @author franco
 */
public class mixLineales {
    
    static String sOk = "OK!", sErr = "ERROR";
    
    /***
     * Concatena dos listas y retorna una lista con los elementos concatenados
     * @param L1
     * @param L2
     * @return Lista que es resultado de la concatenacion
     */
    public static Lista concatenar(Lista L1, Lista L2){
        //creamos una lista a retorna
        Lista retorno = new Lista();
        //obtenemos las longitudes de las listas a concatenar
        int longitud1 = L1.longitud();
        int longitud2 = longitud1 + L2.longitud();
        int i = 1;
        int j = 1;
        
        //vamos a ir copiando de las dos listas
        while(i <= longitud1){
            retorno.insertar(L1.recuperar(i), i);
            i++;
        }
        
        while(i <= longitud2){
            retorno.insertar(L2.recuperar(j), i);
            i++;
            j++;
        }
        
        return retorno;
    }
    
    /***
     * 
     * @param L1
     * @return 
     */
    public static boolean comprobar(Lista L1){
        boolean retorno = true;
        boolean control = true;
        int i = 1;
        int longitud = L1.longitud();
        
        //la cola de los primeros diguitos y la pila que es la cadena inversa
        Cola C1 = new Cola();
        Pila P1 = new Pila();
        //obtenemos los primeros n dijitos antes de un 0
        while(i <= longitud && control){
            if(!L1.recuperar(i).equals(0)){
                C1.poner(L1.recuperar(i));
                P1.apilar(L1.recuperar(i));
                i++;
            }else{
                control = false;
            }
        }
        
        System.out.println(C1.toString());
        System.out.println(P1.toString());
        System.out.println(i+" "+longitud);
        i++;
        //ahora vamos a seguir recorriendo para evaluar si se cumple la condicion
        while(i <= longitud && retorno){
            Cola compararCola = C1.clone();
            while(retorno && i <= longitud && !compararCola.esVacia() ){
                System.out.println(L1.recuperar(i).toString());
                System.out.println(compararCola.obtenerFrente().toString());
                //mientras i entre dentro de la lista y la cola no este vacia
                if(L1.recuperar(i).equals(compararCola.obtenerFrente())){
                    compararCola.sacar();
                    i++;
                }else{
                    retorno = false;
                }
            }
            i++;
            Pila compararPila = P1.clone();
            while(retorno && i <= longitud && !compararPila.esVacia()){
                System.out.println(L1.recuperar(i).toString());
                System.out.println(compararPila.obtenerTope().toString());
                //mientras i entre dentro de la lista y la pila no este vacia
                if(L1.recuperar(i).equals(compararPila.obtenerTope())){
                    compararPila.desapilar();
                    i++;
                }else{
                    retorno = false;
                }
            }
        }
        
        return retorno;
    }
    
    
    public static Lista invertir(Lista L1){
        Pila P1 = new Pila();
        Lista retorno = new Lista();
        int i = 1;
        
        while(i <= L1.longitud()){
            P1.apilar(L1.recuperar(i));
            i++;
        }
        i = 1;
        while(!P1.esVacia()){
            retorno.insertar(P1.obtenerTope(), i);
            P1.desapilar();
            i++;
        }
        return retorno;
    }
    
    public static void main(String[] args) {
        //comenzamos con los metodos solicitados en esta parte vamos a probarlos
        Lista L1 = new Lista();
        int aux;
        for (int i = 1; i < 6; i++) {
            L1.insertar(i, i);
            aux = i;
        }
        Lista L2 = new Lista();
        for (int j = 1; j < 5; j++) {
            L2.insertar(j+5, j);
        }
        System.out.println("La Lista L1: "+L1.toString());
        System.out.println("La Lista L2: "+L2.toString());
        System.out.println("Las Litas L1 y L2 concatenadas: "+concatenar(L1, L2).toString());
        System.out.println("Concatenemos dos listas vacias");
        Lista concatenada = concatenar(L1, L2);
        L1.vaciar();
        L2.vaciar();
        
        System.out.println("Las Litas L1 y L2 concatenadas: "+concatenar(L1, L2).toString());
        System.out.println("La Lista invertida de la lista concatenada: "+invertir(concatenada).toString());
        System.out.println("Cremoas unas cuantas Listas para el metodo comprobar");
        Lista L3 = new Lista();
        System.out.println("Insertamos 1 en L3: "+(L3.insertar(1, 1) ? sOk: sErr));
        System.out.println("Insertamos 2 en L3: "+(L3.insertar(2, 2) ? sOk: sErr));
        System.out.println("Insertamos 3 en L3: "+(L3.insertar(3, 3) ? sOk: sErr));
        System.out.println("Insertamos 0 en L3: "+(L3.insertar(0, 4) ? sOk: sErr));
        System.out.println("Insertamos 1 en L3: "+(L3.insertar(1, 5) ? sOk: sErr));
        System.out.println("Insertamos 2 en L3: "+(L3.insertar(2, 6) ? sOk: sErr));
        System.out.println("Insertamos 3 en L3: "+(L3.insertar(3, 7) ? sOk: sErr));
        /*System.out.println("Insertamos 0 en L3: "+(L3.insertar(0, 8) ? sOk: sErr));
        System.out.println("Insertamos 3 en L3: "+(L3.insertar(3, 9) ? sOk: sErr));
        System.out.println("Insertamos 2 en L3: "+(L3.insertar(2, 10) ? sOk: sErr));
        System.out.println("Insertamos 1 en L3: "+(L3.insertar(1, 11) ? sOk: sErr));*/
        
        System.out.println("L3 es: "+L3.toString());
        System.out.println("Comprobar L3 actual Espera OK:"+(comprobar(L3)? sOk: sErr));
        //comprobar(L3);
    }
}
