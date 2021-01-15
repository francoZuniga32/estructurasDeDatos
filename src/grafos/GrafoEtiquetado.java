package grafos;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import java.util.HashMap;

public class GrafoEtiquetado {
	private VerticeEtiquetado inicio;
    
    public GrafoEtiquetado() {
    	this.inicio = null;
    }
    
    public boolean insertarVertice(Object element) {
    	boolean retorno = true;
    	VerticeEtiquetado nodo = this.inicio;
    	if(nodo == null) {
    		this.inicio = new VerticeEtiquetado(element, null, null);
    		retorno = true;
    	}else {
			while(retorno && nodo.getSigVertice() != null) {
				if(nodo.getElemento().equals(element))retorno = false;
				nodo = nodo.getSigVertice();
			}
			if(retorno) {
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
    	if(nodo.getElemento().equals(elemento)) {
    		this.inicio = nodo.getSigVertice();
    	}else {
    		VerticeEtiquetado sigNodo = nodo.getSigVertice();
    		boolean control = true;
    		while(sigNodo != null && control) {
    			if(sigNodo.getElemento().equals(elemento)) {
    				control = false;
    			}else {
    				sigNodo = sigNodo.getSigVertice();
    				nodo = nodo.getSigVertice();
    			}
    		}
    		if(!control) {
    			nodo.setSigVertice(sigNodo.getSigVertice());
    			retorno = true;
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
    		nodo = nodo.getSigVertice();
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
    
    public Object getEtiquetaArco(Object elemA, Object elemB) {
    	Object retorno = null;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		retorno = this.getEtiquetaAdyacenteAux(verticeA, verticeB);
    	}
    	
    	return retorno;
    }
    
    public boolean setEtiquetaArco(Object elemA, Object elemB, Object etiquetaNueva) {
    	boolean retorno = false;
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    	}
    	if(verticeA != null && verticeB != null) {
    		retorno = this.setEtiquetaAdyacenteAux(verticeA, verticeB, etiquetaNueva);
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
    	boolean retorno = false;
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
    		retorno = existeCaminoAux(verticeA, verticeB, visitados);
    	}
    	
    	return retorno;
    }
    
    public Lista caminoMasCorto(Object elemA, Object elemB) {
    	Lista camino = new Lista();
    	HashMap<String, Object> visitados = new HashMap<String, Object>();
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    		nodo = nodo.getSigVertice();
    	}
    	if(verticeA != null && verticeB != null ) {
    		camino = this.caminoMasCortoAux(verticeA, verticeB, visitados);
    	}
    	return camino;
    }
    
    public Lista caminoMasLargo(Object elemA, Object elemB) {
    	Lista camino = new Lista();
    	HashMap<String, Object> visitados = new HashMap<String, Object>();
    	VerticeEtiquetado nodo = this.inicio;
    	VerticeEtiquetado verticeA = null;
    	VerticeEtiquetado verticeB = null;
    	while(nodo != null) {
    		if(nodo.getElemento().equals(elemA)) verticeA = nodo;
    		if(nodo.getElemento().equals(elemB)) verticeB = nodo;
    		nodo = nodo.getSigVertice();
    	}
    	if(verticeA != null && verticeB != null ) {
    		camino = this.caminoMasLargoAux(verticeA, verticeB, visitados);
    	}
    	return camino;
    }
    
    public Lista listarProfundidad() {
    	Lista listados = new Lista();
    	HashMap<String, Object> visitados = new HashMap<String, Object>();
    	VerticeEtiquetado nodo = this.inicio;
    	while(nodo != null) {
    		if(visitados.get(nodo.getElemento().toString()) == null) this.listarProdundiadAux(nodo, listados, visitados);
    		nodo = nodo.getSigVertice();
    	}
    	return listados;
    }
    
    public Lista listarAnchura() {
    	Lista listados = new Lista();
    	HashMap<String, Object> visitados = new HashMap<String, Object>();
    	VerticeEtiquetado nodo = this.inicio;
    	while(nodo != null) {
    		if(visitados.get(nodo.getElemento().toString()) == null) this.listarAnchuraAux(nodo, listados, visitados);
    		nodo = nodo.getSigVertice();
    	}
    	return listados;
    }
    
    public GrafoEtiquetado clone() {
    	GrafoEtiquetado clone = new GrafoEtiquetado();
    	VerticeEtiquetado nodo = this.inicio;
    	HashMap<String, VerticeEtiquetado> nodos = new HashMap<String, VerticeEtiquetado>();
    	if(nodo != null) {
    		clone.inicio = new VerticeEtiquetado(nodo.getElemento(), null, null);
    		VerticeEtiquetado nodoClone = clone.inicio;
    		nodos.put(nodo.getElemento().toString(), nodoClone);
    		nodo = nodo.getSigVertice();
    		while(nodo != null) {
    			nodoClone.setSigVertice(new VerticeEtiquetado(nodo.getElemento(), null, null));
    			nodoClone = nodoClone.getSigVertice();
    			nodos.put(nodoClone.getElemento().toString(), nodoClone);
    			nodo = nodo.getSigVertice();
    		}
    		nodoClone = clone.inicio;
    		nodo = this.inicio;
    		while(nodoClone != null) {
    			AdyacenteEtiquetado adyacenteNodo = nodo.getAdyacente();
    			if(adyacenteNodo != null) {
    				nodoClone.setAdyacente(new AdyacenteEtiquetado(nodos.get(adyacenteNodo.getVertice().getElemento().toString()), null, adyacenteNodo.getEtiqueta()));
        			AdyacenteEtiquetado adyacenteClonado = nodoClone.getAdyacente();
        			adyacenteNodo = adyacenteNodo.getSiguienteAdy();
        			while(adyacenteNodo != null) {
        				adyacenteClonado.setSiguienteAdy(new AdyacenteEtiquetado(nodos.get(adyacenteNodo.getVertice().getElemento().toString()), null, adyacenteNodo.getEtiqueta()));
        				adyacenteNodo = adyacenteNodo.getSiguienteAdy();
        				adyacenteClonado = adyacenteClonado.getSiguienteAdy();
        			}
    			}
    			nodoClone = nodoClone.getSigVertice();
    			nodo = nodo.getSigVertice();
    		}
    	}
    	return clone;
    }
    
    public String toString() {
    	String retorno = "Grafo Vacio";
    	VerticeEtiquetado nodo = this.inicio;
    	if(nodo != null) {
    		retorno = "";
    		while(nodo != null) {
    			AdyacenteEtiquetado adyacente = nodo.getAdyacente();
    			retorno += nodo.getElemento().toString()+":";
    			while(adyacente != null) {
    				retorno += "->("+adyacente.getVertice().getElemento().toString()+","+adyacente.getEtiqueta().toString()+")";
    				adyacente = adyacente.getSiguienteAdy();
    			}
    			retorno += "\n";
    			nodo = nodo.getSigVertice();
    		}
    	}
    	return retorno;
    }
    
    private void listarAnchuraAux(VerticeEtiquetado nodo, Lista listados, HashMap<String, Object> visitados) {
    	Cola q = new Cola();
    	visitados.put(nodo.getElemento().toString(), inicio);
    	q.poner(nodo);
    	while(!q.esVacia()) {
    		VerticeEtiquetado aux = (VerticeEtiquetado)q.obtenerFrente();
    		listados.insertar(aux.getElemento(), listados.longitud() +1);
    		q.sacar();
    		AdyacenteEtiquetado adyacente = aux.getAdyacente();
    		while(adyacente != null) {
    			if(visitados.get(adyacente.getVertice().getElemento().toString()) == null) {
    				q.poner(adyacente.getVertice());
    				visitados.put(adyacente.getVertice().getElemento().toString(), adyacente.getVertice());
    			}
    			adyacente = adyacente.getSiguienteAdy();
    		}
    	}
    }
    
    private void listarProdundiadAux(VerticeEtiquetado nodo, Lista listados, HashMap<String, Object> visitados) {
    	visitados.put(nodo.getElemento().toString(), inicio);
    	listados.insertar(nodo.getElemento(), listados.longitud() + 1);
    	AdyacenteEtiquetado aux = nodo.getAdyacente();
    	while(aux != null) {
    		if(visitados.get(aux.getVertice().getElemento().toString()) == null) {
    			this.listarProdundiadAux(aux.getVertice(), listados, visitados);
    		}
    		aux = aux.getSiguienteAdy();
    	}
    }
    
    private Lista caminoMasCortoAux(VerticeEtiquetado inicio, VerticeEtiquetado destino, HashMap<String, Object> visitados) {
    	Lista retorno = new Lista();
    	visitados.put(inicio.getElemento().toString(), inicio);
    	if(inicio != null) {
    		if(inicio.equals(destino)) retorno.insertar(inicio.getElemento(), 1);
    		else {
    			AdyacenteEtiquetado adyacente = inicio.getAdyacente();
    			Lista listaAuxiliar = new Lista();
    			while(adyacente != null) {
    				if(visitados.get(adyacente.getVertice().getElemento().toString()) == null && retorno.longitud() == 0) {
    					retorno = this.caminoMasCortoAux(adyacente.getVertice(), destino, visitados);
    				}else if(visitados.get(adyacente.getVertice().getElemento().toString()) == null) {
    					listaAuxiliar = this.caminoMasCortoAux(adyacente.getVertice(), destino, visitados);
    					if(listaAuxiliar.longitud() <= retorno.longitud()) retorno = listaAuxiliar;
    				}
    				adyacente = adyacente.getSiguienteAdy();
    			}
    			if(retorno.longitud() > 0) retorno.insertar(inicio.getElemento(), 1);
    		}
    	}
    	visitados.remove(inicio.getElemento().toString());
    	return retorno;
    }
    
    private Lista caminoMasLargoAux(VerticeEtiquetado inicio, VerticeEtiquetado destino, HashMap<String, Object> visitados) {
    	Lista retorno = new Lista();
    	visitados.put(inicio.getElemento().toString(), inicio);
    	if(inicio != null) {
    		if(inicio.equals(destino)) retorno.insertar(inicio.getElemento(), 1);
    		else {
    			AdyacenteEtiquetado adyacente = inicio.getAdyacente();
    			Lista listaAuxiliar = new Lista();
    			while(adyacente != null) {
    				if(visitados.get(adyacente.getVertice().getElemento().toString()) == null && retorno.longitud() == 0) {
    					retorno = this.caminoMasLargoAux(adyacente.getVertice(), destino, visitados);
    				}else if(visitados.get(adyacente.getVertice().getElemento().toString()) == null) {
    					listaAuxiliar = this.caminoMasLargoAux(adyacente.getVertice(), destino, visitados);
    					if(listaAuxiliar.longitud() >= retorno.longitud()) retorno = listaAuxiliar;
    				}
    				adyacente = adyacente.getSiguienteAdy();
    			}
    			if(retorno.longitud() > 0) retorno.insertar(inicio.getElemento(), 1);
    		}
    	}
    	visitados.remove(inicio.getElemento().toString());
    	return retorno;
    }
    
    private boolean existeCaminoAux(VerticeEtiquetado inicio, VerticeEtiquetado destino, Lista visitados) {
    	boolean retorno = false;
    	
    	if(inicio != null) {
    		if(inicio.getElemento().equals(destino.getElemento())) {
    			retorno = true;
    		}else {
    			visitados.insertar(inicio.getElemento(), visitados.longitud() +1);
    			AdyacenteEtiquetado aux = inicio.getAdyacente();
    			while(!retorno && aux != null) {
    				if(visitados.localizar(aux.getVertice().getElemento()) < 0) {
    					retorno = existeCaminoAux(aux.getVertice(), destino, visitados);
    				}
    				aux = aux.getSiguienteAdy();
    			}
    		}
    	}
    	return retorno;
    }
    
    private Object getEtiquetaAdyacenteAux(VerticeEtiquetado nodo, VerticeEtiquetado adyacente) {
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
    
    private boolean setEtiquetaAdyacenteAux(VerticeEtiquetado nodo, VerticeEtiquetado adyacente, Object etiquetaNueva) {
    	boolean retorno = false;
    	AdyacenteEtiquetado aux = nodo.getAdyacente();
    	boolean control = true;
    	while(aux != null && control) {
    		if(aux.getVertice().equals(adyacente)) {
    			aux.setEtiqueta(etiquetaNueva);
    			control = false;
    			retorno = true;
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
    			boolean control = true;
    			while(aux.getSiguienteAdy() != null && control) {
    				if(aux.getVertice().equals(adyacente)) control = false;
    				aux = aux.getSiguienteAdy();
    			}
    			if(control) {
    				aux.setSiguienteAdy(new AdyacenteEtiquetado(adyacente, null, etiqueta));
    				retorno = true;
    			}
    		}else {
    			nodo.setAdyacente(new AdyacenteEtiquetado(adyacente, null, etiqueta));
    			retorno = true;
    		}
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
