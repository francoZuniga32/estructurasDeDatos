package lineales;

//@author franco
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
        return this.tope.getElemento();
    }
    
    /**
     * verificamos si la pila esta vacia
     * @return boolean
     */
    public boolean esVacia(){
        boolean retorno = false;
        if(this.tope == null){
            retorno = true;
        }
        return retorno;
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
    public String toString(){
        String retorno = "Pila vacia";
        
        if(this.tope != null){
            retorno = "";
            //se ubica en el tope para recorrer la pila
            Nodo aux = this.tope;
            retorno = "[";
            
            //recorremos los enlaces
            while(aux != null){
                //concatenamos el elmento
                retorno = retorno + aux.getElemento().toString();
                aux = aux.getEnlace();
                if(aux != null){
                    retorno = retorno + ",";
                }
            }
            retorno = retorno + "]";
        }
        return retorno;
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
