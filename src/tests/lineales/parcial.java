import lineales.dinamicas.*;
import jerarquicas.dinamico.*;
package tests.lineales;
/**
 *
 * @author franco
 */
public class parcial {
    
    public static void main(String[] args) {
        Lista L1 = new Lista();
        L1.insertar('A', L1.longitud()+1);
        L1.insertar('B', L1.longitud()+1);
        L1.insertar('C', L1.longitud()+1);
        L1.insertar('D', L1.longitud()+1);
        L1.insertar('E', L1.longitud()+1);
        L1.insertar('B', L1.longitud()+1);
        L1.insertar('G', L1.longitud()+1);
        System.out.println(L1.toString());
        L1.eliminarApariciones('B');
        System.out.println(L1.toString());
        
        
        if(verificarBalanece("{[()()()][()]}")){
            System.out.println("Esta balanceada");
        }
        
        Cola Q1 = new Cola();
        Q1.poner(1);
        Q1.poner(2);
        Q1.poner(3);
        Q1.poner(4);
        Q1.poner(5);
        Q1.poner(6);
        Q1.poner(7);
        Q1.poner(8);
        Q1.poner(9);
        System.out.println(Q1.toString());
        System.out.println(generarSecuencia(Q1, 0).toString());
        System.out.println("Cola to Lista: "+colaToLista(Q1, 0));
        
        System.out.println("Probamos el punto de arboles ");
        ArbolBin A1 = new ArbolBin();
        A1.insertar('A', 'A', 'I');
        A1.insertar('B', 'A', 'I');
        A1.insertar('C', 'A', 'D');
        A1.insertar('D', 'B', 'I');
        System.out.println(A1.toString());
        System.out.println("El mismo arbol invertido");
        ArbolBin A2 = A1.cloneInvertido();
        System.out.println(A2.toString());
        System.out.println("Insertamos E como hijo derecho de D: "+A1.insertar('E', 'D', 'D'));
        System.out.println(A1.toString());
        System.out.println("El nivel de E es: "+A1.nivel('E'));
    }
    
    public static Lista colaToLista(Cola cola, int Frecuencia){
        Cola colaClon = cola.clone();
        Lista retorno = new Lista();
        Pila aux = new Pila();
        
        int longitud = 1;
        
        while(!colaClon.esVacia()){
            //apilamos en aux en frente de a cola, e insertamos en la 
            aux.apilar(colaClon.obtenerFrente());
            retorno.insertar(colaClon.obtenerFrente(), longitud);
            colaClon.sacar();
            
            //en caso de que estemos en una frecuencia realizamos la operacion
            if(longitud % Frecuencia == 0 || colaClon.esVacia()){
                
                while(!aux.esVacia()){
                    retorno.insertar(aux.obtenerTope(), longitud + 1);
                    retorno.insertar(aux.obtenerTope(), longitud + 2);
                    longitud++;
                    aux.desapilar();
                }
                longitud = retorno.longitud();
                retorno.insertar('$', longitud+1);
                System.out.println(retorno.toString());
            }
            
            longitud++;
        }
        return retorno;
    }
    
    
    public static Lista generarSecuencia(Cola c, int frecuencia){
        Cola cola = c.clone();
        Lista retorno = new Lista();
        
        int longitud = 1;
        int indice = 0;
        int indiceAux = 1;
        
        while(!cola.esVacia()){
            indice = indice + 2;
            retorno.insertar(cola.obtenerFrente(), indiceAux);
            retorno.insertar(cola.obtenerFrente(), indice);
            cola.sacar();
            
            if(longitud % frecuencia == 0 || cola.esVacia()){
                indice++;
                retorno.insertar('$', indice);
                indiceAux = indice + 1;
            }
            
            longitud++;
        }
        return retorno;
    }
    
    public static boolean verificarBalanece(String expresion){
        boolean retorno = true;
        Pila PilaExprecion = expresionAPila(expresion);
        Pila pilaAuxiliar = new Pila();
        
        do{
            char topeExprecion = (char) PilaExprecion.obtenerTope();
            PilaExprecion.desapilar();
            if(topeExprecion == '(' || topeExprecion == '[' || topeExprecion == '{'){
                //entonces apilamos en el pila auxlilar
                pilaAuxiliar.apilar(topeExprecion);
            }else{
                if(topeExprecion == ')' || topeExprecion == ']' || topeExprecion == '}'){
                    if(pilaAuxiliar.esVacia() || !evaluarBalanceCaracter((char)topeExprecion, (char)pilaAuxiliar.obtenerTope())){
                        retorno = false;
                    }else{
                        pilaAuxiliar.desapilar();
                    }
                }
            }
        }while(retorno && !PilaExprecion.esVacia());
        
        return retorno;
    }
    
    public static boolean evaluarBalanceCaracter(char a, char b){
        boolean retorno = false;
        switch(a){
            case ')':
                retorno = b == '(';
                break;
            case ']':
                retorno = b == '[';
                break;
            case '}':
                retorno = b == '{';
                break;
            default:
                retorno = false;
                break;
        }
        
        return retorno;
    }
    
    public static Pila expresionAPila(String exprecion){
        Pila retorno = new Pila();
        for (int i = exprecion.length() -1 ; i >= 0 ; i--) {
            retorno.apilar(exprecion.charAt(i));
        }
        return retorno;
    }
    
}
