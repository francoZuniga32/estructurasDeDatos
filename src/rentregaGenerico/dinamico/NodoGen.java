/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Nodo Gen: estrucutura de datos que almacena elementos 
 * de forma que almacena un object, que sera el elemento generico
 * almacena dos enlaces a un Nodo Gen para su hermano derecho y 
 * para su hijo hizquierdo, de esta forma un nodo representa a sus hijos como
 * un hijo izquierdo y los hemanos derechos de ese hijo izquierdo.
 */
package rentregaGenerico.dinamico;

public class NodoGen {
    private Object elemento;
    private NodoGen hijoIzquierdo;
    private NodoGen HermanoDerecho;
    
    /***
     * constructor del nodo gen el cual almacena un elemento de tipo 
     * Object y dos enlaces a un hijo izquierdo y otro a su hermano derecho
     * @param elemento es el elemento a almacenar
     * @param hijoIzquiedo es el enlace al hijo izquierdo
     * @param hermanoDerecho es el enlace al hermano derecho
     */
    public NodoGen(Object elemento, NodoGen hijoIzquiedo, NodoGen hermanoDerecho){
        this.elemento = elemento;
        this.hijoIzquierdo = hijoIzquiedo;
        this.HermanoDerecho = hermanoDerecho;
    }
    
    /***
     * obtenemos el elemento almacenado por el nodo
     * @return el elemento almacenado
     */
    public Object getElemento(){
        return this.elemento;
    }
    
    /***
     * retornamos el enlace del hijo izquierdo del nodo
     * @return NodoGen que es el enlace del hijo izquierdo
     */
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    
    /***
     * retornamos el enlace del hermano derecho del nodo
     * @return NodoGen que es el enlace del hermano derecho
     */
    public NodoGen getHermanoDerecho(){
        return this.HermanoDerecho;
    }
    
    /***
     * almacenamos un objeto en el nodo
     * @param elemento es el objecto a almacenar
     */
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    /***
     * almacenamos un nuevo hijo izquierdo en el nodo
     * @param hijoIzquierdo es el nuevo hijo izquierdo del nodo
     */
    public void setHijoIzquierdo(NodoGen hijoIzquierdo){
        this.hijoIzquierdo = hijoIzquierdo;
    }
    
    /***
     * almacenamos un nuevo hermano derecho en el nodo
     * @param hermanoDerecho es el nuevo hermano derecho del nodo
     */
    public void setHermanoDerecho(NodoGen hermanoDerecho){
        this.HermanoDerecho = hermanoDerecho;
    }
}
