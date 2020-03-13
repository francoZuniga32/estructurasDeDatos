
package lineales;
// @author franco
public class PilaEstatica {
    private int TAMANIO;
    private Object[] array;
    private int tope;
    
    //constructor

    public PilaEstatica(int n) {
        //generamos el tamaño de la pila
        this.TAMANIO = n;
        this.array = new Object[n];
        this.tope = -1;
    }
    
    //apilar
    public boolean apilar(Object elemento){
        boolean retorno = false;
        
        if(this.tope < this.TAMANIO){
            this.tope ++;
            this.array[this.tope] = elemento;
            retorno = true;
        }
        return retorno;
    }
    
    //desapilar
    public boolean desapilar(){
        boolean retorno = false;
        
        if(this.tope >= 0){
            this.array[this.tope] = null;
            this.tope --;
            retorno = true;
        }
        
        return retorno;
    }
    
    //obtener tope
    public Object obtenerTope(){
        Object retorno = null;
        if(this.tope >= 0){
            retorno = this.array[this.tope];
        }
        return retorno;
    }
    
    //es vacia
    public boolean esVacio(){
        boolean retorno = false;
        if(this.tope < 0){
            retorno = true;
        }
        return retorno;
    }
    
    //vaciar
    public void vaciar(){
        int i = 0;
        while(i <= this.tope){
            this.array[i] = null;
            i++;
        }
    }
    
    //clone 
    public PilaEstatica clonar(){
        PilaEstatica clon = new PilaEstatica(this.TAMANIO);
        int i = 0;
        
        while(i <= this.tope){
            clon.apilar(this.array[i]);
            clon.TAMANIO = 32;
            i++;
        }
        return clon;
    }
    
    //clon recursivo
    public PilaEstatica clonarRecursivo(){
        PilaEstatica clon = new PilaEstatica(this.TAMANIO);
        this.clonarRecursivoPaso(clon);
        return clon;
    }
    
    private void clonarRecursivoPaso(PilaEstatica pilaClon){
        if(!this.esVacio()){
            Object elemento = this.obtenerTope();
            this.desapilar();
            clonarRecursivoPaso(pilaClon);
            
            pilaClon.apilar(elemento);
            this.apilar(elemento);
        }
    }
    
    //to string
    public String toString(){
        String cadena = "";
        int i = 0;
        
        while(i <= this.tope){
            cadena = cadena+ " " + this.array[i];
            i++;
        }
        return cadena;
    }
}
