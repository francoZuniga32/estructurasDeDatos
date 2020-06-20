/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020 Estrcutura de datos
 * TDA Pila modelo diamico: estructura de datos tipo LIFO
 * (Last In First Out), donde el ultimo elemento es el primero
 * en salir.
 * se decribe el funcionamiento del mismo a continucacion
 */
package lineales.dinamicas;

public class Pila {
    private Nodo tope;
    
    /**
     * contructor de pila dinamica:
     * construimos una pila nueva
     */
    public Pila(){
        this.tope = null;
    }
    
    /**
     * apilamos un elemento en la pila
     * @param elemento
     * @return booleano
     */
    public boolean apilar(Object elemento){
        //creamos un nodo y le enlasamos con el tope
        Nodo nuevo = new Nodo(elemento, this.tope);
        //ahora el tope es el nuevo nodo
        this.tope = nuevo;
        //retornamos true
        return true;
    }
    
    /**
     * sacamos el elemento tope de la pila 
     * @return booleano
     */
    public boolean desapilar(){
        boolean retorno = false;
        if(!this.esVacia()){
            Nodo nuevo = this.tope.getEnlace();
            this.tope = nuevo;
            retorno = true;            
        }
        return retorno;
    }
    
    /**
     * obtenemos el elemento tope de la pila
     * @return Object
     */
    public Object obtenerTope(){
        Object retorno;
        if(!esVacia()){
            retorno = this.tope.getElemento();   
        }else{
            retorno = null;
        }
        return retorno;
    }
    
    /**
     * verificamos si la pila esta vacia
     * @return boolean
     */
    public boolean esVacia(){
        return this.tope == null;
    }    
    
    /**
     * vaciamos la pila
     */
    public void vaciar(){
        this.tope = null;
    }
    
    /**
     * retornamos una cadena con la pila en el orden en que fue apilado
     * @return String
     */
    public String toString() {
        String retorno = "Pila vacia";
        
        if(this.tope != null){
            retorno = "["+ toStringPaso(this.tope) +"]";
        }else{
            retorno = "Pila Vacia!";
        }
        return retorno;
    }
    
    private String toStringPaso(Nodo actual){
        String elemento = "";
        if(actual.getEnlace() != null){
            //obtenemos el valor del nodo
            //concatenamos el llamado con el elemento del siguiente
            elemento = this.toStringPaso(actual.getEnlace()) +","+ actual.getElemento().toString();   
        }else{
            elemento = actual.getElemento().toString();
        }
        return elemento;
    }
    
    /**
     * retornamos un clon de la pila actual
     * @return Pila
     */
    
    public Pila clone(){
        Pila clon = new Pila();
        this.cloneRecursivoPaso(clon, this.tope);
        return clon;
    }
    
    /**
     * es el paso recursivo para armar la pila clon
     * @param pilaClon
     * @param enlace 
     */
    private void cloneRecursivoPaso(Pila pilaClon, Nodo enlace){
        
        if(enlace != null){
            //nos movemos al siguiente enlace
            Nodo enlaceTope = enlace.getEnlace();
            //llamamos a la funcion recursivamente
            cloneRecursivoPaso(pilaClon, enlaceTope);
            //apilamos los elementos del nodo cuando salimos
            pilaClon.tope = new Nodo(enlace.getElemento(), pilaClon.tope);
        }
    }
}
