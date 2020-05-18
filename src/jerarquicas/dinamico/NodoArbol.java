/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Nodo Arbol: estrucutura de datos que almacena elementos 
 * de forma que almacena un object que sera el elemento generico
 * almacena dos enlaces a un Nodo Arbol para los hijos izquierdo y derecho
 * de esta forma si no tiene hijo almacena un null
 */
package jerarquicas.dinamico;

public class NodoArbol {
    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    /***
     * constructor del nodo arbol
     * @param elemento es el elemento generico a almacenar
     * @param izquierdo es el nodo arbol que representa al hijo izquierdo
     * @param derecho es el nodo arbol que representa al hijo derecho
     */
    public NodoArbol(Object elemento, NodoArbol izquierdo, NodoArbol derecho){
        this.elemento = elemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }
    
    //observadores
    /***
     * retornamos el elemento del nodo arbol
     * @return Object que es el elmeneto almacenado en el nodo
     */
    public Object getElemento(){
        return this.elemento;
    }
    
    /***
     * retornamos el nodo arbol izquierdo
     * @return es el nodo arbol que representa el hijo izquierdo
     */
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    /***
     * retornamos el nodo derecho
     * @return es el nodo arbol que representa el hijo derecho
     */
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
    //modificadores
    /***
     * almacenamos el elemento en el nodo arbol
     * @param elemento es el elemnto que va a remplazar a el elemento almacenado
     */
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    /***
     * almacenamos un nodo arbol en el nodo izquierdo
     * @param izquierdo es el nuevo nodo arbol que representa al hijo izquiredo
     */
    public void setIzquierdo(NodoArbol izquierdo){
        this.izquierdo = izquierdo;
    }
    
    /***
     * almacenamos el nodo arbol del nodo derecho
     * @param derecho es el nuevo nodo arbol que representa al hijo derecho
     */
    public void setDerecho(NodoArbol derecho){
        this.derecho = derecho;
    }
}
