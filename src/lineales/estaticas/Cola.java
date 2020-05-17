/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Cola version estatica: estrcutura de datos tipo FIFO
 * (Fist In First Out) donde el primero en entrar es el primero
 * en salir denomindo frente de la cola
 */
package lineales.estaticas;

public class Cola {
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int fin;
    private int frente;
    
    /***
     * Constructor de el TDA Cola retorna una cola vacia
     */
    public Cola(){
        //creamos el arreglo
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }
    
    /***
     * insertamos un elemento en la cola
     * @param elemento tipo objeto
     * @return true si pudo insertar false en caso contrario
     */
    public boolean poner(Object elemento){
        boolean retorno = false;
        if(!this.estaLlena()){
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
            retorno = true;
        }
        return retorno;
    }
    
    /***
     * saca el elemento en el frente de la cola
     * @return true si puedo sacar dicho elemento 
     *         false caso contrario(cola vacia)
     */
    public boolean sacar(){
        boolean retorno = false;
        if( this.fin != this.frente ){
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
            retorno = true;
        }
        return retorno;
    }
    
    /***
     * Obtenemos el elemento en el frente de la cola
     * @return el elemento en el frente de la cola
     */
    public Object obtenerFrente(){
        Object retorno = null;
        if((this.fin != this.frente)){
            retorno = this.arreglo[this.frente];
        }
        return retorno;
    }
    
    /** metodo para vaciar la cola*/
    public void vaciar(){
        //sobrescribimos el arreglo
        this.arreglo = new Object[this.TAMANIO];
        //restauramos los flecharos
        this.frente = 0;
        this.fin = 0;
    }
    
    /***
     * retornamos un clon de la cola actual
     * @return Cola es un clon de los elementos de la cola
     */
    public Cola clone(){
        Cola clon = new Cola();
        int i = 0; 
        while(i < this.TAMANIO){           
            clon.arreglo[i] = this.arreglo[i];
            i++;
        }
        
        clon.frente = this.frente;
        clon.fin = this.fin;
        return clon;
    }
    
    /***
     * metodo toString devuelve una cadena de caracteres mostrando la cola
     * @return String con los elementos de la cola
     */
    public String toString(){
        String retorno = "[";
        
        //verificamos que no este vacia
        if(this.frente != this.fin){
            //en caso de que el inicio sea menor a el fin
            //[E1, E2,...,En-i,...,En]
            //[fr, E2,...,fn,...,En]
            if(this.frente < this.fin){
                int i = this.frente;
                while(i < this.fin){
                    if(i == this.frente){
                       retorno =  retorno + this.arreglo[i].toString();
                    }else{
                        retorno = retorno+ "," + this.arreglo[i].toString();
                    }
                    i++;
                }
            }else{
                //[E1, E2,...,En-i,...,En]
                //[fn, E2,...,fr,...,En]
                int k = this.frente;
                while(k < this.arreglo.length){
                    if(k == this.frente){
                        retorno = retorno + this.arreglo[k].toString();
                    }else{
                        retorno = retorno + "," + this.arreglo[k].toString();
                    }
                    
                    k++;
                }
                
                int j = 0;
                while(j < this.fin){
                    if(j == this.frente){
                        retorno = retorno + this.arreglo[j].toString();
                    }else{
                        retorno = retorno + "," + this.arreglo[j].toString();
                    }
                    j++;
                }
            }
        }
        
        retorno = retorno + "]";
        return retorno;
    }
    
    /***
     * metodo para vaciar la cola
     * @return true si la cola esta vacia
     *         false en caso de que no lo este
     */
    public boolean esVacia(){
        boolean retorno = false;
        if(this.fin == this.frente){
            retorno = true;
        }
        return retorno;
    }
    
    /***
     * metodo para evaluar si esta llena la cola 
     * metodo solo en el enfoque estatico
     * @return true si esta llena
     *         false si no lo esta
     */
    public boolean estaLlena(){
        boolean retorno = false;
        //en caso de que el frente y el fin+1 son el mismo valor 
        if(((this.fin + 1) % this.TAMANIO ) == this.frente){
            retorno = true;
        }
        return retorno;
    }
}
