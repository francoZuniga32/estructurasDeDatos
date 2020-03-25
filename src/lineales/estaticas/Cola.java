
package lineales.estaticas;

/**
 * @author franco
 */
public class Cola {
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int fin;
    private int frente;
    
    public Cola(){
        //creamos el arreglo
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }
    
    /** meter un elemento en la cola */
    public boolean poner(Object elemento){
        boolean retorno = false;
        if(!this.estaLlena()){
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
            retorno = true;
        }
        return retorno;
    }
    
    /** sacar un elemento de la cola */ 
    public boolean sacar(){
        boolean retorno = false;
        if( this.fin != this.frente ){
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
            retorno = true;
        }
        return retorno;
    }
    
    /** obtener el frente de la cola */
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
    
    /** clonamos la cola */
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
    
    /** metodo toString devuelve una cadena de caracteres mostrando la cola */
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
    
    /** metodo para vaciar la cola */
    private boolean esVacia(){
        boolean retorno = false;
        if(this.fin == this.frente){
            retorno = true;
        }
        return retorno;
    }
    
    /** metodo para vaciar la cola */
    private boolean estaLlena(){
        boolean retorno = false;
        if(((this.fin + 1) % this.TAMANIO ) == this.frente){
            retorno = true;
        }
        return retorno;
    }
}
