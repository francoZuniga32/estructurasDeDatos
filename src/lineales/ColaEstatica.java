
package lineales;

/**
 * @author franco
 */
public class ColaEstatica {
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    public int fin;
    public int frente;
    
    public ColaEstatica(){
        //creamos el arreglo
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }
    
    /** meter un elemento en la cola */
    public boolean poner(Object elemento){
        boolean retorno = false;
        if(!(((this.fin + 1) % this.TAMANIO) == this.frente)){
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
            retorno = true;
        }
        return retorno;
    }
    
    /** sacar un elemento de la cola */ 
    public boolean sacar(){
        boolean retorno = true;
        if(this.esVacia()){
            retorno = false;
        }else{
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return retorno;
    }
    
    /** obtener el frente de la cola */
    public Object obtenerFrente(){
        Object retorno = null;
        if(!esVacia()){
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
    
    /** clonamos la cola */
    public ColaEstatica clone(){
        ColaEstatica clon = new ColaEstatica();
        //si no esta vacia
        if(!esVacia()){
            //en caso de que el inicio sea menor a el fin
            //[E1, E2,...,En-i,...,En]
            //[fr, E2,...,fn,...,En]
            if(this.frente < this.fin){
                int i = this.frente;
                while(i <= this.fin){
                    clon.arreglo[i] = this.arreglo[i];
                    i++;
                }
            }else{
                //[E1, E2,...,En-i,...,En]
                //[fn, E2,...,fr,...,En]
                int j = 0;
                while(j <= this.fin){
                    clon.arreglo[j] = this.arreglo[j];
                    j++;
                }
                int k = this.frente;
                while(k < this.arreglo.length){
                    clon.arreglo[k] = clon.arreglo[k];
                    k++;
                }
            }
        }
        
        return clon;
    }
    
    /** metodo toString devuelve una cadena de caracteres mostrando la cola */
    public String toString(){
        String retorno = "[";
        
        if(!esVacia()){
            //en caso de que el inicio sea menor a el fin
            //[E1, E2,...,En-i,...,En]
            //[fr, E2,...,fn,...,En]
            if(this.frente < this.fin){
                int i = this.frente;
                while(i < this.fin){
                    if(i == this.fin - 1){
                        retorno = retorno+"" + this.arreglo[i].toString();   
                    }else{
                        retorno = retorno+ "," + this.arreglo[i].toString();   
                    }
                    i++;
                }
            }else{
                //[E1, E2,...,En-i,...,En]
                //[fn, E2,...,fr,...,En]
                int j = 0;
                while(j <= this.fin){
                    retorno = retorno + this.arreglo[j].toString();
                    j++;
                }
                int k = this.frente;
                while(k < this.arreglo.length){
                    retorno = retorno + this.arreglo[k].toString();
                    k++;
                }
            }
        }
        
        retorno = retorno + "]";
        return retorno;
    }
    
    /** metodo para vaciar la cola */
    private boolean esVacia(){
        boolean retorno = false;
        if(this.fin == this.frente){
            retorno = true;
        }
        return retorno;
    }
    

}
