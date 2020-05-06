package conjuntitas.dinamico;
import lineales.dinamicas.*;

/**
 *
 * @author franco
 */
public class ABB {
    private NodoBB raiz;
    
    public ABB(){
        this.raiz = null;
    }
    
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
                if(subRaiz.getNodoIzquierdo() != null){
                    //en caso de tener un hijo izquierdo llamamos recursivamente
                    retorno = insertarAux(subRaiz.getNodoIzquierdo(), elemento);
                }else{
                    //en caso de no tener un hijo izquierdo insertamos
                    subRaiz.setNodoIzquierdo(new NodoBB(elemento, null, null));
                    retorno = true;
                }
            }else{
                //en caso de que sea mayor a la subraiz
                if(subRaiz.getNodoDerecho()!= null){
                    //en caso de tener un hijo izquierdo llamamos recursivamente
                    retorno = insertarAux(subRaiz.getNodoDerecho(), elemento);
                }else{
                    //en caso de no tener un hijo izquierdo insertamos
                    subRaiz.setNodoDerecho(new NodoBB(elemento, null, null));
                    retorno = true;
                }
            }
        }
        return retorno;
    }
    
    public boolean eliminar(Comparable elemento){
        boolean retorno = false;
        
        if(this.raiz != null){
            if(this.raiz.getElemento().equals(elemento)){
                retorno = eliminarMetodos(this.raiz, this.raiz);
            }else{
                retorno = eliminarAux(this.raiz, elemento);
            }
        }
        
        return retorno;
    }
    
    private boolean eliminarAux(NodoBB subRaiz, Comparable elemento){
        //evaluamos cuales de las condiciones tiene que cumplir dicho elemento
        //evaluamos con el HI
        boolean retorno = false;
        
        if(subRaiz.getNodoIzquierdo() != null){
            if(subRaiz.getNodoIzquierdo().getElemento().equals(elemento)){
                //en caso de que el elemento sea el HI del nodo
                retorno = eliminarMetodos(subRaiz, subRaiz.getNodoIzquierdo());
            }else{
                retorno = eliminarAux(subRaiz.getNodoIzquierdo(), elemento);
            }
        }
        
        if(subRaiz.getNodoDerecho() != null && !retorno){
            if(subRaiz.getNodoDerecho().getElemento().equals(elemento)){
                //en caso de que el elemento sea el HD del nodo
                retorno = eliminarMetodos(subRaiz, subRaiz.getNodoDerecho()); 
            }else{
                retorno = eliminarAux(subRaiz.getNodoDerecho(), elemento);
            }
        }
        
        return retorno;
    }
    
    
    private boolean eliminarMetodos(NodoBB padre,NodoBB nodoAtual){
        //realizamos el metodo de eliminacion metodos de eliminacion
        boolean retorno = false;
        //caso no tiene hijos es hoja
        if(nodoAtual.getNodoIzquierdo() == null && nodoAtual.getNodoDerecho() == null){
            if(padre.getNodoIzquierdo().equals(nodoAtual)){
                padre.setNodoIzquierdo(null);
                retorno = true;
            }
            if(padre.getNodoIzquierdo().equals(nodoAtual) && !retorno){
                padre.setNodoDerecho(null);
                retorno = false;
            }
        }else{
            //caso 3 tiene un solo hijo
            if(nodoAtual.getNodoIzquierdo() != null && nodoAtual.getNodoDerecho() != null){
                
            }else{
                retorno = eliminarMetodo2(padre, nodoAtual);
            }
        }
        
        return retorno;
    }
    
    private boolean eliminarMetodo2(NodoBB padre, NodoBB nodoActual){
        //evaluamos cual de los hijos es el que tenemos que intercambiar
        boolean retorno = false;
        
        if(nodoActual.getNodoIzquierdo() != null && nodoActual.getNodoDerecho() == null){
            //en caso de que el nodo 
            if(padre.getNodoIzquierdo().equals(nodoActual)){
                padre.setNodoIzquierdo(nodoActual.getNodoIzquierdo());
                retorno = true;
            }else{
                padre.setNodoDerecho(nodoActual.getNodoIzquierdo());
                retorno = true;
            }
        }
        
        if(!retorno && nodoActual.getNodoDerecho() != null && nodoActual.getNodoIzquierdo() == null){
            //en caso de que el nodo 
            if(padre.getNodoIzquierdo().equals(nodoActual)){
                padre.setNodoIzquierdo(nodoActual.getNodoDerecho());
                retorno = true;
            }else{
                padre.setNodoDerecho(nodoActual.getNodoDerecho());
                retorno = true;
            }
        }
        
        return retorno;
    }
    
    private boolean eliminarMetodo3(NodoBB padre, NodoBB nodoActual){
        boolean retorno = false;
        //vamos a obtener el menor candidato a remplazar por el lado izquierdo
        Comparable candidatoA = obtenerCandidatoA(nodoActual.getNodoIzquierdo());
        //luego vamos a crer un nodo nuevo
        NodoBB nuevo = new NodoBB(candidatoA, nodoActual.getNodoIzquierdo(), nodoActual.getNodoDerecho());
        //vamos a remplazar el hijo de padre
        if(padre.getNodoIzquierdo().equals(nodoActual)){
            padre.setNodoIzquierdo(nuevo);
        }else{
            padre.setNodoDerecho(nuevo);
        }
        //vamos a liminar el nodo comparable
        retorno = eliminarAux(nuevo, candidatoA);
        return retorno;
    }
    
    private Comparable obtenerCandidatoA(NodoBB nodo){
        Comparable retorno;
        if(nodo.getNodoDerecho() != null){
            retorno = obtenerCandidatoA(nodo.getNodoDerecho());
        }else{
            retorno = nodo.getElemento();
        }
        return retorno;
    }
    
    public Lista lista(){
        Lista retorno = new Lista();
        
        if(this.raiz != null){
            listaAux(this.raiz, retorno);
        }
        
        return retorno;
    }
    
    private void listaAux(NodoBB subRaiz, Lista retorno){
        //recorremos en preorden
        if(subRaiz != null){
            listaAux(subRaiz.getNodoIzquierdo(), retorno);
            retorno.insertar(subRaiz.getElemento(), retorno.longitud() + 1);
            listaAux(subRaiz.getNodoDerecho(), retorno);
        }
    }
}
