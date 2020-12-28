/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import lineales.dinamicas.*;
/**
 *
 * @author franco
 */
public class Grafo {
    private NodoVertice inicio;
    
    public Grafo() {
    	this.inicio = null;
    }
    
    public boolean insertarVertice(Object element) {
    	boolean retorno = false;
    	NodoVertice aux = this.inicio;
    	if(aux == null) {
    		this.inicio = new NodoVertice(element, null, null);
    		retorno = true;
    	}else {
    		if(!aux.getElemento().equals(element)) {
    			boolean control = false;
    			while(aux.getSigVertice() != null && !aux.getSigVertice().getElemento().equals(element)) {
    				aux = aux.getSigVertice();
    			}
    			
    			if(aux.getSigVertice() == null) {
    				aux.setSigVertice(new NodoVertice(element, null, null));
    				retorno = true;
    			}
    		}
    	}
    	
    	return retorno;
    }
    
    private NodoVertice ubicarNodo(Object elem) {
    	NodoVertice aux = this.inicio;
    	while(aux != null && !aux.getElemento().equals(elem)) {
    		aux = aux.getSigVertice();
    	}
    	return aux;
    }
    
    public boolean eliminarVertice(Object  elemento){
    	boolean retorno = false;
    	NodoVertice aux = this.eliminarVerticeAux(elemento);

    	if(aux.getSigVertice() != null && aux.getSigVertice().getElemento().equals(elemento)){
    		aux.setSigVertice(aux.getSigVertice().getSigVertice());
    		retorno = true;
    	}
    	
    	return retorno;
    }
    
    private NodoVertice eliminarVerticeAux(Object elemento){
    	NodoVertice aux = this.inicio;
    	if(aux != null) {
    		while(aux.getSigVertice() != null && !aux.getSigVertice().getElemento().equals(elemento)) {
        		aux = aux.getSigVertice();
        	}
    	}
    	return aux;
    }
    
    public boolean existeVertice(Object elemento){
    	NodoVertice aux = this.ubicarNodo(elemento);
    	boolean retorno = false;
    	if(aux != null) {
    		retorno = true;
    	}
    	return retorno;
    }
    
    public boolean insertarArco(Object nodo, Object adyacente) {
    	boolean retorno = false;
    	NodoVertice Nodo = this.ubicarNodo(nodo);
    	NodoVertice Adyacente = this.ubicarNodo(adyacente);
    	
    	if(Nodo != null) {
    		NodoAdy aux = Nodo.getNodoAdy();
    		if(aux != null && !aux.getVertice().getElemento().equals(Adyacente.getElemento())) {
    			NodoAdy aux2 = aux.getSiguienteAdy();
    			while(aux2 != null && !aux2.getVertice().equals(Adyacente.getElemento())) {
    				aux2 = aux2.getSiguienteAdy();
    				aux = aux.getSiguienteAdy();
    			}
    			
    			if(aux2 == null) {
    				aux.setSiguienteAdy(new NodoAdy(Adyacente, null));
    				retorno = true;
    			}
    		}else if(Adyacente != null){
    			Nodo.setNodoAdy(new NodoAdy(Adyacente, null));
    			retorno = true;
    		}
    	}
    	return retorno;
    }
    
    public boolean eliminarArco(NodoVertice nodo, NodoVertice adyacente) {
    	NodoAdy aux = nodo.getNodoAdy();
    	boolean retorno = false;
    	
    	if(aux != null) {
    		while(!aux.getSiguienteAdy().getVertice().getElemento().equals(adyacente.getElemento())){
    			aux = aux.getSiguienteAdy();
    		}
    		
    		if(aux != null) {
    			aux.setSiguienteAdy(aux.getSiguienteAdy().getSiguienteAdy());
    			retorno = true;
    		}
    	}
    	return retorno;
    }
    
    public boolean existeArco(NodoVertice nodo, NodoVertice adyacente) {
    	NodoAdy aux = nodo.getNodoAdy();
    	boolean retorno = false;
    	while(aux != null || !aux.getVertice().getElemento().equals(adyacente.getElemento())) {
    		aux = aux.getSiguienteAdy();
    	}
    	
    	if(aux != null) {
    		retorno = true;
    	}
    	return retorno;
    }
    
    public boolean vacio() {
    	return this.inicio == null;
    }
    
    //busquedas y listados
    
    public boolean existeCamino(Object inicio, Object destino) {
    	boolean retorno = false;
    	//vamos a comprobar que inicio y destino existen
    	NodoVertice aux1 = this.ubicarNodo(inicio);
    	NodoVertice aux2 = this.ubicarNodo(destino);
    	if(aux1 != null && aux2 != null) {
    		Lista visitados = new Lista();
    		retorno = existeCaminoAux(aux1, aux2, visitados);
    	}
    	return retorno;
    }
    
    public boolean existeCaminoAux(NodoVertice inicio, NodoVertice destino, Lista visitados) {
    	boolean retorno = false;
    	
    	if(inicio != null) {
    		if(inicio.getElemento().equals(destino.getElemento())) {
    			retorno = true;
    		}else {
    			visitados.insertar(inicio.getElemento(), visitados.longitud() +1);
    			NodoAdy aux = inicio.getNodoAdy();
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
    
    public Lista caminoMasCorto(Object inicio, Object destino) {
    	NodoVertice nodoInicio = this.ubicarNodo(inicio);
    	NodoVertice nodoDestino = this.ubicarNodo(destino);
    	Lista camino = new Lista();
    	
    	if(nodoInicio != null && nodoDestino != null) {
    		camino = caminoMasCortoAux(nodoInicio, nodoDestino);
    	}
    	return camino;
    }
    
    private Lista caminoMasCortoAux(NodoVertice inicio, NodoVertice destino) {
    	Lista menorLista = new Lista();
    	if(inicio != null) {
    		if(inicio.getElemento().equals(destino.getElemento())) {
    			menorLista.insertar(destino.getElemento(), menorLista.longitud() +1);
    		}else {
    			NodoAdy aux = inicio.getNodoAdy();
    			if(aux != null) {
    				menorLista = caminoMasCorto(aux.getVertice(), destino);
    				while(aux != null) {
    					Lista menorListaAux = caminoMasCorto(aux.getVertice(), destino);
    					if(menorLista.longitud() > menorListaAux.longitud()) {
    						menorLista = menorListaAux;
    					}
    					aux = aux.getSiguienteAdy();
    				}
    			}
    			menorLista.insertar(inicio.getElemento(), menorLista.longitud()+1);
    		}
    	}
    	return menorLista;
    }
    
    public Lista caminoMasLargo(Object inicio, Object destino) {
    	NodoVertice nodoInicio = this.ubicarNodo(inicio);
    	NodoVertice nodoDestino = this.ubicarNodo(destino);
    	Lista camino = new Lista();
    	
    	if(nodoInicio != null && nodoDestino != null) {
    		camino = caminoMasLargoAux(nodoInicio, nodoDestino);
    	}
    	return camino;
    }
    
    private Lista caminoMasLargoAux(NodoVertice inicio, NodoVertice destino) {
    	Lista menorLista = new Lista();
    	if(inicio != null) {
    		if(inicio.getElemento().equals(destino.getElemento())) {
    			menorLista.insertar(inicio.getElemento(), menorLista.longitud() +1);
    		}else {
    			NodoAdy aux = inicio.getNodoAdy();
    			if(aux != null) {
    				menorLista = caminoMasLargoAux(aux.getVertice(), destino);
    				Lista menorListaAux = new Lista();
    				while(aux != null) {
    					menorListaAux = caminoMasLargoAux(aux.getVertice(), destino);
    					if(menorLista.longitud() < menorListaAux.longitud()) {
    						menorLista = menorListaAux;
    					}
    					aux = aux.getSiguienteAdy();
    				}
    				
    				menorLista.insertar(inicio.getElemento(), menorLista.longitud()+1);
    			}
    		}
    	}
    	return menorLista;
    }
    
    public String toString() {
    	NodoVertice aux = this.inicio;
    	String retorno = "";
    	
    	while(aux != null) {
    		NodoAdy aux2 = aux.getNodoAdy();
    		retorno += aux.getElemento().toString();
    		
    		while(aux2 != null) {
    			retorno += "-> "+aux2.getVertice().getElemento().toString();
    			aux2 = aux2.getSiguienteAdy();
    		}
    		retorno += "\n";
    		aux = aux.getSigVertice();
    	}
    	return retorno;
    }
}
