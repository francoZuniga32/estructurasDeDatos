/***
 * @pan32 Franco Agustin Ojeda Zuñiga
 * TDA AVL : estrutura de datos para la cual balancemos un
 * arbol binario de binario para que cualquier operacion sobre el mismo
 * tenga una complegidad O(log(n))
 */
package conjuntitas.dinamico;
import lineales.dinamicas.*;

public class AVL {
    private NodoBB raiz;
    
    /***
     * constructor del arbol binario de busqueda
     */
    public AVL(){
        this.raiz = null;
    }
    
    /***
     * inserta un elemento en la pocision correspondiente
     * retirna falso si el elemento ya existe
     * @param elemento
     * @return 
     */
    public boolean insertar(Comparable elemento){
        boolean retorno = false;
            
            if(this.raiz == null){
                //en caso de no tener raiz la insertamos y retornamos true
                this.raiz = new NodoBB(elemento, null, null);
                retorno = true;
            }else{
                //en caso de tener raiz hacemos uso de un metodo recursivo
                retorno = insertarAux(this.raiz, elemento);
            }
        
        return retorno;
    }
    
    /***
     * metodo auxiliar de inseracion
     * recibe un subraiz para insertar
     * @param subRaiz
     * @param elemento
     * @return 
     */
    private boolean insertarAux(NodoBB subRaiz, Comparable elemento){
        //comparamos con el elemento actual
        boolean retorno;
        if(subRaiz.getElemento().equals(elemento)){
            retorno = false;
        }else{
            //en caso de que no sea igual a la raiz vamos a comprar con la raiz
            //comparamos con la raiz
            if(subRaiz.getElemento().compareTo(elemento) > 0){
                //en caso de que sea menor a la subraiz
                if(subRaiz.getIzquierdo() != null){
                    //en caso de tener un hijo izquierdo llamamos recursivamente
                    retorno = insertarAux(subRaiz.getIzquierdo(), elemento);
                }else{
                    //en caso de no tener un hijo izquierdo insertamos
                    subRaiz.setIzquierdo(new NodoBB(elemento, null, null));
                    retorno = true;
                }
            }else{
                //en caso de que sea mayor a la subraiz
                if(subRaiz.getDerecho()!= null){
                    //en caso de tener un hijo izquierdo llamamos recursivamente
                    retorno = insertarAux(subRaiz.getDerecho(), elemento);
                }else{
                    //en caso de no tener un hijo izquierdo insertamos
                    subRaiz.setDerecho(new NodoBB(elemento, null, null));
                    retorno = true;
                }
            }
        }
        return retorno;
    }
    
    /***
     * elimina un elemento del arbol
     * retorna falso si no logra eliminar dicho elemento (arbolVacio o 
     * elemento no existe
     * @param elemento
     * @return 
     */
    public boolean eliminar(Comparable elemento){
        boolean retorno = false;
        
        if(this.raiz != null){
            if(this.raiz.getElemento().equals(elemento)){
                //eliminamos la raiz por lo cual se refefine dicha raiz
                this.raiz = eliminarRaiz(this.raiz);
                retorno = true;
            }else{
               //en caso de que no sea la raiz recorremos los hijos en preorden
               retorno = eliminarAux(this.raiz, this.raiz.getIzquierdo(), elemento, 'I');
               if(!retorno){
                   retorno = eliminarAux(this.raiz, this.raiz.getDerecho(), elemento, 'D');
               }
            }
        }
        
        return retorno;
    }
    
    /***
     * metodo eliminar para el caso de raiz
     * @param raiz
     * @return 
     */
    private NodoBB eliminarRaiz(NodoBB raiz){
        NodoBB retorno = null;
        switch(condicion(raiz)){
            case 0:
                retorno = metodo1();
                break;
            case 1:
                retorno = metodo2(raiz);
                break;
            case 2:
                retorno = metodo3(raiz);
                break;
            default:
                break;
        }
        return retorno;
    }
    
    /***
     * metodo para poder eliminar un nodo que no es raiz del arbol
     * operaciones especificadas en el algoritmo
     * @param padre
     * @param subRaiz
     * @param elemento
     * @param hijo
     * @return 
     */
    private boolean eliminarAux(NodoBB padre, NodoBB subRaiz, Comparable elemento, char hijo){
        boolean retorno = false;
        if(subRaiz.getElemento().equals(elemento)){
            NodoBB remplazo = null;
            //evaluamos la condicion de dicho subarbol
            switch(condicion(subRaiz)){
                case 0:
                    remplazo = metodo1();
                    break;
                case 1:
                    remplazo = metodo2(subRaiz);
                    break;
                case 2:
                    remplazo = metodo3(subRaiz);
                    break;
                default:
                    break;
            }
            //en caso de que la raiz del subarbol sea el elemento se verifica alguna de las condiciones
            if(hijo == 'I'){
                padre.setIzquierdo(remplazo);
                retorno = true;
            }else{
                //el subarbol es el hd de el padre
                padre.setDerecho(remplazo);
                retorno = true;
            }
        }else{
            //recorremos en los hijos en preorden
            if(subRaiz.getIzquierdo() != null){
                retorno = eliminarAux(subRaiz, subRaiz.getIzquierdo(), elemento, 'I');
            }
            
            if(subRaiz.getDerecho() != null && !retorno){
                retorno = eliminarAux(subRaiz, subRaiz.getDerecho(), elemento, 'D');
            }
        }
        return retorno;
    }
    
    /***
     * retornamos la cantidad de hijos que pocce un nodo
     * es temetodo es para poder eliminar un nodo encontrado
     * @param nodo es el nodo que queremos evaluar
     * @return la cantidad de hijos que pocee o, 1, o 2
     */
    private int condicion(NodoBB nodo){
        int retorno = 0;
        //pasamos la raiz y evaluamos cuales de los metodos usar
        if(nodo.getIzquierdo() != null && nodo.getDerecho() != null){
            //tenemos los dos hijos por lo que tenemos que usar el metodo 3
            retorno = 2;
        }else{
            if(raiz.getIzquierdo() != null || raiz.getDerecho() != null){
                //tiene al menos un hijo usamos el metodo 2
                retorno = 1;
            }
        }
        //en caso de no pasar por alguno de los if esto significa que usa el metodo 1
        return retorno;
    }
    
    /***
     * metodo de eliminacion 1 e cual se aplica cuando no tiene hijos
     * @return null para signar al padre
     */
    private NodoBB metodo1(){
        return null;
    }
    
    /***
     * es el segundo metodo de eliminacion el cual se aplica
     * cuando el nodo tiene 2 hijos
     * @param nodo a eliminar
     * @return el hijo del nodo pasado por parametro
     */
    private NodoBB metodo2(NodoBB nodo){
        NodoBB retorno = null;
        if(nodo.getIzquierdo() != null){
            retorno = nodo.getIzquierdo();
        }else{
            retorno = nodo.getDerecho();
        }
        return retorno;
    }
    
    /***
     * el tercer metodo de eliminacion el cual intercabia el valor del nodo
     * actual por el mejor candiato eleguido (preferenteme con menos hijos)
     * de esta forma luego eliminamos el candidato eleguido
     * @param nodo a eliminar
     * @return el nuevo subarbol con el elemento ya eliminado
     */
    private NodoBB metodo3(NodoBB nodo){
        //obtenemos los candidatos de los cuales sacamos a los hijos 
        //el que tenga menor cantidad de hijos es el candidato elegido
        NodoBB retorno = null;
        boolean complatado = false;
        //obtenemos los candidatos
        NodoBB candidatoA = candidatoA(nodo.getIzquierdo());
        NodoBB candidatoB = candidatoB(nodo.getDerecho());
        //evaluamos cual tiene menos hijos
        int hijosCandidatoA = condicion(candidatoA);
        int hijosCandidatoB = condicion(candidatoB);
        //comparamos
        if(hijosCandidatoA <= hijosCandidatoB){
            //obtenemos el valor de este nodo y eliminamos por ese lado
            nodo.setElemento(candidatoA.getElemento());
            //eliminamos el elemento de candidato a por I
            complatado = eliminarAux(nodo, nodo.getIzquierdo(), candidatoA.getElemento(), 'I');
        }else{
            //obtenemos el valor de este nodo y eliminamos por ese lado
            nodo.setElemento(candidatoB.getElemento());
            //eliminamos el elemento de candidato a por D
            complatado = eliminarAux(nodo, nodo.getDerecho(), candidatoB.getElemento(), 'D');
        }
        if(complatado){
            retorno = nodo;
        }
        return retorno;
    }
    
    /***
     * es el candidato A, es el nodo mas a la derecha del
     * subarbol
     * @param raiz del subarbol pasado
     * @return el nodo mas a la derecha
     */
    private NodoBB candidatoA(NodoBB raiz){
        NodoBB aux = raiz;
        while(aux.getDerecho() != null){
            aux = aux.getDerecho();
        }
        return aux;
    }
    
    /***
     * es el candidato B, nodo mas a a la iquierda del subarbol actual
     * @param raiz del subarbol pasado
     * @return el nodo mas a la izquierda del subarbol
     */
    private NodoBB candidatoB(NodoBB raiz){
        NodoBB aux = raiz;
        while(aux.getIzquierdo() != null){
            aux = aux.getIzquierdo();
        }
        return aux;
    }
    
    //metodos de AVL
    /***
     * !!!plantilla para el modelo de balancear para introducior mañana
     * evaluamos si un subarbol esta balanceado
     * @param nodo es la subraiz de el subarbol a evaluar
     * @return balance true si esta balanceado
     *         false si no no esta
     */
    private boolean estaBalanceado(NodoBB nodo){
        //vamos a obtener el balance del nodo
        boolean balanceado = false;
        int balance = balance(nodo);
        //evaluamos si esta dentro del limite aceptado
        if(balance > -2 && balance < 2){
            balanceado = true;
        }
        return balanceado;
    }
    
    /***
     * retornamos el balance de un subarbol
     * @param nodo es la subraiz del subarbol que queremos sacar su balance
     * @return retornamos el balance del arbol: -1,0,1 esta balanceado
     *         2,-2 no lo esta hay que rotar!
     */
    private int balance(NodoBB nodo){
        //vamos a obtener el balance del arbol que se saca:
        //Altura(HI) - Altura(HD)
        return altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }
    
    /***
     * retornamos la altura de un nodo
     * -1 si el nodo es null, si es hoja retorna 1 y asi va sumando mientras
     * sube en el llamado recursivo
     * @param nodo subraiz del subarbol, que queremos saber su altura
     * @return retorna la altura de ese subarbol
     */
    private int altura(NodoBB nodo){
        //obtenemos la altura de un nodo
        int retorno = -1;
        if(nodo != null){
            //vamos a obtener la altura de mis hijos
            int retornoIzquierdo = altura(nodo.getIzquierdo());
            int retornoDerecho = altura(nodo.getDerecho());
            
            if(retornoIzquierdo >= retornoDerecho){
                retorno = retornoIzquierdo + 1;
            }else{
                retorno = retornoDerecho + 1;
            }
        }
        return retorno;
    }
    
    //rotaciones
    /***
     * Este metodo rota al subarbol hacia de izquierda, esto es para mantener
     * el balance del arbol cuando esta caido a la derecha
     * @param padre es la raiz para la cual el arbol esta caido a la derecha
     * @param hijoDerecho es el hacia donde esta caido
     * @return la nueva subraiz que sera el subarbol balanceado
     */
    private NodoBB simpleIzquierda(NodoBB padre, NodoBB hijoDerecho){
        //guardamos el hijo derecho de hijoDerecho en una variable temporal
        NodoBB temp = hijoDerecho.getIzquierdo();
        //padre pasa a ser hijo de hijo derecho
        hijoDerecho.setIzquierdo(padre);
        //guardamos temp como hijo derecho de padre
        padre.setDerecho(temp);
        return hijoDerecho;
    }
    
    /***
     * evaluamos si un elemento esta en el arbol
     * @param elemento buscado
     * @return si esta true, sino false
     */
    public boolean pertenece(Comparable elemento){
        boolean retorno = false;
        if(this.raiz != null){
            retorno = perteneceAux(this.raiz, elemento);
        }
        return retorno;
    }
    
    /***
     * metodo auxiliar para su busqueda
     * @param subRaiz del subarbol
     * @param elemento que estamos buscando
     * @return si esta true (condion de corte de la busqueda) sino false
     */
    private boolean perteneceAux(NodoBB subRaiz, Comparable elemento){
        boolean retorno = false;
        //si el nodo no es null
        if(subRaiz != null){
            //si el elemento es ta en esta nodo retorno true
            if(subRaiz.getElemento().equals(elemento)){
                retorno = true;
            }else{
                //sino busco si es menor a el nodo por HI
                if(subRaiz.getElemento().compareTo(elemento) > 0){
                    retorno = perteneceAux(subRaiz.getIzquierdo(), elemento);
                }else{
                    //sino busco por el ID
                    retorno = perteneceAux(subRaiz.getDerecho(), elemento);
                }
            }
        }
        return retorno;
    }
    
    /***
     * evelua si un arbol esta vacio
     * @return true si esta vacio, sino false
     */
    public boolean esVacio(){
        boolean retorno = true;
        if(this.raiz != null){
            retorno = false;
        }
        return retorno;
    }
    
    /***
     * una lista de los elementos almacenados en preorden (osea estan ordenados)
     * @return Lista de elementos ordenados
     */
    public Lista lista(){
        Lista retorno = new Lista();
        
        if(this.raiz != null){
            listaAux(this.raiz, retorno);
        }
        
        return retorno;
    }
    
    /***
     * metodo auxiliar para listar los elementos del arbol en orden
     * @param subRaiz del subarbol
     * @param retorno es la referencia a la lista para insetar
     */
    private void listaAux(NodoBB subRaiz, Lista retorno){
        //recorremos en preorden
        if(subRaiz != null){
            listaAux(subRaiz.getIzquierdo(), retorno);
            retorno.insertar(subRaiz.getElemento(), retorno.longitud() + 1);
            listaAux(subRaiz.getDerecho(), retorno);
        }
    }
    
    /***
     * es el metodo que genera una lista de los elementos entre un rango
     * @param minimo elemento 
     * @param maximo elemento
     * @return una Lista con los elementos en dicho rango
     */
    public Lista listarRango(Comparable minimo, Comparable maximo){
        //vamos a buscar en el arbol los elementos en el rango
        Lista listaRango = new Lista();
        
        if(minimo.compareTo(maximo) <= 0){
            //en caso de que minimos sea menor o igual a maximo
            //se ejecuta el algoritmo de comparacion
            if(this.raiz != null){
                listaRangoAuz(this.raiz, listaRango, minimo, maximo);
            }
        }
        
        return listaRango;
    }

    /***
     * Vamos a ver si los subarboles estan entre dichos valores min y max
     * e insertamos en preorden (HI, raiz, HD)
     * @param subRaiz
     * @param retorno
     * @param minimo
     * @param maximo 
     */
    private void listaRangoAuz(NodoBB subRaiz, Lista retorno, Comparable minimo, Comparable maximo){
        //si la subraiz esta entre los maximos minimos
        if(subRaiz.getElemento().compareTo(minimo) >= 0 && subRaiz.getElemento().compareTo(maximo) <= 0){
            //hacemos lo mismo con nuetro HI que es menor al subarbol
            if(subRaiz.getIzquierdo() != null){
                //tenemos un HI por lo cual vamos a recorrerlo de la misma forma
                listaRangoAuz(subRaiz.getIzquierdo(), retorno, minimo, maximo);
            }
            //insertamos el elemento actual en la lista
            retorno.insertar(subRaiz.getElemento(), retorno.longitud() + 1);
            //hacemos los mismo con el HD que es el mayor del subarbol actual
            if(subRaiz.getDerecho() != null){
                //tenemos un HD y vamos a recorrerlo
                listaRangoAuz(subRaiz.getDerecho(), retorno, minimo, maximo);
            }
        }else{
            //en caso de que no este entre el rango
            if(subRaiz.getDerecho() != null && subRaiz.getElemento().compareTo(minimo) < 0){
                //en caso de que el subarbol sea manor al valor minimo busco por el lado derecho
                listaRangoAuz(subRaiz.getDerecho(), retorno, minimo, maximo);
            }else{
                //en caso de se sea mayor al maximo buscamos por el lado izquierdo
                if(subRaiz.getIzquierdo() != null && subRaiz.getElemento().compareTo(maximo) > 0){
                    listaRangoAuz(subRaiz.getIzquierdo(), retorno, minimo, maximo);
                }
            }
        }
    }
    
    /***
     * retornamos el minimo elemento del arbol
     * @return el minimo elemento del arbol
     */
    public Comparable minimoElem(){
        Comparable minimo = null;
        if(this.raiz != null){
            minimo = candidatoB(this.raiz).getElemento();
        }
        return minimo;
    }
    
    /***
     * retornamos el maximo elemento del arbol
     * @return elemento maximo del arbol
     */
    public Comparable maximoElem(){
        Comparable minimo = null;
        if(this.raiz != null){
            minimo = candidatoA(this.raiz).getElemento();
        }
        return minimo;
    }
    
    /***
     * retornamos un arbol clon del actual
     * @return 
     */
    public AVL clone(){
        AVL clon = new AVL();
        
        if(this.raiz != null){
            clon.raiz = new NodoBB(this.raiz.getElemento(), null, null);
            //hacemos el llamado recursivo para ir armando el arbol
            cloneAux(this.raiz, clon.raiz);
        }
        
        return clon;
    }
    
    /***
     * metodo auxiliar para poder clonar
     * @param subRaiz
     * @param subRaizClone 
     */
    private void cloneAux(NodoBB subRaiz, NodoBB subRaizClone){
        if(subRaiz != null){
            if(subRaiz.getIzquierdo() != null){
                //tenemos HI lo clonamos y los llamamos con ese
                subRaizClone.setIzquierdo(new NodoBB(subRaiz.getIzquierdo().getElemento(), null, null));
                //hacemos el llamado recursivo
                cloneAux(subRaiz.getIzquierdo(), subRaizClone.getIzquierdo());
            }
            
            if(subRaiz.getDerecho() != null){
                //tenemos HD lo clonamos y los llamamos con ese
                subRaizClone.setDerecho(new NodoBB(subRaiz.getDerecho().getElemento(), null, null));
                //hacemos el llamado recursivo
                cloneAux(subRaiz.getDerecho(), subRaizClone.getDerecho());
            }
        }
    }
    
    /**
     * vaciamos el arbol
     */
    public void vaciar(){
        //se eliminan por perdida de referencia
        this.raiz = null;
    }
    
    /***
     * mostramos la estructura de los datos en el arbol
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
    private String auxToString(NodoBB raiz){
        String retorno = "";
        if(raiz != null){
            retorno = raiz.getElemento().toString()+":";
            
            NodoBB izquierdo = raiz.getIzquierdo();
            NodoBB derecho = raiz.getDerecho();
            
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
}
