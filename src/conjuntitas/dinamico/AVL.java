/***
 * @pan32 Franco Agustin Ojeda Zuñiga
 * TDA AVL : estrutura de datos para la cual balancemos un
 * arbol binario de binario para que cualquier operacion sobre el mismo
 * tenga una complegidad O(log(n))
 */
package conjuntitas.dinamico;
import lineales.dinamicas.*;

public class AVL {
    private NodoAVL raiz;
    
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
            this.raiz = new NodoAVL(elemento, null, null);
            retorno = true;
        }else{
            if(!this.raiz.getElemento().equals(elemento)){
                if(this.raiz.getElemento().compareTo(elemento) > 0){
                    //vamos a relizar la insercion por la izquierda de la raiz
                    retorno = insertarAuxInsertarHijos(this.raiz, raiz.getIzquierdo(), 'I', elemento);
                }else{
                    //vamos a realizar la insercion por la derecha de la raiz
                    retorno = insertarAuxInsertarHijos(this.raiz, raiz.getDerecho(), 'D', elemento);
                }
            }
        }
        
        if(retorno){
            this.raiz.recalcularAltura();
            balancearRaiz(this.raiz);
        }
        //
        return retorno;
    }
    
    /***
     * metodo auxiliar de inseracion
     * recibe un subraiz para insertar
     * @param subRaiz
     * @param elemento
     * @return 
     */
    private boolean insertarAuxInsertarHijos(NodoAVL padre, NodoAVL subRaiz, char hijo, Comparable elemento){
        //comparamos con el elemento actual
        boolean retorno = false;
        
        if(subRaiz != null){
            if(!subRaiz.getElemento().equals(elemento)){
                if(subRaiz.getElemento().compareTo(elemento) > 0){
                    //nos movemos a la izquierda de la subRaiz
                    retorno = insertarAuxInsertarHijos(subRaiz, subRaiz.getIzquierdo(), 'I', elemento);
                }else{
                    //nos movemos a la derecha de la subRaiz
                    retorno = insertarAuxInsertarHijos(subRaiz, subRaiz.getDerecho(), 'D', elemento);
                }
            }
        }else{
            //creamos y enlazamos en nodo
            NodoAVL nuevoHIjo = new NodoAVL(elemento, null, null);
            nuevoHIjo.recalcularAltura();
            subRaiz = nuevoHIjo;
            //enlazamos el padre con el hijo
            if(hijo == 'I') {
                padre.setIzquierdo(nuevoHIjo);
            }else{
                padre.setDerecho(nuevoHIjo);
            }
            
            retorno = true;
        }
        
        if(retorno){
            subRaiz.recalcularAltura();
            balancear(padre, subRaiz, hijo);
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
        
        if(retorno){
            //balanceamos
            this.raiz.recalcularAltura();
            balancearRaiz(this.raiz);
        }
        
        return retorno;
    }
    
    /***
     * metodo eliminar para el caso de raiz
     * @param raiz
     * @return 
     */
    private NodoAVL eliminarRaiz(NodoAVL raiz){
        NodoAVL retorno = null;
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
        balance(raiz);
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
    private boolean eliminarAux(NodoAVL padre, NodoAVL subRaiz, Comparable elemento, char hijo){
        boolean retorno = false;
        if(subRaiz.getElemento().equals(elemento)){
            NodoAVL remplazo = null;
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
            subRaiz = remplazo;
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
        //balancemos
        if(retorno){
            subRaiz.recalcularAltura();
            balancear(padre, subRaiz, hijo);
        }
        return retorno;
    }
    
    /***
     * retornamos la cantidad de hijos que pocce un nodo
     * es temetodo es para poder eliminar un nodo encontrado
     * @param nodo es el nodo que queremos evaluar
     * @return la cantidad de hijos que pocee o, 1, o 2
     */
    private int condicion(NodoAVL nodo){
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
    private NodoAVL metodo1(){
        return null;
    }
    
    /***
     * es el segundo metodo de eliminacion el cual se aplica
     * cuando el nodo tiene 2 hijos
     * @param nodo a eliminar
     * @return el hijo del nodo pasado por parametro
     */
    private NodoAVL metodo2(NodoAVL nodo){
        NodoAVL retorno = null;
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
    private NodoAVL metodo3(NodoAVL nodo){
        //obtenemos los candidatos de los cuales sacamos a los hijos 
        //el que tenga menor cantidad de hijos es el candidato elegido
        NodoAVL retorno = null;
        boolean complatado = false;
        //obtenemos los candidatos
        NodoAVL candidatoA = candidatoA(nodo.getIzquierdo());
        NodoAVL candidatoB = candidatoB(nodo.getDerecho());
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
    private NodoAVL candidatoA(NodoAVL raiz){
        NodoAVL aux = raiz;
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
    private NodoAVL candidatoB(NodoAVL raiz){
        NodoAVL aux = raiz;
        while(aux.getIzquierdo() != null){
            aux = aux.getIzquierdo();
        }
        return aux;
    }
    
    //metodos de AVL
    
    /***
     * 
     * @param nodo
     * @return 
     */
    public boolean balancear(NodoAVL padre, NodoAVL nodo, char hijo){
        //evaluamos el balande de nodo
        int balance = balance(nodo);
        
        if(balance < -1 || balance > 1){
            //hay que balancear el nodo
            NodoAVL balanceado = aplicarRotaciones(nodo);
            if(hijo == 'I'){
                padre.setIzquierdo(balanceado);
            }else{
                padre.setDerecho(balanceado);
            }
            padre.recalcularAltura();
        }
        
        return true;
    }
    
    /**
     * caso especial de balanceo del nodo raiz
     * @param nodo
     * @return 
     */
    public boolean balancearRaiz(NodoAVL nodo){
        //evaluamos el balande de nodo
        int balance = balance(nodo);
        NodoAVL balanceado = null;
        if(balance < -1 || balance > 1){
            //hay que balancear el nodo
            this.raiz = aplicarRotaciones(nodo);
        }
        this.raiz.recalcularAltura();
        return true;
    }
    
    
    /***
     * retornamos el balance de un nodo
     * @param nodo del cual queremos sacar el balance
     * @return el balance del nodo dado
     */
    public int balance(NodoAVL nodo){
        int alturaIzquierdo = -1;
        int alturaDerecho = -1;
        
        if(nodo.getIzquierdo() != null){
            alturaIzquierdo = nodo.getIzquierdo().getAltura();
        }
        
        if(nodo.getDerecho() != null){
            alturaDerecho = nodo.getDerecho().getAltura();
        }
        
        return alturaIzquierdo - alturaDerecho;
    }
    
    /***
     * aplicamos las rotacion necesaria para ese nodo en caso de tener que aplicarla
     * @param nodo al cual hay que aplicar una rotacion
     * @param balanceNodo es el balance del nodo a apĺicar la rotacion
     */
    private NodoAVL aplicarRotaciones(NodoAVL nodo){
        NodoAVL balanceado = null;
        int balanceNodo = balance(nodo);
        if(balanceNodo == -2 && nodo.getDerecho() != null){
            //esta caido hacia la derecha
            int balanceHijoDerecho = balance(nodo.getDerecho());
            if(balanceHijoDerecho == -1){
                //giro simple a la izquierda
                balanceado = giroIzquierda(nodo);
            }else{
                //giro doble izquierda-derecha
                balanceado = dobleDerechaIzquierda(nodo);
            }
        }else{
            if(balanceNodo == 2 && nodo.getIzquierdo()!= null){
                //esta caido hacia la izquierda
                int balanceHijoIzquierda = balance(nodo.getIzquierdo());
                if(balanceHijoIzquierda == 1){
                    //giro a la derecha simple
                    balanceado = giroDerecha(nodo);
                }else{
                    //giro doble derecha-izquierda
                    balanceado = dobleIzquierdaDerecha(nodo);
                }
            }
        }
        return balanceado;
    }
    
    //rotaciones
    
    /***
     * tenemos que el subarbol esta caido hacia la derecha (-2), y su hijo 
     * derecho esta caido hacia la izquierda (1)
     * @param padre es nodo raiz del subarbol desbalanceado hacia la derecha
     */
    private NodoAVL dobleDerechaIzquierda(NodoAVL padre){
        //hacemos girar hacia la derecha el hijo
        NodoAVL hijoDerecha = giroDerecha(padre.getDerecho());
        padre.setDerecho(hijoDerecha);
        //hacemos girar padre a la izquierda
        NodoAVL nuevoPadre = giroIzquierda(padre);
        //recalculamos alturas 
        padre.recalcularAltura();
        hijoDerecha.recalcularAltura();
        return nuevoPadre;
    }
    
    /***
     * tenemos que el subarbol esta caido hacia la izquierda (2), y su hijo 
     * izquierdo esta caido hacia la derecha (-1)
     * @param padre es nodo raiz del subarbol desbalanceado hacia la izquierda
     */
    private NodoAVL dobleIzquierdaDerecha(NodoAVL padre){
        System.out.println("Aplicamos un giro izquierda-derecha");
        //hacemos rotar hacia la izquierda al hijo izquierdo de padre
        NodoAVL hijoIzqueirdo = giroIzquierda(padre.getIzquierdo());
        System.out.println("El nuevo hijo Izquierdo "+hijoIzqueirdo.getElemento().toString());
        padre.setIzquierdo(hijoIzqueirdo);
        //hacemos rotar hacia la derecha a el padre
        NodoAVL nuevoPadre = giroDerecha(padre);
        System.out.println("El nuevo padre: "+nuevoPadre.getElemento().toString());
        
        //recalculasmos alturas
        padre.recalcularAltura();
        hijoIzqueirdo.recalcularAltura();
        return nuevoPadre;
    }
    
    /***
     * En esta rotacion lo que pasa es que se intercambian los enlaces de padre
     * e hijo derecho Esto es el HI del HD de padre pasa a ser el HD de padre
     * y el HI de el HD de padre pasa a aser padre
     * @param padre
     * @return 
     */
    private NodoAVL giroDerecha(NodoAVL padre){
        NodoAVL hijoIzquierdo = padre.getIzquierdo();
        //guardamos el hijo derecho de hijoIzquierdo en un tmp
        NodoAVL temp = null;
        if(hijoIzquierdo.getDerecho()!= null){
            temp = hijoIzquierdo.getDerecho();
        }
        //hacemos que hijo tenga como derecho a su padre
        hijoIzquierdo.setDerecho(padre);
        //hacemos que tmp sea hijo izquierdo de padre
        padre.setIzquierdo(temp);
        
        padre.recalcularAltura();
        hijoIzquierdo.recalcularAltura();
        return hijoIzquierdo;
    }
    
    /***
     * Este metodo retorna rota el subarbol hacia la derecha, esto para mantener 
     * el balance del arbol, esto se aplica cuando el arbol esta caido hacia 
     * la izquierda (balance 2) 
     * @param padre es la raiz del subarbol a rotar
     * @param hijoIzquierdo es el hijo hacia donde esta caido el subarbol que 
     *                      tambien esta un poco caido hacia la izquierda 
     *                      (balance 1)
     * @return el nuevo sobarbol balanceado
     */
    private NodoAVL giroIzquierda(NodoAVL padre){
        //tomamos al hijo derecho de padre
        NodoAVL hijoDerecho = padre.getDerecho();
        //tomamos el hijo izquiedo de nuetro hijo derecho
        NodoAVL temp = null;
        if(hijoDerecho.getIzquierdo() != null){
            temp = hijoDerecho.getIzquierdo();
        }
        
        //hacemos que padre sea hijo derecho de su hijo derecho
        hijoDerecho.setIzquierdo(padre);
        //hacemos que el hijo derecho de padre sea el HI de su hijo derecho
        padre.setDerecho(temp);
        
        //recalculamos las alturas
        padre.recalcularAltura();
        hijoDerecho.recalcularAltura();
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
    private boolean perteneceAux(NodoAVL subRaiz, Comparable elemento){
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
    
    public Object recuperar(Comparable elemento) {
    	Object retorno = null;
    	if(this.raiz != null){
            retorno = perteneceAux(this.raiz, elemento);
        }
    	return retorno;
    }
    
    private Object recuperarAux(NodoAVL subRaiz, Comparable elemento){
    	Object retorno = null;
        //si el nodo no es null
        if(subRaiz != null){
            //si el elemento es ta en esta nodo retorno true
            if(subRaiz.getElemento().equals(elemento)){
                retorno = subRaiz.getClass();
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
    private void listaAux(NodoAVL subRaiz, Lista retorno){
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
    private void listaRangoAuz(NodoAVL subRaiz, Lista retorno, Comparable minimo, Comparable maximo){
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
            clon.raiz = new NodoAVL(this.raiz.getElemento(), null, null);
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
    private void cloneAux(NodoAVL subRaiz, NodoAVL subRaizClone){
        if(subRaiz != null){
            if(subRaiz.getIzquierdo() != null){
                //tenemos HI lo clonamos y los llamamos con ese
                subRaizClone.setIzquierdo(new NodoAVL(subRaiz.getIzquierdo().getElemento(), null, null));
                //hacemos el llamado recursivo
                cloneAux(subRaiz.getIzquierdo(), subRaizClone.getIzquierdo());
            }
            
            if(subRaiz.getDerecho() != null){
                //tenemos HD lo clonamos y los llamamos con ese
                subRaizClone.setDerecho(new NodoAVL(subRaiz.getDerecho().getElemento(), null, null));
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
    private String auxToString(NodoAVL raiz){
        String retorno = "";
        if(raiz != null){
            retorno = raiz.getElemento().toString()+" Al: "+raiz.getAltura()+" :";
            
            NodoAVL izquierdo = raiz.getIzquierdo();
            NodoAVL derecho = raiz.getDerecho();
            
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
