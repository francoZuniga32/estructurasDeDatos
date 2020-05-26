import lineales.dinamicas.*;
package tests.lineales;

/**
 *
 * @author franco
 */
public class parcial {
    
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
        
        
        if(verificarBalanece("({}{}])")){
            System.out.println("Esta balanceada");
        }
    }
}
