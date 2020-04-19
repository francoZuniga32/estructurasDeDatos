/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.dinamico;
import lineales.dinamicas.*;
/**
 *
 * @author franco
 */
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
     * @param elementoNuevo
     * @param elementoPadre
     * @param posicion
     * @return boolean
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
     * @param raiz
     * @param nuevoElemento
     * @param elementoPadre
     * @param posicion
     * @return boolean
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
     * este es el metodo para dar el padre de un elemento
     * en caso de ser un arbol vacio retorna mensaje de "arbol vacio"
     * en el caso de que el elemento de sea la raiz devulve un mensaje de "elemento padre"
     * en el caso de que no se busca por el metodo auxliar
     * @param elemento
     * @return Object
     */
    public Object padre(Object elemento){
        Object retorno = "ArbolVacio";
        
        if(!this.esVacio()){
            retorno = "El elemento es raiz";
            if(!this.raiz.getElemento().equals(elemento)){
                retorno = padreRecursivo(this.raiz, elemento);
            }
        }
        
        return retorno;
    }
    
    /***
     * es el metodo auxiliar para encontrar el elemento
     * donde los vamos a buscar por preorden
     * @param raiz
     * @param elemento
     * @return Object
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
    
    public Object padreDante(Object hijo) {
        return busPadre(this.raiz, hijo, this.raiz.getElemento());
    }

    private Object busPadre(NodoArbol aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if(aux.getElemento().equals(hijo)) {
                r = padre;
            }else{
                r = busPadre(aux.getIzquierdo(), hijo, aux.getElemento());
                if (r == null) {
                    r = busPadre(aux.getDerecho(), hijo, aux.getElemento());
                }
            }
        }
        return r;
    }
    
    public Object padreNivel(Object elemento){
        Object retorno = "Arbol Vacio";
        if(this.raiz != null){
            retorno = "es el padre";
            if(this.raiz.getElemento().equals(elemento)){
                //usamos una cola para poder recorrer los niveles
                Cola cola = new Cola();
                //ponemos el nodo raiz en la cola
                cola.poner(this.raiz);
                //variable de control para parar el algiritmo
                boolean control = true;

                //recorremos mientras la cola no este vacia
                while(!cola.esVacia() && control){
                    //obtenemos el tope de la cola
                    NodoArbol aux = (NodoArbol) cola.obtenerFrente();
                    System.out.print(aux.getElemento().toString()+",");
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
            }
        } 
        
        return retorno;
    }
    
    
    /***
     * obtenemos la altura del arbol
     * @return int
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
     * @param raiz
     * @return int
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
     * 0 si es raiz, y asi
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
    
    
    public ArbolBin clone(){
        ArbolBin clon = new ArbolBin();
        if(this.raiz != null){
            clon.raiz = new NodoArbol(this.raiz.getElemento(), null, null);
            auxClone(this.raiz, clon.raiz);
        }
        
        return clon;
    }
    
    public void auxClone(NodoArbol raizOriginal, NodoArbol raizClone){
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
     * listamos el arbol en preodren (raiz, arbolIzq, arbolDer)
     */
    public void preorden(){
        //invocamos el metodo auxliar para poder recorrerlos
        auxpreorden(this.raiz);
    }
    
    /***
     * metodo auxliliar para el recorrido en preorden
     * @param raiz 
     */
    private void auxpreorden(NodoArbol raiz){
        if(raiz != null){
            System.out.print(raiz.getElemento().toString()+",");
            
            auxpreorden(raiz.getIzquierdo());
            auxpreorden(raiz.getDerecho());
        }
    }
    
    /***
     * recorremos el arbol por inorden
     */
    public void inorden(){
        //invocamos el metodo auxliar para poder recorrerlos
        auxInorden(this.raiz);
    }
    
    /***
     * metodo auxliliar para recorrer el arbol por inorden
     * @param raiz 
     */
    private void auxInorden(NodoArbol raiz){
        if(raiz != null){
            auxInorden(raiz.getIzquierdo());
            System.out.print(raiz.getElemento().toString()+",");
            auxInorden(raiz.getDerecho());
        }
    }
    
    /***
     * recorremos el arbol por posorden
     */
    public void posorden(){
        //invocamos el metodo auxliar para poder recorrerlos
        auxPosOrden(this.raiz);
    }
    
    /***
     * metodo auxliliar para recorrer el arbol por posorden
     * @param raiz 
     */
    private void auxPosOrden(NodoArbol raiz){
        if(raiz != null){
            auxPosOrden(raiz.getIzquierdo());
            auxPosOrden(raiz.getDerecho());
            System.out.print(raiz.getElemento().toString()+",");
        }
    }
    
    /***
     * recorremos el arbol por niveles
     */
    public void porNivel(){
        //usamos una cola para poder recorrer los niveles
        Cola cola = new Cola();
        //ponemos el nodo raiz en la cola
        cola.poner(this.raiz);
        //recorremos mientras la cola no este vacia
        while(!cola.esVacia()){
            //obtenemos el tope de la cola
            NodoArbol aux = (NodoArbol) cola.obtenerFrente();
            System.out.print(aux.getElemento().toString()+",");
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
    }
    
    
    /***
     * metodo por le cual vamos a devolver un string de la forma del arbol
     * donde: listamos los hijos de el arbol de esta forma:
     * elemento: HI: elementoIzquierdo HD: elementoDerecho
     * si no tiene HI o HD le ponemos un -
     * si el arbol esta vacio devolvemos un error de arbol vacio
     * recorremos el arbol en preorden
     * @return String
     */
    
    //especiales de la estructura
    /***
     * 
     * @return 
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
     * @param raiz
     * @return String
     */
    private String auxToString(NodoArbol raiz){
        String retorno = "";
        if(raiz != null){
            retorno = raiz.getElemento().toString()+":";
            
            NodoArbol izquierdo = raiz.getIzquierdo();
            NodoArbol derecho = raiz.getDerecho();
            
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
            
            retorno = retorno + "\n";
            
            if(izquierdo != null){
                retorno = retorno + auxToString(izquierdo);
            }
            
            if(derecho != null){
                retorno = retorno + auxToString(derecho);
            }
        }
        return retorno;
    }
    
    public boolean vericarPatron(Lista listaPatron){
        boolean retorno = false;
        if(listaPatron.esVacia()){
            if(this.raiz == null){
                retorno = true;
            }
        }else{
            if(this.raiz != null){
                retorno = verificarPatronAux(this.raiz, listaPatron);
            }
        }
           
        return retorno;
    }
    
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
                
                if(raiz.getDerecho() != null && !retornoIzquierdo){
                    retorno = verificarPatronAux(raiz.getDerecho(), listaPatron);
                }
            }
        }
        return retorno;
    }
    
    public Lista frontera(){
        Lista retorno = new Lista();
        if(this.raiz != null){
            fronteraAux(this.raiz, retorno);
        }
        return retorno;
    }
    
    private void fronteraAux(NodoArbol raiz, Lista lista){
        if(raiz != null){
            if(raiz.getIzquierdo() == null && raiz.getDerecho() == null){
                lista.insertar(raiz.getElemento(), 1);
            }else{
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
