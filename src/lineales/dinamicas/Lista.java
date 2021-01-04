/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Lista: estrcutura de datos que almacena elementos 
 * como un arreglo dinamico, pero la forma de hacerlo 
 * es enlazando nodos.
 */
package lineales.dinamicas;

public class Lista{
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
     * @param elemento el elemento a almacenar
     * @param posicion la pocision donde lo queremos insertar en la lista
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
     * @param posicion es el lugar en la lista que queremos eliminar en la lista
     * @return true si puedo eliminar
     *         false si la pocicion no es valida
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
     * @param posicion la posicion del elemento a recuperar
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
     * @param elemento es el elemento a buscar
     * @return la posicion donde se encuentra el elemento -1 si no lo encontro
     */
    public int localizar(Object elemento){
        int retorno = -1;
        
        Nodo aux = this.cabecera;
        boolean control = false;
        //recorremos los nodos comparando elementos
        int i = 1;
        
        while( i <= this.longitud() && !control ){
            //cuando lo encontremos cortamos y retornamos al pocicion donde se encontro
            if(aux.getElemento().equals(elemento)){
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
     * @return longitud de la lista
     */
    public int longitud(){
        return this.longitud;
    }
    
    /**
     * Evaluamos o consultamos si la lista esta vacia
     * @return true si esta vacia
     *         false en caso contrario
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
        this.longitud = 0;
    }
    
    /***
     * es el algoritmo sonde creamos un clon invertido
     * @return una lista con los enlaces invertidos
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
     * @return nodo para el enlace inverso recursivo
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
     * @param elemento el que queremos eliminar de la lista
     * @return true si pudo eliminar las apariciones
     *         false si no encontro dicho elemento
     */
    public boolean eliminarApariciones(Object elemento){
        boolean retorno = false;
        //si la lista no esta vacia entonces vamos a recorrerla
        if(this.cabecera != null){
            //evaluamos en la pisicion 1 donde esta la cabecera
            while(this.cabecera.getElemento().equals(elemento)){
                Nodo nuevo = null;
                if(this.cabecera.getEnlace() != null){
                    nuevo = this.cabecera.getEnlace();   
                }
                this.cabecera = nuevo;
                this.longitud--;
            }
            Nodo aux = this.cabecera;
            while(aux.getEnlace() != null){
                if(aux.getEnlace().getElemento().equals(elemento)){
                    //en ese caso pasamos al siguiente enlace
                    Nodo nuevo = null;
                    if(aux.getEnlace().getEnlace() != null){
                        nuevo = aux.getEnlace().getEnlace();
                    }
                    aux.setEnlace(nuevo);
                    this.longitud--;
                }else{
                    aux = aux.getEnlace();
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
    
    /***
     * Paso recursivo que clona la lista, donde pasamos el clon
     * nos movemos por el enlace de la cabecera original, vamos clonando los elementos del enlace 
     * y cermaos un nodo y vamos enlazando.
     * @param aux nodo
     * @param puntero 
     */
    private void clonePasoRecursivo(Nodo aux, Nodo puntero){
        //mientras el nodo de la lista actual no apunte a null
        if(aux.getEnlace() != null){
            //obtenemos el enlace de este nodo
            aux = aux.getEnlace();
            //cremos un nuevo nodo clon el cual vamos a enlazar con puntero
            Nodo nuevo = new Nodo(aux.getElemento(), null);
            puntero.setEnlace(nuevo);
            //hacemos que puntero cambie a su enlace
            puntero = nuevo;
            clonePasoRecursivo(aux, puntero);
        }
    }
    
    /**
     * retornamos una cadena de caracteres, con la lista representada.
     * @return String que representa la lista
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
    
    public Lista obtenerMultiplos(int numero){
        Lista nuevaLista = new Lista();
        if(this.cabecera != null){
            obtenerMultiplosAux(nuevaLista, numero);
        }
        return nuevaLista;
    }
    
    private void obtenerMultiplosAux(Lista nuevaLista, int numero){
        if(numero <= this.longitud){
            Nodo aux = this.cabecera;
            Nodo aux2 = null;
            int i = 1;
            
            while(i < this.longitud){
                if(i % numero == 0){
                    if(nuevaLista.cabecera == null){
                        nuevaLista.cabecera = new Nodo(aux.getElemento(), null);
                        aux2 = nuevaLista.cabecera;
                    }else{
                        Nodo nuevo = new Nodo(aux.getElemento(), null);
                        aux2.setEnlace(nuevo);
                        aux2 = aux2.getEnlace();
                    }
                }
                aux = aux.getEnlace();
                i++;
            }
        }
    }
}
