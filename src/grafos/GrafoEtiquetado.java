package grafos;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class GrafoEtiquetado {
	private VerticeEtiquetado inicio;
    
    public GrafoEtiquetado() {
    	this.inicio = null;
    }
    
    public boolean insertarVertice(Object element) {
    	boolean retorno = false;
    	VerticeEtiquetado nodo = this.inicio;
    	if(nodo == null) {
    		this.inicio = new VerticeEtiquetado(element, null, null);
    		retorno = true;
    	}else {
			while(!retorno && nodo.getSigVertice() != null) {
				if(nodo.getElemento().equals(element))retorno = true;
				nodo = nodo.getSigVertice();
			}
			if(!retorno) {
				nodo.setSigVertice(new VerticeEtiquetado(element, null, null));
				retorno = true;
			}
    	}
    	
    	return retorno;
    }
    
    /**
     * eliminamos un vertice del grafo
     * @param elemento
     * @return true si se elimino, false caso contrario
     */
    public boolean eliminarVertice(Object  elemento){
    	boolean retorno = false;
    	VerticeEtiquetado nodo = this.inicio;
    	if(nodo != null) {
    		if(nodo.equals(elemento)) {
    			this.eliminarAdyacente(nodo, elemento);
    			this.inicio = nodo.getSigVertice();
    			retorno = true;
    		}else{
    			VerticeEtiquetado nodoSiguiente = nodo.getSigVertice();
    			while(nodo != null && !nodoSiguiente.getElemento().equals(elemento)) {
    				nodo = nodo.getSigVertice();
    				nodoSiguiente = nodoSiguiente.getSigVertice();
    			}
    			
    			if(nodoSiguiente != null) {
    				AdyacenteEtiquetado adyacentesNodoSiguiente = nodoSiguiente.getAdyacente();
    				while(adyacentesNodoSiguiente != null) {
    					this.eliminarAdyacente(adyacentesNodoSiguiente.getVertice(), elemento);
    					adyacentesNodoSiguiente = adyacentesNodoSiguiente.getSiguienteAdy();
    				}
    				nodo.setSigVertice(nodoSiguiente.getSigVertice());
    				retorno = true;
    			}
    		}
    	}
    	
    	return retorno;
    }
    
    public boolean insertarArco(Object elemA, Object elemB, Object etiqueta) {
    	boolean retorno = false;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		this.insertarAdyacente(verticeA, verticeB, etiqueta);
    		this.insertarAdyacente(verticeB, verticeA, etiqueta);
    		retorno = true;
    	}
    	
    	return retorno;
    }
    
    public boolean eliminarArco(Object elemA, Object elemB) {
    	boolean retorno = false;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		this.eliminarAdyacente(verticeA, verticeB);
    		this.eliminarAdyacente(verticeB, verticeA);
    		retorno = true;
    	}
    	
    	return retorno;
    }
    
    public Object etiquetaArco(Object elemA, Object elemB) {
    	Object retorno = null;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		retorno = this.getEtiquetaAdyacente(verticeA, verticeB);
    	}
    	
    	return retorno;
    }
    
    public boolean existeVertice(Object elem) {
    	boolean retorno = false;
    	VerticeEtiquetado aux = this.inicio;
    	while(aux != null && !retorno) {
    		if(aux.getElemento().equals(elem)) retorno = true;
    		aux = aux.getSigVertice();
    	}
    	return retorno;
    }
    
    public boolean existeArco(Object elemA, Object elemB) {
    	boolean retorno = null;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		AdyacenteEtiquetado aux = verticeA.getAdyacente();
    		while(aux != null && !retorno) {
    			if(aux.getVertice().equals(verticeB)) retorno = true;
    			aux = aux.getSiguienteAdy();
    		}
    	}
    	
    	return retorno;
    }
    
    public boolean existeCamino(Object elemA, Object elemB) {
    	Lista visitados = new Lista();
    	boolean retorno = false;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		retorno = existeCaminoAux(verticeA, verticeBm visitados);
    	}
    	
    	return retorno;
    }
    
    public boolean existeCaminoAux(VerticeEtiquetado nodo, VerticeEtiquetado adyacente, Lista visitados) {
    	boolean retorno = false;
    	visitados.insertar(nodo.getElemento(), 1);
    	if()
    	return retorno;
    }
    
    private Object getEtiquetaAdyacente(VerticeEtiquetado nodo, VerticeEtiquetado adyacente) {
    	Object retorno = null;
    	boolean control = true;
    	AdyacenteEtiquetado aux = nodo.getAdyacente();
    	while(aux != null && control) {
    		if(aux.getVertice().equals(adyacente)) {
    			retorno = aux.getEtiqueta();
    			control = false;
    		}
    		aux = aux.getSiguienteAdy();
    	}
    	return retorno;
    }
    
    private boolean insertarAdyacente(VerticeEtiquetado nodo, VerticeEtiquetado adyacente, Object etiqueta) {
    	boolean retorno = false;
    	if(nodo != null) {
    		AdyacenteEtiquetado aux = nodo.getAdyacente();
    		if(aux != null) {
    			while(aux.getSiguienteAdy() != null) {
    				aux = aux.getSiguienteAdy();
    			}
    			aux.setSiguienteAdy(new AdyacenteEtiquetado(adyacente, null, etiqueta));
    		}else {
    			nodo.setAdyacente(new AdyacenteEtiquetado(adyacente, null, etiqueta));
    		}
    		retorno = true;
    	}
    	return retorno;
    }
    
    private boolean eliminarAdyacente(VerticeEtiquetado nodo, Object elemento) {
    	boolean retorno = false;
    	if(nodo != null) {
    		AdyacenteEtiquetado adyacente = nodo.getAdyacente();
        	if(adyacente.getVertice().equals(elemento)) {
        		nodo.setAdyacente(adyacente.getSiguienteAdy());
        		retorno = true;
        	}else {
        		AdyacenteEtiquetado siguienteAdyacente = adyacente.getSiguienteAdy();
        		while(!siguienteAdyacente.getVertice().equals(elemento)) {
        			siguienteAdyacente = siguienteAdyacente.getSiguienteAdy();
        			adyacente = adyacente.getSiguienteAdy();
        		}
        		if(siguienteAdyacente != null) {
        			adyacente.setSiguienteAdy(siguienteAdyacente.getSiguienteAdy());
        			retorno = true;
        		}
        	}
    	}
    	return retorno;
    }
}
