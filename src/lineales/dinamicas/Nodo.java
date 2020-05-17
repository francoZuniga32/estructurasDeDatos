/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Nodo: estrcutura de datos que almacena un elemento
 * y un enlace a el siguiente nodo, en caso de tener un siguiente
 * nodo es un enlace que apunta a null.
 */
package lineales.dinamicas;

public class Nodo {
    private Object elemeto;
    private Nodo enlace;
    
    /**
     * constructor del nodo
     * @param elemento el elemento a almacenar en el nodo
     * @param enlace el enlace al siquiente nodo
     */
    public Nodo(Object elemento, Nodo enlace){
        this.elemeto = elemento;
        this.enlace = enlace;
    }
    
    //modificadores
    /***
     * cambiamos o seteamos el elemento de un nodo
     * @param elemento es el elemento a setear
     */
    public void setElemento(Object elemento){
        this.elemeto = elemento;
    }
    
    /***
     * cambiamos o seteamos el enlace de un nodo
     * @param enlace el enlace que vamos a setear
     */
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
    
    //observadores
    /***
     * retornamos el elemento almacenado por el nodo
     * @return 
     */
    public Object getElemento(){
        return this.elemeto;
    }
    
    /***
     * obtenemos el enlace que almacena el nodo
     * @return 
     */
    public Nodo getEnlace(){
        return this.enlace;
    }
}
