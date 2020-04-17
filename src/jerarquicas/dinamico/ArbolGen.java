package jerarquicas.dinamico;
import lineales.dinamicas.*;
/**
 * @author franco
 */
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
     * @param elemento
     * @param padre
     * @return boolean
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
     * @param elemento
     * @param padre
     * @param raiz
     * @return boolean
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
    public Lista ansestros(Object elemento){
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
    
    /***
     * listamos en preorden los elementos del arbol
     */
    public void listarPreorden(){
        if(this.raiz != null){
            preordenPaso(this.raiz);
        }
    }
    
    /***
     * paso para recorrer en preorden
     * @param raiz 
     */
    private void preordenPaso(NodoGen raiz){
        //vamos a mostrar el elemento de la raiz
        System.out.print(raiz.getElemento().toString()+",");
        
        //vamos a recorrer los hermanos usando el mismo algitmo
        NodoGen aux = raiz.getHijoIzquierdo();
        while(aux != null){
            //usamos preorden con el aux actual
            preordenPaso(aux);
            //pasamos al siguiente hermano
            aux = aux.getHermanoDerecho();
        }
    }
}
