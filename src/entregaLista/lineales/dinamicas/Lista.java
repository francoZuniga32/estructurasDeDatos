package entregaLista.lineales.dinamicas;

/**
 * @author franco
 * las operaciones que se realizan a continuacion tienen en cuanta el uso del recolector de basura de java
 * por lo que muchas de las operaciones implican el desreferenciar objetos.
 */
public class Lista {
    private Nodo cabecera;
    private int longitud;
    
    /**
     * Constructor de la clase Lista
     */
    public Lista(){
        this.cabecera = null;
        this.longitud = 0;
    }
    
    /**
     * Insertamos un elemento en la posicion especificada
     * @param elemento
     * @param posicion
     * @return booleano true(si se puedo insertar) false (si la pocicion no es valida)
     */
    public boolean insertar(Object elemento, int posicion){
        boolean retorno = false;
        //evaluamos que la posicion esta definida en el arrerglo
        Nodo aux = this.cabecera;
        
        //evaluamos si la pocicion es valida
        if(posicion > 0 && posicion <= this.longitud() + 1){
            //vemos si hay que colocar en la primer pocicion
            if(posicion == 1){
                this.cabecera = new Nodo(elemento, this.cabecera);
            }else{
                //recorremos los nodos asta encontrar la pocicion
                int i = 1;
                while( i < posicion - 1){
                    aux = aux.getEnlace();
                    i++;
                }
                //cremos el nodo y le samos el enlace de aux
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud = this.longitud + 1;
            retorno = true;
        }
        
        return retorno;
    }
    
    /**
     * Eliminamos un elemento de la pocicion indicada
     * @param posicion
     * @return 
     */
    public boolean eliminar(int posicion){
        boolean retorno = false;
        //evaluamos que la posicion esta definida en el arrerglo
        Nodo aux = cabecera;
        
        //evaluamos si la pocicion es valida
        if(posicion > 0 && posicion < this.longitud() + 1){
            //vemos si hay que colocar en la primer pocicion
            if(posicion == 1){
                this.cabecera = this.cabecera.getEnlace();
            }else{
                //recorremos los nodos asta encontrar la pocicion
                int i = 1;
                while( i < posicion - 1){
                    aux = aux.getEnlace();
                    i++;
                }
                //obtenemos el enlace del enlace de aux
                Nodo enlace = aux.getEnlace().getEnlace();
                //a aux le definimos este enlace
                aux.setEnlace(enlace);
            }
            this.longitud--;
            retorno = true;
        }
        return retorno;
    }
    
    /**
     * Recuperamos el elemento en la pocicion indicada
     * @param posicion
     * @return 
     */
    public Object recuperar(int posicion){
        Object retorno = null;
        //evaluamos que la posicion esta definida en el arrerglo
        Nodo aux = this.cabecera;
        
        //evaluamos si la pocicion es valida
        if(posicion > 0 && posicion <= this.longitud()){
            //recorremos los nodos asta encontrar la pocicion
            int i = 1;
            while( i < posicion ){
                aux = aux.getEnlace();
                i++;
            }
            //obtenemos el elemento de el nodo en esta pocicion
            retorno = aux.getElemento();
        }
        return retorno;
    }
    
    /**
     * Localizamos un elemento en la lista
     * @param elemento
     * @return 
     */
    public int localizar(Object elemento){
        int retorno = -1;
        
        Nodo aux = this.cabecera;
        boolean control = false;
        //recorremos los nodos comparando elementos
        int i = 1;
        
        while( i <= this.longitud() && !control ){
            //cuando lo encontremos cortamos y retornamos al pocicion donde se encontro
            if(aux.getElemento().toString().compareTo(elemento.toString()) == 0){
                control = true;
                retorno = i;
            }else{
                aux = aux.getEnlace();
                i++;   
            }
        }
        //retornamos -1 si no lo encuentra y n si lo encuentra
        return retorno;
    }
    
    /**
     * Retornamos la longitud de la lista
     * @return 
     */
    public int longitud(){
        return this.longitud;
    }
    
    /**
     * Evaluamos o consultamos si la lista esta vacia
     * @return 
     */
    public boolean esVacia(){
        boolean retorno = false;
        if(this.cabecera == null){
            retorno = true;
        }
        return retorno;
    }
    
    /**
     * Vaciamos la Lista
     */
    public void vaciar(){
        this.cabecera = null;
    }
    
    /***
     * es el algoritmo sonde creamos un clon invertido
     * @return 
     */
    public Lista invertir(){
        Lista invertido = new Lista();
        Nodo retorno = invertirPaso(this.cabecera, invertido);
        retorno.setEnlace(null);
        return invertido;
    }
    
    /**
     * es el paso recursivo para poder realizar la lista invertida
     * @param punteroOriginal es el puntero de los nodos de la lisa original
     * @param listaClone, es la lista clon que usamos para poder crear la cabecera
     * @return 
     */
    private Nodo invertirPaso(Nodo punteroOriginal,Lista listaClone){
        Nodo retorno;
        //guardamos el elemento de el nodo original
        Object elemento = punteroOriginal.getElemento();
        
        //mintras no este apuntando al null (fin de la cabecera)
        if(punteroOriginal.getEnlace() != null){
            //llamamos la paso recursivo
            retorno = invertirPaso(punteroOriginal.getEnlace(), listaClone);
            //en caso de que el enlace (auxEnlace) es null, redefinimos la cabecera
            retorno.setEnlace(new Nodo(elemento, null));
            retorno = retorno.getEnlace();
        }else{
            listaClone.cabecera = new Nodo(elemento, listaClone.cabecera);
            retorno = listaClone.cabecera;
        }
        return retorno;
    }
    
    /***
     * eliminamos las apariciones de un elemento en la lista
     * @param elemento
     * @return 
     */
    public boolean eliminarApariciones(Object elemento){
        //vamos a recorrer los nodos buscando
        boolean retorno = false;
        
        if(this.cabecera != null){
            System.out.println("No es vacia");
            //evaluamos en la pisicion 1 donde esta la babecera
            if(this.cabecera.getElemento().equals(elemento)){
                this.cabecera = this.cabecera.getEnlace();
                this.longitud --;
                retorno = true;
                System.out.println("esta en la cabecera");
            }else{
                int i = 1;
                Nodo puntero = this.cabecera;
                while(i <= longitud){
                    if(puntero.getEnlace().getElemento().equals(elemento)){
                        Nodo enlaceDeEnlace = puntero.getEnlace().getEnlace();
                        puntero.setEnlace(enlaceDeEnlace);
                        longitud--;
                        retorno = true;
                    }
                    i++;
                }
            }
        }
        return retorno;
    }
    
    /**
     * Clonamos la lista actual
     * @return Lista clonada
     */
    public Lista clone(){
        //cremos la lista clon
        Lista clon = new Lista();
        if(this.cabecera != null){
            //generamos la baecera
            clon.cabecera = new Nodo(this.cabecera.getElemento(), null);
            //llamamos al paso recursivo
            clonePasoRecursivo(this.cabecera, clon.cabecera);
            clon.longitud = this.longitud;
        }

        return clon;
    }
    
    /**
     * Paso recursivo que clona la lista, donde pasamos el clon
     * nos movemos por el enlace de la cabecera original, vamos clonando los elementos del enlace 
     * y cermaos un nodo y vamos enlazando.
     * @param clon
     * @param aux
     * @param puntero 
     */
    private void clonePasoRecursivo(Nodo aux, Nodo puntero){
        if(aux.getEnlace() != null){
            aux = aux.getEnlace();
            Nodo nuevo = new Nodo(aux.getElemento(), null);
            puntero.setEnlace(nuevo);
            puntero = nuevo;
            clonePasoRecursivo(aux, puntero);
        }
    }
    
    /**
     * retornamos una cadena de caracteres, con la lista representada.
     * @return 
     */
    public String toString(){
        String retorno = "Lista Vacia";
        //evaluamos que la lista no este vacia
        if(this.cabecera != null){
            retorno = "[";
            Nodo aux = this.cabecera;
            
            while(aux != null){
                retorno = retorno + aux.getElemento().toString();
                if(aux.getEnlace() != null){
                    retorno += ",";
                }
                aux = aux.getEnlace();
            }
            
            retorno += "]";
        }
        return retorno;
    }
}
