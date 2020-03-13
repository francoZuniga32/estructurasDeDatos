package lineales;

//@author franco
public class PilaDinamica {
    private Nodo tope;
    
    public PilaDinamica(){
        this.tope = null;
    }
    
    public boolean apilar(Object elemento){
        //creamos un nodo y le enlasamos con el tope
        Nodo nuevo = new Nodo(elemento, this.tope);
        //ahora el tope es el nuevo nodo
        this.tope = nuevo;
        //retornamos true
        return true;
    }
    
    public boolean desapilar(){
        boolean retorno = false;
        if(!this.esVacia()){
            Nodo nuevo = this.tope.getEnlace();
            this.tope = nuevo;
            retorno = true;            
        }
        return retorno;
    }
    
    public Object obtenerTope(){
        return this.tope.getElemento();
    }
    
    public boolean esVacia(){
        boolean retorno = false;
        if(this.tope == null){
            retorno = true;
        }
        return retorno;
    }    

    public void vaciar(){
        this.tope = null;
    }
    
    //to string
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
    public PilaDinamica clonarRecursivo(){
        PilaDinamica clon = new PilaDinamica();
        this.clonarRecursivoPaso(clon,this.tope);
        return clon;
    }
    
    private void clonarRecursivoPaso(PilaDinamica pilaClon, Nodo actual){
        
        if(actual != null){
            clonarRecursivoPaso(pilaClon,actual.getEnlace());
            pilaClon.apilar(actual.getElemento());
        }
        
    }
    
    
}
