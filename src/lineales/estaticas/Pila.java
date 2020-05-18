/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020 Estrcutura de datos
 * TDA Pila modelo estatico: estructura de datos tipo LIFO
 * (Last In First Out), donde el ultimo elemento es el primero
 * en salir.
 * se decribe el funcionamiento del mismo a continucacion
 */
package lineales.estaticas;

public class Pila {
    private final static int TAMANIO = 10;
    private Object[] array;
    private int tope;
    
    /**
     * Constructor de la clase pila
     */
    public Pila() {
        //generamos el tamaño de la pila
        this.array = new Object[this.TAMANIO];
        this.tope = -1;
    }
    
    /**
     * apilamos un elemento en el tope de la pila
     * @param elemento
     * @return 
     */
    public boolean apilar(Object elemento){
        boolean retorno = false;
        
        if(this.tope + 1 < this.TAMANIO){
            this.tope ++;
            this.array[this.tope] = elemento;
            retorno = true;
        }
        return retorno;
    }
    
    /**
     * sacamos el elemento que esta en el tope
     * esta metodo no rertorna el elemento solo lo saca
     * @return true si se pudo desapilar y si no retorna falso pila vacia
     */
    public boolean desapilar(){
        boolean retorno = false;
        
        if(this.tope >= 0){
            this.array[this.tope] = null;
            this.tope --;
            retorno = true;
        }
        
        return retorno;
    }
    
    /**
     * obtenemos el elemento que esta en el tope de la pila
     * @return el elemento del tope, null en caso de estar vacia
     */
    public Object obtenerTope(){
        Object retorno = null;
        if(this.tope >= 0){
            retorno = this.array[this.tope];
        }
        return retorno;
    }
    
    /**
     * verifica si la pila esta vacia
     * @return true en caso de estarlo y false en caso de que no
     */
    public boolean esVacia(){
        boolean retorno = false;
        if(this.tope < 0){
            retorno = true;
        }
        return retorno;
    }
    
    /**
     * vaciamos la pila completa
     */
    public void vaciar(){
        int i = 0;
        while(i <= this.tope){
            this.array[i] = null;
            i++;
        }
        this.tope = -1;
    }
    
    /**
     * clonamos la pila actual y la retornamos
     * @return la pila creada
     */
    public Pila clone(){
        Pila clon = new Pila();
        int i = 0;
        
        while(i <= this.tope){
            clon.array[i] = this.array[i];
            i++;
        }
        clon.tope = this.tope;
        return clon;
    }
    
    /**
     * devolvemos una cadena con la pila en forma de arreglo donde el final de la cadena es el tope de la pila
     * @return cadena con la pila en orden de apilado (como se la apilo)
     */
    public String toString(){
        String cadena = "";
        int i = 0;
        
        if(!esVacia()){
            cadena = "[";
            while(i <= this.tope){
               cadena = cadena + this.array[i].toString();
               if(i < this.tope){
                   cadena = cadena + ",";
               }
               i++;
            }
            cadena = cadena + "]";   
        }else{
            cadena = "Pila Vacia!";
        }
        return cadena;
    }
}
