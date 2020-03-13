/*
 * Implementacion de la estructura statica de pila
 * asiendo uso de arreglos en este ejemplo definiendoles el tamaño del mismo
 */
package lineales;

//@author franco
public class lineales{
    /**
     * @param args the command line arguments
     */
    public static boolean capicua(PilaEstatica pila,  int n){
        //verificamos si una pila pocee numeros capicua
        PilaEstatica clon;
        PilaEstatica aux1 = new PilaEstatica(n);
        boolean retorno = false;
        
        //clonamos la pila
        clon = pila.clonar();
        
        //desapilamos el clon y apilamos el auxiliar
        do{
            aux1.apilar(clon.obtenerTope());
            clon.desapilar();
        }while(clon.esVacio());
        
        if(aux1.toString().compareTo(pila.toString()) == 0){
            retorno = true;
        }
        return retorno;
    }
    
    public static void main(String[] args) {
        //creacion de una pila estatica
        PilaEstatica cosa1 = new PilaEstatica(6);
        
        for (int i = 0; i < 6; i++) {
            if(cosa1.apilar(i)){
                System.out.println("se apilo:"+i);
            }
        }
        //metodo to string
        System.out.println(cosa1.toString());
        
        //metodo de clonacion
        PilaEstatica cosa2 = cosa1.clonarRecursivo();
        
        //mostramos las dos pilas
        System.out.println("la cosa1 es:"+cosa1.toString()+"la cosa2 es"+cosa2.toString());
        
    }
    
}
