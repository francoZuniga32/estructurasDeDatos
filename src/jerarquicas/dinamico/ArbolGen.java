/**
 * @pan32 Franco Agustin Ojeda Zuñiga
 * 2020, Estructuras de Datos
 * TDA Arbol generico: estrucutura de datos que almacena elementos 
 * que pueden tener mas de dos hijos no como el binario
 * mas informacion: https://es.wikipedia.org/wiki/%C3%81rbol_(inform%C3%A1tica)
 */
package jerarquicas.dinamico;
import lineales.dinamicas.*;

public class ArbolGen {
    public NodoGen raiz;
    
    /***
     * constructor del arbol generico
     */
    public ArbolGen(){
        this.raiz = null;
    }
    
    /***
     * insertamos un elemento en el arbol especificando el padre
     * devuelve true si lo logro, y si no existe el padre retorna false
     * @param elemento es el elemento a almacenar en el nodo
     * @param padre es el padre al cual le vamos a asignar dicho elemento como hijo
     * @return false si el padre no existe
     *         true en caso contrario
     */
    public boolean insertar(Object elemento, Object padre){
        //vamos a evaluar si el arbol no esta vacio
        boolean retorno = false;
        
        if(this.raiz != null){
            //vamos a evaluar que sea el elemento padre buscado
            retorno = insertarPaso(elemento, padre, this.raiz);
        }else{
            this.raiz = new NodoGen(elemento, null, null);
            retorno = true;
        }
        return retorno;
    }
    
    /***
     * es el paso recursivo para poder insertar un elemento en el arbol
     * @param elemento es el elemento a insertar
     * @param padre es el padre al cual le vamos a asignar dicho elemento
     * @param raiz es el nodo raiz del subarbol actual
     * @return false en caso de que no encuntre el padre (llege a un hoja)
     *         
     */
    private boolean insertarPaso(Object elemento, Object padre, NodoGen raiz){
        //vamos a comparar el padre con la raiz
        boolean retorno = false;
        
        //en caso de que elemento raiz se el padre que buscamos 
        if(raiz.getElemento().equals(padre)){
            //vamos a comparar que este tenga hi
            if(raiz.getHijoIzquierdo() != null){
                NodoGen aux = raiz.getHijoIzquierdo();
                while(aux.getHermanoDerecho() != null){
                    aux = aux.getHermanoDerecho();
                }
                //le asignamos un nuevo hermano al elemento
                aux.setHermanoDerecho(new NodoGen(elemento, null, null));
                retorno = true;
            }else{
                //en caso de no teber HI le setemos el elemento como uno
                raiz.setHijoIzquierdo(new NodoGen(elemento, null, null));
                retorno = true;
            }
        }else{
            //en caso de no ser el padre nos modemos en preorden por el arbol
            NodoGen aux = raiz.getHijoIzquierdo();

            while(aux != null && !retorno){
                retorno = retorno || insertarPaso(elemento, padre, aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }
    
    /***
     * evaluamos si un elemento pertenece al arbol, osea si esta en el
     * @param elemento
     * @return boolean
     */
    public boolean pertenece(Object elemento){
        boolean retorno = false;
        
        if(this.raiz != null){
            retorno = pertenecePaso(elemento, this.raiz);
        }
        
        return retorno;
    }
    
    /***
     * es el paso recursivo para averiguar su pertenece al arbol un elemento dado
     * @param elemento
     * @param raiz
     * @return 
     */
    private boolean pertenecePaso(Object elemento, NodoGen raiz){
        boolean retorno = false;
        
        if(raiz.getElemento().equals(elemento)){
            retorno = true;
        }else{
            NodoGen aux = raiz.getHijoIzquierdo();
            while(aux != null && !retorno){
                retorno = retorno || pertenecePaso(elemento, aux);
                aux = aux.getHermanoDerecho();
            }
        }
        
        return retorno;
    }
    
    /***
     * retornamos una lista con el camino a un elemento del arbol, caso de arbol vacio, o el elemento no este retornamos una lista vacia
     * @param elemento
     * @return 
     */
    public Lista ancentros(Object elemento){
        Lista retorno = new Lista();
        if(this.raiz != null){
            ansestrosPaso(this.raiz, elemento, retorno);
        }
        return retorno;
    }
    
    /***
     * paso recursivo por el cual vamos a crear una lista con los elemento del camino a un nodo
     * @param raiz
     * @param elemento
     * @param lista
     * @return 
     */
    private boolean ansestrosPaso(NodoGen raiz, Object elemento, Lista lista){
        //vamos a recorrer el arbol en preorden asta encontrar el elemento
        boolean retorno = false;
        if(raiz != null){
            
            if(raiz.getElemento().equals(elemento)){
                lista.insertar(raiz.getElemento(), 1);
                retorno = true;
            }else{
                NodoGen aux = raiz.getHijoIzquierdo();

                while(aux != null && !retorno){
                    retorno = retorno || ansestrosPaso(aux, elemento, lista);
                    aux = aux.getHermanoDerecho();
                }
                if(retorno){
                    lista.insertar(raiz.getElemento(), 1);
                }
            }
        }
        
        return retorno;
    }
    
    /**
     * metodo por el cual vamos a evaluar si el arbol esta vacio
     * @return 
     */
    public boolean esVacio(){
        boolean retorno = false;
        if(this.raiz == null){
            retorno = true;
        }
        return retorno;
    }
    
    public int altura(){
        int retorno = -1;
        if(this.raiz != null){
            retorno = alturaPaso(this.raiz);
        }
        return retorno;
    }
    
    private int alturaPaso(NodoGen raiz){
        int retorno = 0;
        
        //si la raiz no es null evaluamos
        if(raiz.getHijoIzquierdo() != null){
            //vamos a obtener el resultado de el hijo mas a la izquirda
            NodoGen aux = raiz.getHijoIzquierdo();
            int retornoHijos = alturaPaso(aux);
            aux = aux.getHermanoDerecho();
            //mientras halla hijos repite
            while(aux != null){
                int retornoLlamado = alturaPaso(aux);
                if(retornoHijos <= retornoLlamado){
                    retornoHijos = retornoLlamado;
                }
                aux = aux.getHermanoDerecho();
            }
            
            retorno = retornoHijos + 1;
        }
        
        return retorno;
    }
    
    public int nivel(Object elemento){
        int retorno = -1;
        
        if(this.raiz != null){
            retorno = retorno + nivelPaso(this.raiz, elemento);
        }
        
        return retorno;
    }
    
    
    public int nivelPaso(NodoGen raiz, Object elemento){
        int retorno = 0;
        
        if(raiz != null){
            //si el elemento esta en el punto retornamos 1
            if(raiz.getElemento().equals(elemento)){
                retorno = 1;
            }else{
                //busamos por los hijos
                NodoGen aux = raiz.getHijoIzquierdo();
                int retornoHijos;
                
                while(aux != null && retorno == 0){
                    retornoHijos = nivelPaso(aux, elemento);
                    if(retornoHijos > 0){
                        retorno = retornoHijos + 1;
                    }
                    aux = aux.getHermanoDerecho();
                }
            }
        }
        
        return retorno;
    }
    
    public Object padre(Object elemento){
        Object retorno = null;
        if(this.raiz != null){
            if(!this.raiz.getElemento().equals(elemento)){
                retorno = padrePaso(this.raiz, elemento);   
            }
        }
        return retorno;
    }
    
    private Object padrePaso(NodoGen raiz, Object elemento){
        //
        Object retorno = null;
        if(raiz != null){
            NodoGen aux = raiz.getHijoIzquierdo();
            boolean control = true;
            while(control && aux != null){
                if(aux.getElemento().equals(elemento)){
                    retorno = raiz.getElemento();
                    control = false;
                }else{
                    Object retornoHijo = padrePaso(aux, elemento);
                    if(retornoHijo != null){
                        retorno = retornoHijo;
                        control = false;
                    }
                }
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }
    
    /***
     * listamos en preorden los elementos del arbol
     */
    public Lista listarPreorden(){
        Lista retorno = new Lista();
        if(this.raiz != null){
            preordenPaso(this.raiz, retorno);
        }
        return retorno;
    }
    
    /***
     * paso para recorrer en preorden
     * @param raiz 
     */
    private void preordenPaso(NodoGen raiz, Lista retorno){
        //vamos a mostrar el elemento de la raiz
        retorno.insertar(raiz.getElemento(), retorno.longitud()+1);
        
        //vamos a recorrer los hermanos usando el mismo algitmo
        NodoGen aux = raiz.getHijoIzquierdo();
        while(aux != null){
            //usamos preorden con el aux actual
            preordenPaso(aux, retorno);
            //pasamos al siguiente hermano
            aux = aux.getHermanoDerecho();
        }
    }
    
    public Lista listarInorden(){
        Lista inorden = new Lista();
        if(this.raiz != null){
            inordenPaso(this.raiz, inorden);
        }
        return inorden;
    }
    
    private void inordenPaso(NodoGen raiz, Lista inorden){
        //si la subraiz es no es null
        if(raiz != null){
            //tomamos el hijo izquierdo de raiz
            NodoGen aux = raiz.getHijoIzquierdo();
            if(aux != null){
                inordenPaso(aux, inorden);
                aux = aux.getHermanoDerecho();
            }
            inorden.insertar(raiz.getElemento(), inorden.longitud() +1);
            while(aux != null){
                inordenPaso(aux, inorden);
                aux = aux.getHermanoDerecho();
            }
        }
    }
    
    public Lista listarPosorden(){
        Lista posorden = new Lista();
        if(this.raiz != null){
            posordenPaso(this.raiz, posorden);
        }
        return posorden;
    }
    
    private void posordenPaso(NodoGen raiz, Lista posorden){
        if(raiz != null){
            NodoGen aux = raiz.getHijoIzquierdo();
            while(aux != null){
                posordenPaso(aux, posorden);
                aux = aux.getHermanoDerecho();
            }
            
            posorden.insertar(raiz.getElemento(), posorden.longitud() +1);
        }
    }
    
    public Lista listarNiveles(){
        //vamos a usar una cola para iterar
        Lista retorno = new Lista();
        Cola q = new Cola();
        q.poner(this.raiz);
        
        while(!q.esVacia()){
            NodoGen aux = (NodoGen) q.obtenerFrente();
            q.sacar();
            retorno.insertar(aux.getElemento(), retorno.longitud() + 1);
            aux = aux.getHijoIzquierdo();
            while(aux != null){
                q.poner(aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }
    
    public ArbolGen clone(){
        ArbolGen clon = new ArbolGen();
        //verificamos si existe la raiz del arbol
        if(this.raiz != null){
            //clonenamos la raiz del alrbol
            clon.raiz = new NodoGen(this.raiz.getElemento(), null, null);
            //relizamos el llamado recursivo
            cloneAux(this.raiz, clon.raiz);
        }
        return clon;
    }
    
    private void cloneAux(NodoGen raiz, NodoGen raizClone){
        //vamos a evaluar que el nodo raiz no se anull
        if(raiz != null){
            //en este caso vamos a clonar el elemento de los hijos de raiz
            NodoGen aux = raiz.getHijoIzquierdo();
            
            if(aux != null){
                //creamos el hijos izquierdo de el raizclone
                raizClone.setHijoIzquierdo(new NodoGen(aux.getElemento(), null, null));
                //nos pocicionamos en el HI de el nodoClon
                NodoGen auxClone = raizClone.getHijoIzquierdo();
                while(aux.getHermanoDerecho() != null){
                    //clonamos los nodos hijos de raizClone
                    //nos movemos al siguiente hijo
                    aux = aux.getHermanoDerecho();
                    auxClone.setHermanoDerecho(new NodoGen(aux.getElemento(), null, null));
                    auxClone = auxClone.getHermanoDerecho();
                }

                //vamos a llamar con los demas hijos
                aux = raiz.getHijoIzquierdo();
                auxClone = raizClone.getHijoIzquierdo();
                while(aux != null){
                    cloneAux(aux, auxClone);
                    aux = aux.getHermanoDerecho();
                    auxClone = auxClone.getHermanoDerecho();
                }
            }
        }
    }
    
    public void vaciar(){
        this.raiz = null;
    }
    
    public String toString(){
        return toStringAux(this.raiz);
    }
    
    private String toStringAux(NodoGen raiz){
        String retorno = "";
        if(raiz != null){
            //visitamos el nodo n
            retorno += raiz.getElemento().toString()+"->";
            NodoGen aux = raiz.getHijoIzquierdo();
            while(aux != null){
                retorno += aux.getElemento().toString()+",";
                aux = aux.getHermanoDerecho();
            }
            
            //comenzamos el recorrido por los hijos de la subraiz
            aux = raiz.getHijoIzquierdo();
            while(aux != null){
                retorno += "\n"+toStringAux(aux);
                aux = aux.getHermanoDerecho();
            }
        }
        return retorno;
    }
}
