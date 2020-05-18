/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Arbol binario: estrucutura de datos que en la cual cada elemento 
 * puede tener un hijo izquierdo y un hijo derecho. 
 * No pueden tener más de dos hijos de hay binario 
 * mas informaicion: https://es.wikipedia.org/wiki/%C3%81rbol_binario
 */
package jerarquicas.dinamico;
import lineales.dinamicas.*;

public class ArbolBin {
    private NodoArbol raiz;
    
    /***
     * constructor del arbol binario
     */
    public ArbolBin(){
        this.raiz = null;
    }
    
    /***
     * vamos insertar el elemento en el arbol, indicando el padre y la pocicion Izquierdo o Derecho
     * retorna falso, si no encontro el padre o si la pocicion del padre encontrado esta ocupada
     * @param elementoNuevo es el elemento a insetar el nuevo nodo a crear
     * @param elementoPadre es al padre nodo que almacenara el elemento
     * @param posicion es la pocicion 'I' o 'D' para decidir donde insertarlo
     * @return boolean si logro insertar el elemento, retorna false si:
     *         el padre no existe, o si la pocicion ya esta ocupada
     *         caso contrario retorna true
     */
    public boolean insertar(Object elementoNuevo, Object elementoPadre, char posicion){
        /***
         * inseramos el elementoNuevo como uno de los hijos (I/D) indicados por pocicion
         * elementoPadre es el elemento que vamos a buscar por arbol
         * en caso de que no este retorna falso, si el hijo indicado esta ocupado retorna falso
         */
        
        boolean retorno = true;
        
        //si el arbol esta vacio, lo guardamos como raiz
        if(this.raiz == null){
            this.raiz = new NodoArbol(elementoNuevo, null, null);
        }else{
            //si el arbol no esta vacio, vamos a buscar a su padre por preorden
            retorno = auxInsertarPreorden(this.raiz, elementoNuevo, elementoPadre, posicion);
        }
        
        return retorno;
    }
    
    /***
     * metodo auxliar que recorre el arbol en preorden, asta encontrar el padre
     * si lo encuantra intenta insetar en I o D, si no pude retorna falso
     * si puede retorna true
     * si no encuntra la padre retorna false
     * @param raiz es el nodo del subarbol
     * @param nuevoElemento el nuevo elemeneto a querer insertar
     * @param elementoPadre el elemento que almacena le padre para poder bucarlo
     * @param posicion cual de las pocisiones hay que insertarlo 'I' o 'D'
     * @return boolean si logra insertarlo, funciona para cortar la busqueda del padre
     */
    private boolean auxInsertarPreorden(NodoArbol raiz, Object nuevoElemento, Object elementoPadre, char posicion){
        /***
         * buscamos en raiz el elemnto padre, pero si no es igual, recorremos preorden
         */
        boolean retorno = false;
        
        if(raiz.getElemento().equals(elementoPadre)){
            //encontramos el padre a insertar
            if(posicion == 'I' && raiz.getIzquierdo() == null){
                //si la pocicion es I, y el hijo izquierdo es null
                //insetamos el nuevo elemento
                raiz.setIzquierdo(new NodoArbol(nuevoElemento, null, null));
                retorno = true;
            }
            
            if(posicion == 'D' && raiz.getDerecho() == null){
                //si la pocicion es D, y el hijo derecho es null
                //insetamos el nuevo elemento
                raiz.setDerecho(new NodoArbol(nuevoElemento, null, null));
                retorno = true;
            }
        }else{
            if(raiz.getIzquierdo() != null){
                //si el hijo izquierdo es distinto null, entonces hacemos el llamado recursivo
                retorno = retorno || auxInsertarPreorden(raiz.getIzquierdo(), nuevoElemento, elementoPadre, posicion);
            }
            
            if(raiz.getDerecho() != null){
                //si el hijo derecho es distinto de null, entonces hacemos el llamado recursivo
                retorno = retorno || auxInsertarPreorden(raiz.getDerecho(), nuevoElemento, elementoPadre, posicion);
            }
        }
        
        return retorno;
    }
    
    /***
     * !!evaluar si es usado por algun metodo en particular para poder evitar 
     * tenerlo y en caso de no necesitarlo sacarlo
     * @param elemento
     * @return 
     */
    private Object obtenerNodo(Object elemento){
        //vamos a buscar por preorden el nodo arbol del arbol
        Object retorno = null;
        if(this.raiz != null){
            //vamos a buscar el elemento en la raiz
            retorno = obtenerNodoPaso(elemento, this.raiz);
        }
        return retorno;
    }
    
    private Object obtenerNodoPaso(Object elemento, NodoArbol raiz){
        //vamos a comparar en la raiz
        Object retorno = null;
        if(raiz.getElemento().toString().equals(elemento.toString())){
            retorno = raiz;
        }else{
            //comprobamos si hay HI si lo hay llamamos
            if(raiz.getIzquierdo() != null){
                retorno = obtenerNodoPaso(elemento, raiz.getIzquierdo());
            }
            //comprobamos que tenemos HD y que no encontraramos el elemento por HI
            if(raiz.getDerecho() != null && retorno == null){
                retorno = obtenerNodoPaso(elemento, raiz.getDerecho());
            }
        }
        return retorno;
    }
    
    /***
     * retorna true si el arbol esta vacio y si no false
     * @return boolean
     */
    public boolean esVacio(){
        boolean retorno = false;
        if(this.raiz == null){
            retorno = true;
        }
        
        return retorno;
    }
    
    /***
     * este es el metodo para dar el padre de un elemento,
     * en caso de ser un arbol vacio retorna un null
     * en el caso de que el elemento de sea la raiz devulve un null
     * en el caso de que no, se busca por el metodo auxliar
     * @param elemento
     * @return Object
     */
    public Object padre(Object elemento){
        Object retorno = null;
        
        if(!this.esVacio()){
            if(!this.raiz.getElemento().equals(elemento)){
                retorno = padreRecursivo(this.raiz, elemento);
            }
        }
        
        return retorno;
    }
    
    /***
     * es el metodo auxiliar para encontrar el elemento
     * donde los vamos a buscar por preorden
     * @param raiz que es el padre del subarbol
     * @param elemento el elemento a localizar como hijo de raiz
     * @return Object que sera raiz en caso de ser el padre de elemento
     */
    private Object padreRecursivo(NodoArbol raiz, Object elemento){
        //el valor de retorno que esta seteado en null
        Object retorno = null;
        boolean control = true;
        
        if(raiz.getIzquierdo() != null){
            //mientras que el hijo izquierdo no sea null
            if(raiz.getIzquierdo().getElemento().equals(elemento)){
                retorno = raiz.getElemento();
                control = false;
            }else{
                retorno = padreRecursivo(raiz.getIzquierdo(), elemento);
                if(retorno != null){
                    control = false;
                }
            }
        }
        
        if(control && raiz.getDerecho() != null){
            //mientras que el hijo derecho no sea null, y el control sea verdadero
            if(raiz.getDerecho().getElemento().equals(elemento)){
                retorno = raiz.getElemento();
            }else{
                retorno = padreRecursivo(raiz.getDerecho(), elemento);
            }
        }
        
        return retorno;
    }
    
    /***
     * obtenemos la altura del arbol
     * @return int es la altura del arbol completo
     */
    public int altura(){
        int retorno = 0;
        
        if(this.raiz != null){
            retorno = auxAltura(this.raiz);
        }
        
        return retorno;
    }
    
    /***
     * metodo de obtencion de altura usando el recorrido en preorden
     * @param raiz el el nodo del subarbol
     * @return int es la altura del subarbol
     */
    private int auxAltura(NodoArbol raiz){
        //vamos a evaluar si la raiz no es null
        int retorno = 0;
        
        if(raiz != null){
            //vamos a recorrer en 
            retorno = 1;
            int retornoIzquirda = auxAltura(raiz.getIzquierdo());
            int retornoDerecha = auxAltura(raiz.getDerecho());
            
            if(retornoIzquirda >= retornoDerecha){
                retorno = retorno + retornoIzquirda;
            }else{
                retorno = retorno + retornoDerecha;
            }
        }
        
        return retorno;
    }
    
    /***
     * dado un elemento devolvemos el nivel en el cual se encuentra
     * -1 si no esta o el arbol esta vacio
     * 0 si es raiz, y asi se suman segun donde se encuentre de la raiz
     * podemos decir que es la cantidad de nodos de distancia desde la raiz asta
     * el elemento
     * @param elemento
     * @return int
     */
    public int nivel(Object elemento){
        int retorno = -1;
        
        if(this.raiz != null){
            retorno = retorno + nivelRecursivo(this.raiz, elemento);
        }
        return retorno;
    }
    
    /***
     * llamado recursivo para poder contar los niveles de un elemento en un arbol
     * @param raiz
     * @param elemento
     * @return 
     */
    private int nivelRecursivo(NodoArbol raiz, Object elemento){
        //evaluamos si el elemento esta en los hijos de la raiz
        int retorno = 0;
        boolean control = true;
        
        if(raiz.getElemento().equals(elemento)){
            retorno = 1;
        }else{
            //si el HI no es null, nos metemos
            if(raiz.getIzquierdo() != null){
                int retornoIzquierda = nivelRecursivo(raiz.getIzquierdo(), elemento);
                if(retornoIzquierda > 0){
                    retorno = 1 + retornoIzquierda;
                    control = false;
                }
            }else{
                if(raiz.getDerecho() != null){
                    int retornoDerecha = nivelRecursivo(raiz.getIzquierdo(), elemento);
                    if(retornoDerecha > 0 && control){
                        retorno = 1 + retornoDerecha;
                    }
                }
            }
        }
        
        return retorno;
    }
    
    /***
     * usamos el garbage colector, para eliminar toda la estructura
     */
    public void vaciar(){
        this.raiz = null;
    }
    
    /***
     * clonamos la estructura del arbol
     * @return un ArbolBin con la estructura del arbol actual
     */
    public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        if(this.raiz != null){
            clon.raiz = new NodoArbol(this.raiz.getElemento(), null, null);
            auxClone(this.raiz, clon.raiz);
        }
        
        return clon;
    }
    
    /***
     * es el metodo de clonacion auxiliar 
     * @param raizOriginal es el nodo de la subraiz
     * @param raizClone  es el nodo clonado de la subraiz
     */
    private void auxClone(NodoArbol raizOriginal, NodoArbol raizClone){
        //vamos a evalur si tenemos el HI en el nodo original
        if(raizOriginal.getIzquierdo() != null){
            //creamos un nodo arbol con los elementos de este HI
            NodoArbol cloneIzquierdo = new NodoArbol(raizOriginal.getIzquierdo().getElemento(), null, null);
            raizClone.setIzquierdo(cloneIzquierdo);
            auxClone(raizOriginal.getIzquierdo(), raizClone.getIzquierdo());
        }
        
        if(raizOriginal.getDerecho() != null){
            //creamos un nodo arbol con los elementos de este HI
            NodoArbol cloneDerecho = new NodoArbol(raizOriginal.getDerecho().getElemento(), null, null);
            raizClone.setDerecho(cloneDerecho);
            auxClone(raizOriginal.getDerecho(), raizClone.getDerecho());
        }
    }
    
    //recorridos de arboles
    
    /***
     * retornamos una lista de los elementos del arbol en preorden
     * @return Lista cuyos elementos se encuntran ordenados en preorden
     */
    public Lista preorden(){
        Lista preorden = new Lista();
        if(this.raiz != null){
            auxpreorden(this.raiz, preorden);
        }
        return preorden;
    }
    
    /***
     * metodo auxiliar para el insetado en la lista de los elementos del arbol
     * en preorden
     * @param raiz es la subraiz del subarbol
     * @param preorden es la lista donde se va a insertar
     */
    private void auxpreorden(NodoArbol raiz, Lista preorden){
        if(raiz != null){
            preorden.insertar(raiz.getElemento(), preorden.longitud() + 1);
            
            auxpreorden(raiz.getIzquierdo(), preorden);
            auxpreorden(raiz.getDerecho(), preorden);
        }
    }
    
    /***
     * recorremos el arbol por inorden
     */
    public Lista inorden(){
        Lista inorden = new Lista();
        if(this.raiz != null){
            auxInorden(this.raiz, inorden);   
        }
        return inorden;
    }
    
    /***
     * metodo auxiliar para insertar los elementos del arbol el inorden
     * @param raiz es la raiz del subarbol
     * @param inorden es ka lista que se usa para insertar
     */
    private void auxInorden(NodoArbol raiz, Lista inorden){
        if(raiz != null){
            auxInorden(raiz.getIzquierdo(), inorden);
            inorden.insertar(raiz.getElemento(), inorden.longitud() +1);
            auxInorden(raiz.getDerecho(), inorden);
        }
    }
    
    /***
     * recorremos el arbol por posorden
     */
    public Lista posorden(){
        Lista posorden = new Lista();
        if(this.raiz != null){
            auxPosOrden(this.raiz, posorden);
        }
        return posorden;
    }
    
    /***
     * metodo auxliliar para recorrer el arbol por posorden
     * @param raiz 
     */
    private void auxPosOrden(NodoArbol raiz, Lista posorden){
        if(raiz != null){
            auxPosOrden(raiz.getIzquierdo(), posorden);
            auxPosOrden(raiz.getDerecho(), posorden);
            posorden.insertar(raiz.getElemento(), posorden.longitud() +1);
        }
    }
    
    /***
     * recorremos el arbol por niveles
     */
    public Lista porNivel(){
        //usamos una cola para poder recorrer los niveles
        Cola cola = new Cola();
        Lista nivel = new Lista();
        //ponemos el nodo raiz en la cola
        cola.poner(this.raiz);
        //recorremos mientras la cola no este vacia
        while(!cola.esVacia()){
            //obtenemos el tope de la cola
            NodoArbol aux = (NodoArbol) cola.obtenerFrente();
            nivel.insertar(aux.getElemento(), nivel.longitud() +1);
            cola.sacar();
            
            //si el hijo izquierdo no es vacio lo ponemos en la cola
            if(aux.getIzquierdo() != null){
                cola.poner(aux.getIzquierdo());
            }
            //si el hijo derecho no es vacio lo ponemos en la cola
            if(aux.getDerecho() != null){
                cola.poner(aux.getDerecho());
            }
        }
        return nivel;
    }
    
    
    /***
     * metodo por le cual vamos a devolver un string de la forma del arbol
     * donde: listamos los hijos de el arbol de esta forma:
     * elemento: HI: elementoIzquierdo HD: elementoDerecho
     * si no tiene HI o HD le ponemos un -
     * si el arbol esta vacio devolvemos un error de arbol vacio
     * recorremos el arbol en preorden
     * @return String que reoresenta la estructura del arbol
     */
    public String toString(){
        //retornamos un string 
        String retorno = "Arbol vacio";
        
        if(this.raiz != null){
            retorno = auxToString(this.raiz);
        }
        
        return retorno;
    }
    
    /***
     * metodo recursivo auxiliar para poder armar el string del arbol 
     * @param raiz es la subraiz del subarbol
     * @return String es el string de retorno de la estructura del subarbol
     */
    private String auxToString(NodoArbol raiz){
        String retorno = "";
        if(raiz != null){
            retorno = raiz.getElemento().toString()+":";
            
            //obtenemos los hijos de este sub arbol
            NodoArbol izquierdo = raiz.getIzquierdo();
            NodoArbol derecho = raiz.getDerecho();
            //concatenamos lo que contengan esos hijos
            if( izquierdo != null){
                retorno = retorno + " HI:"+izquierdo.getElemento().toString();
            }else{
                retorno = retorno + " HI:-";
            }
           
            if( derecho != null){
                retorno = retorno + " HD:"+derecho.getElemento().toString();
            }else{
                retorno = retorno + " HD:-";
            }
            //creamos el salto de linea para darle formato
            retorno = retorno + "\n";
            //y relizamos algun recorrido de arbol
            if(izquierdo != null){
                retorno = retorno + auxToString(izquierdo);
            }
            
            if(derecho != null){
                retorno = retorno + auxToString(derecho);
            }
        }
        //retornamos dicho string generado
        return retorno;
    }
    
    //metodos especiales propuestos por la catedra de Estructuras de Datos
    
    /***
     * dado un lista con un padtron o comino desde la raiz asta un subarbol
     * recorremos con alguna condicion de corte para poder evaluar si dicho 
     * patron se encuantra en el arbol
     * @param listaPatron es la lista del patro o camino
     * @return true si dicho patron se encuantra en el arbol, 
     *         false en caso contrario 
     */
    public boolean vericarPatron(Lista listaPatron){
        boolean retorno = false;
        //evaluamos que la lista no esta vacia
        if(listaPatron.esVacia()){
            //en caso de que la lista este vacia y el arbol este vacio
            if(this.raiz == null){
                retorno = true;
            }
        }else{
            //en caso de no estar la lista vacia y que el arbol no lo este
            if(this.raiz != null){
                retorno = verificarPatronAux(this.raiz, listaPatron);
            }
        }
           
        return retorno;
    }
    
    /***
     * metodo auxliar para evaluar si un patros esta en el arbol
     * @param raiz es la subraiz del subarbol
     * @param listaPatron es la lista del patron o camino
     * @return true si el patron coincide, false en caso contrario
     */
    private boolean verificarPatronAux(NodoArbol raiz, Lista listaPatron){
        //verificamos si el elemento en el frente de la lista es igual a la raiz
        boolean retorno = false;
        if(raiz != null && !listaPatron.esVacia()){
            //comparamos con la raiz
            Object primerElemento = listaPatron.recuperar(1);
            if(raiz.getElemento().equals(primerElemento)){
                //si esta sacamos este elemento en la lista y llamamos con el HI
                boolean retornoIzquierdo = false;
                listaPatron.eliminar(1);
                retorno = true;
                if(raiz.getIzquierdo() != null){
                     retornoIzquierdo = verificarPatronAux(raiz.getIzquierdo(), listaPatron);
                     retorno = retornoIzquierdo;
                }
                //si no encontro el patron por el HI, lo busca por le HD
                if(raiz.getDerecho() != null && !retornoIzquierdo){
                    retorno = verificarPatronAux(raiz.getDerecho(), listaPatron);
                }
            }
        }
        return retorno;
    }
    
    /***
     * retornamos una lista de los elementos en la frontera del arbol
     * los que serian hoja del mismo
     * @return Lista con las hojas del arbol
     */
    public Lista frontera(){
        Lista retorno = new Lista();
        if(this.raiz != null){
            fronteraAux(this.raiz, retorno);
        }
        return retorno;
    }
    
    /***
     * metodo auxiliar para almacenar las hojas del arbol
     * @param raiz es la subraiz del subarbol
     * @param lista es la Lista de hojas
     */
    private void fronteraAux(NodoArbol raiz, Lista lista){
        //si el nodo no es null
        if(raiz != null){
            //evaluamos si no tenemos HI y si no tenemos HD en caso insertamos
            if(raiz.getIzquierdo() == null && raiz.getDerecho() == null){
                lista.insertar(raiz.getElemento(), 1);
            }else{
                //caos contrario buscamos en los subarboles
                if(raiz.getIzquierdo() != null){
                    fronteraAux(raiz.getIzquierdo(), lista);
                }
                if(raiz.getDerecho() != null){
                    fronteraAux(raiz.getDerecho(), lista);
                }
            }
        }
    }
    
}
