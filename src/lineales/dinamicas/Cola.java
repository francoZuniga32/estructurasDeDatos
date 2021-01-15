/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Cola version dinamica: estrcutura de datos tipo FIFO
 * (Fist In First Out) donde el primero en entrar es el primero
 * en salir denomindo frente de la cola
 */
package lineales.dinamicas;

public class Cola {
   private Nodo frente;
   private Nodo fin;
   
   public Cola(){
       this.frente = null;
       this.fin = null;
   }
   
   public boolean poner(Object elemento){
       //creamos un nuevo elemento
       Nodo nuevoNodo = new Nodo(elemento, null);
       if(this.frente == null){
           this.fin = nuevoNodo;
           this.frente = nuevoNodo;
       }else{
           //enlasamos el final anterior para que apunte al nuevo
            this.fin.setEnlace(nuevoNodo);
            //ahora el nuevo nood fin es el que creamos
            this.fin = nuevoNodo;
       }
       
       //retornamos true
       return true;
   }
   
   public boolean sacar(){
       boolean retorno = false;
       if(this.frente != null){
           //redefinimos el frente
           this.frente = this.frente.getEnlace();
           //luego el garbage colector elimina ese nodo
           retorno = true;
       }
       
       if(this.frente == null){
           this.fin = null;
       }
       
       return retorno;
   }
   
   public Object obtenerFrente(){
       Object retorno = null;
       if(this.frente != null){
           retorno = this.frente.getElemento();
       }
       return retorno;
   }
   
   public boolean esVacia(){
       return this.frente == null;
   }
   
    public void vaciar(){
       this.frente = null;
       this.fin = null;
   }
   
   public Cola clone2(){
       //creamos la cola clone
       Cola clon = new Cola();
       //obtenemos el tope de la cola actual
       Nodo auxiliarColaActual = this.frente;
       //le asignamos el mismo frente a la cola clon
       clon.frente = new Nodo(auxiliarColaActual.getElemento(), null);
       //obtenemos el frente de la cola clon
       Nodo auxiliarColaClon = clon.frente;
       //pasamos al sigueinte elemento enlasado de la cola actual
       auxiliarColaActual = auxiliarColaActual.getEnlace();
       
       //iteramos asta que el auxiliar de la cola actual sea null
       while(auxiliarColaActual != null){
           //enlasamos el siguiente elemento al frente
           auxiliarColaClon.setEnlace(new Nodo(auxiliarColaActual.getElemento(), null));
           //nos movemos a los elementos siguientes
           auxiliarColaActual = auxiliarColaActual.getEnlace();
           auxiliarColaClon = auxiliarColaClon.getEnlace();
       }
       clon.fin = auxiliarColaClon;
       return clon;
   }
   
   public Cola clone(){
       Cola clon = new Cola();
       //tomamos el Nodo del frente de cola actual
       Nodo aux = this.frente;
       //conamos dicho elemento en la cola actual
       clon.frente = new Nodo(aux.getElemento(), null);
       //hacemos el llamado recursivo mandamos el aux y la cola
       pasoClon(clon, aux, clon.frente);
       
       return clon;
   }
   
   private void pasoClon(Cola clon, Nodo aux, Nodo puntero){
       if(aux.getEnlace() == null){
           //asignamos el final al nodo auxiliar
           clon.fin = puntero;
       }else{
           aux = aux.getEnlace();
           Nodo nuevo = new Nodo(aux.getElemento(), null);
           puntero.setEnlace(nuevo);
           puntero = nuevo;
           pasoClon(clon, aux, puntero);
       }
   }
   
   public String toString(){
       String retorno = "[";
       //creamos un puntero auxiliar para movernos
       Nodo aux = this.frente;
       
       //nos movemos consultando si es null
       while(aux != null){
           //concatenamos el elemenento
           retorno = retorno + aux.getElemento().toString();
           if(aux.getEnlace() != null){
               retorno = retorno + ",";
           }
           //nos movemos al siguinte enlace
           aux = aux.getEnlace();
       }
       retorno = retorno + "]";
       return retorno;
   }
}
