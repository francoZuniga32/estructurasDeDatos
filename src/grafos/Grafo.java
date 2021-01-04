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
    private Vertice inicio;
    
    /**
     * Creamos un grafo vacio
     */
    public Grafo() {
    	this.inicio = null;
    }
    
    /**
     * Inseramos un objeto como un vertice del grafo
     * @param element que sera inserado como vertice
     * @return true si no existe el vertice, false caso contrario
     */
    public boolean insertarVertice(Object element) {
    	boolean retorno = false;
    	Vertice aux = this.inicio;
    	if(aux == null) {
    		this.inicio = new Vertice(element, null, null);
    		retorno = true;
    	}else {
    		if(!aux.getElemento().equals(element)) {
    			boolean control = false;
    			while(aux.getSigVertice() != null && !aux.getSigVertice().getElemento().equals(element)) {
    				aux = aux.getSigVertice();
    			}
    			
    			if(aux.getSigVertice() == null) {
    				aux.setSigVertice(new Vertice(element, null, null));
    				retorno = true;
    			}
    		}
    	}
    	
    	return retorno;
    }
    
    /**
     * 
     * @param elem
     * @return
     */
    private Vertice ubicarNodo(Object elem) {
    	Vertice aux = this.inicio;
    	while(aux != null && !aux.getElemento().equals(elem)) {
    		aux = aux.getSigVertice();
    	}
    	return aux;
    }
    
    public boolean eliminarVertice(Object  elemento){
    	boolean retorno = false;
    	Vertice aux = this.inicio;
    	if(aux != null) {
    		if(aux.getElemento().equals(elemento)) {
    			this.inicio = aux.getSigVertice();
    			
    			retorno = true;
    		}else{
    			Vertice aux2 = aux.getSigVertice();
    			while(aux2 != null && !aux2.getElemento().equals(elemento)) {
    				aux = aux.getSigVertice();
    				aux2 = aux2.getSigVertice();
    			}
    			
    			if(aux2 != null) {
    				aux.setSigVertice(aux2.getSigVertice());
    				retorno = true;
    			}
    		}
    	}
    	
    	if(retorno) {
    		//eliminamos los arcos donde este involucrado el nodo buscado
    		Vertice nodo = this.inicio;
    		while(nodo != null) {
    			Adyacente ady = nodo.getAdyacente();
    			if(ady != null) {
    				if(ady.getVertice().getElemento().equals(elemento)) {
        				nodo.setAdyacente(ady.getSiguienteAdy());
        			}else {
        				Adyacente ady2 = ady.getSiguienteAdy();
        				while(ady2 != null && !ady2.getVertice().getElemento().equals(elemento)) {
        					ady = ady.getSiguienteAdy();
        					ady2 = ady2.getSiguienteAdy();
        				}
        				
        				if(ady2 != null) {
        					ady.setSiguienteAdy(ady2.getSiguienteAdy());
        				}
        			}
    			}
    			
    			nodo = nodo.getSigVertice();
    		}
    	}
    	
    	return retorno;
    }
    
    private Vertice eliminarVerticeAux(Object elemento){
    	Vertice aux = this.inicio;
    	if(aux != null) {
    		while(aux.getSigVertice() != null && !aux.getSigVertice().getElemento().equals(elemento)) {
        		aux = aux.getSigVertice();
        	}
    	}
    	return aux;
    }
    
    public boolean existeVertice(Object elemento){
    	Vertice aux = this.ubicarNodo(elemento);
    	boolean retorno = false;
    	if(aux != null) {
    		retorno = true;
    	}
    	return retorno;
    }
    
    public boolean insertarArco(Object nodo, Object adyacente) {
    	boolean retorno = false;
    	Vertice Nodo = this.ubicarNodo(nodo);
    	Vertice Adyacente = this.ubicarNodo(adyacente);
    	
    	
    	if(Nodo != null && Adyacente != null) {
    		Adyacente auxNodo = Nodo.getAdyacente();
    		Adyacente auxAdyacente = Adyacente.getAdyacente();
    		
    		//recorremos los adyacentes de auxNodo buscando las repeticiones de adyacente
    		if(auxNodo != null && !auxNodo.getVertice().getElemento().equals(Adyacente.getElemento())) {
    			Adyacente auxNodo2 = auxNodo.getSiguienteAdy();
    			while(auxNodo2 != null && !auxNodo2.getVertice().getElemento().equals(Adyacente.getElemento())) {
    				auxNodo2 = auxNodo2.getSiguienteAdy();
    				auxNodo = auxNodo.getSiguienteAdy();
    			}
    			
    			if(auxNodo2 == null) {
    				auxNodo.setSiguienteAdy(new Adyacente(Adyacente, null));
    				retorno = true;
    			}
    		}else if(auxNodo == null){
    			Nodo.setAdyacente(new Adyacente(Adyacente, null));
    			retorno = true;
    		}
    		
    		if(auxAdyacente != null && !auxAdyacente.getVertice().getElemento().equals(Nodo.getElemento())) {
    			Adyacente auxAdyacente2 = auxAdyacente.getSiguienteAdy();
    			while(auxAdyacente2 != null && !auxAdyacente2.getVertice().getElemento().equals(Nodo.getElemento())) {
    				auxAdyacente2 = auxAdyacente2.getSiguienteAdy();
    				auxAdyacente = auxAdyacente.getSiguienteAdy();
    			}
    			
    			if(auxAdyacente2 == null) {
    				auxAdyacente.setSiguienteAdy(new Adyacente(Nodo, null));
    				retorno = true;
    			}
    		}else if(auxAdyacente == null){
    			Adyacente.setAdyacente(new Adyacente(Nodo, null));
    			retorno = true;
    		}
    	}
    	return retorno;
    }
    
    public boolean eliminarArco(Object nodoElem, Object adyacenteElem) {
    	boolean retorno = false;
    	Vertice nodo = this.ubicarNodo(nodoElem);
    	Vertice adyacente = this.ubicarNodo(adyacenteElem);
    	
    	if(nodo != null && adyacente != null) {
    		Adyacente adyacenteNodo = nodo.getAdyacente();
    		if(adyacenteNodo.getVertice().equals(adyacenteElem)) {
    			nodo.setAdyacente(adyacenteNodo.getSiguienteAdy());
    			retorno = true;
    		}else {
    			Adyacente adyacenteNodo2 = adyacenteNodo.getSiguienteAdy();
    			while(adyacenteNodo2 != null && !adyacenteNodo2.getVertice().equals(adyacenteElem)) {
    				adyacenteNodo2 = adyacenteNodo2.getSiguienteAdy();
    				adyacenteNodo = adyacenteNodo.getSiguienteAdy();
    			}
    			
    			if(adyacenteNodo2 != null) {
    				adyacenteNodo.setSiguienteAdy(adyacenteNodo2.getSiguienteAdy());
    				retorno = true;
    			}
    		}
        	
        	Adyacente adyacenteAdyacente = adyacente.getAdyacente();
        	if(adyacenteAdyacente.getVertice().equals(nodoElem)) {
    			adyacente.setAdyacente(adyacenteAdyacente.getSiguienteAdy());
    			retorno = true;
    		}else {
    			Adyacente adyacenteAdyacente2 = adyacenteNodo.getSiguienteAdy();
    			while(adyacenteAdyacente2 != null && !adyacenteAdyacente2.getVertice().equals(nodoElem)) {
    				adyacenteAdyacente2 = adyacenteAdyacente2.getSiguienteAdy();
    				adyacenteAdyacente = adyacenteAdyacente.getSiguienteAdy();
    			}
    			
    			if(adyacenteAdyacente2 != null) {
    				adyacenteAdyacente.setSiguienteAdy(adyacenteAdyacente2.getSiguienteAdy());
    				retorno = true;
    			}
    		}
    	}
    	
    	return retorno;
    }
    
    public boolean existeArco(Vertice nodo, Vertice adyacente) {
    	Adyacente aux = nodo.getAdyacente();
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
    	Vertice aux1 = this.ubicarNodo(inicio);
    	Vertice aux2 = this.ubicarNodo(destino);
    	if(aux1 != null && aux2 != null) {
    		Lista visitados = new Lista();
    		retorno = existeCaminoAux(aux1, aux2, visitados);
    	}
    	return retorno;
    }
    
    public boolean existeCaminoAux(Vertice inicio, Vertice destino, Lista visitados) {
    	boolean retorno = false;
    	
    	if(inicio != null) {
    		if(inicio.getElemento().equals(destino.getElemento())) {
    			retorno = true;
    		}else {
    			visitados.insertar(inicio.getElemento(), visitados.longitud() +1);
    			Adyacente aux = inicio.getAdyacente();
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
    	Lista camino = new Lista();
    	Lista visitados = new Lista();
    	if(this.inicio != null) {
    		camino = caminoMasCortoAux(ubicarNodo(inicio), ubicarNodo(destino), visitados);
    	}
    	return camino;
    }
    
    /**
     * Encontramos de manera recursiva el camino mas corto a un nodo dado
     * estos nodos ya existen, ya que se verifican en un paso anterior
     * @param inicio
     * @param destino
     * @param visitados
     * @return
     */
    private Lista caminoMasCortoAux(Vertice inicio, Vertice destino, Lista visitados) {
    	Lista retorno = new Lista();
    	
    	visitados.insertar(inicio.getElemento(), visitados.longitud()+1);
    	
    	if(!inicio.getElemento().equals(destino.getElemento())) {
    		//obtenemos el primer adyacente
    		Adyacente aux = inicio.getAdyacente();
    		//coprobamos que tenga adyacentes 
    		if(aux != null) {
    			//repetimos asta encontrar un adyacente que no este visitado
    			while(aux != null && visitados.localizar(aux.getVertice().getElemento()) != -1) {
    				aux = aux.getSiguienteAdy();
    			}
    			//si tenemos al menos uno que no este visitado y encontramos el camino mas corto desde este
    			if(aux != null) {
    				retorno = caminoMasCortoAux(aux.getVertice(), destino, visitados);
    				aux = aux.getSiguienteAdy();
    			}
    			//
    			while(aux!= null) {
        			if(visitados.localizar(aux.getVertice().getElemento()) == -1){
        				Lista listaAux = caminoMasCortoAux(aux.getVertice(), destino, visitados);
        				if(listaAux.longitud() <= retorno.longitud()) {
        					retorno = listaAux;
        				}
        			}
        			aux = aux.getSiguienteAdy();
        		}
    		}
    	}
    	retorno.insertar(inicio.getElemento(),1);
    	visitados.eliminar(visitados.localizar(inicio.getElemento()));
    	return retorno;
    }
    
    public Lista caminoMasLargo(Object inicio, Object destino) {
    	Lista camino = new Lista();
    	Lista visitados = new Lista();
    	if(this.inicio != null) {
    		camino = caminoMasLargoAux(ubicarNodo(inicio), ubicarNodo(destino), visitados);
    	}
    	return camino;
    }
    
    private Lista caminoMasLargoAux(Vertice inicio, Vertice destino, Lista visitados) {
    	Lista retorno = new Lista();
    	
    	visitados.insertar(inicio.getElemento(), visitados.longitud()+1);
    	
    	if(!inicio.getElemento().equals(destino.getElemento())) {
    		//obtenemos el primer adyacente
    		Adyacente aux = inicio.getAdyacente();
    		//coprobamos que tenga adyacentes 
    		if(aux != null) {
    			//repetimos asta encontrar un adyacente que no este visitado
    			while(aux != null && visitados.localizar(aux.getVertice().getElemento()) != -1) {
    				aux = aux.getSiguienteAdy();
    			}
    			//si tenemos al menos uno que no este visitado y encontramos el camino mas corto desde este
    			if(aux != null) {
    				retorno = caminoMasLargoAux(aux.getVertice(), destino, visitados);
    				aux = aux.getSiguienteAdy();
    			}
    			//
    			while(aux!= null) {
        			if(visitados.localizar(aux.getVertice().getElemento()) == -1){
        				Lista listaAux = caminoMasLargoAux(aux.getVertice(), destino, visitados);
        				if(listaAux.longitud() >= retorno.longitud()) {
        					retorno = listaAux;
        				}
        			}
        			aux = aux.getSiguienteAdy();
        		}
    		}
    	}
    	retorno.insertar(inicio.getElemento(),1);
    	visitados.eliminar(visitados.localizar(inicio.getElemento()));
    	return retorno;
    }
    
    public Lista listarEnProfundidad() {
    	Lista visitados = new Lista();
    	Vertice aux = this.inicio;
    	
    	while(aux != null) {
    		if(visitados.localizar(aux.getElemento()) != -1) {
    			listarEnProfundidadAux(aux, visitados);
    		}
    		aux = aux.getSigVertice();
    	}
    	return visitados;
    }
    
    private void listarEnProfundidadAux(Vertice nodo, Lista visitados) {
    	visitados.insertar(nodo.getElemento(), 1);
    	if(nodo != null) {
    		Adyacente aux = nodo.getAdyacente();
    		while(aux != null) {
    			if(visitados.localizar(nodo.getElemento()) != -1) {
    				listarEnProfundidadAux(aux.getVertice(), visitados);
    			}
    			aux = aux.getSiguienteAdy();
    		}
    	}
    }
    
    public Lista listarEnAnchura() {
    	Lista visitados = new Lista();
    	Vertice aux = this.inicio;
    	while(aux != null) {
    		if(visitados.localizar(aux.getElemento()) != -1) {
    			listarEnAnchuraAux(aux, visitados);
    		}
    		aux = aux.getSigVertice();
    	}
    	return visitados;
    }
    
    private void listarEnAnchuraAux(Vertice nodo, Lista visitados) {
    	Cola q = new Cola();
    	visitados.insertar(nodo.getElemento(), 1);
    	q.poner(nodo);
    	
    	while(!q.esVacia()) {
    		Vertice u = (Vertice)q.obtenerFrente();
    		Adyacente aux = u.getAdyacente();
    		q.sacar();
    		while(aux != null) {
    			if(visitados.localizar(aux.getVertice().getElemento()) != -1) {
    				visitados.insertar(aux.getVertice().getElemento(), 1);
    				q.poner(aux.getVertice());
    			}
    		}
    	}
    }
    
    public boolean esVacio() {
    	return this.inicio == null;
    }
    
    public Grafo clone() {
    	Grafo G2 = new Grafo();
    	//clonamos el inicio
    	if(!this.esVacio()) {
    		G2.inicio = new Vertice(this.inicio.getElemento(), null, null);
    		Vertice aux = this.inicio;
    		Vertice aux2 = G2.inicio;
    		
    		aux = aux.getSigVertice();
    		//clonamos cada vertice
    		while(aux != null) {
    			aux2.setSigVertice(new Vertice(aux.getElemento(), null, null));
    			aux2 = aux2.getSigVertice();
    			aux = aux.getSigVertice();
    		}
    		
    		//ahora conectamos los vertices
    		aux = this.inicio;
    		aux2 = G2.inicio;
    		while(aux != null) {
    			Adyacente adyacenteAux = aux.getAdyacente();
    			if(adyacenteAux != null) {
    				aux2.setAdyacente(new Adyacente(adyacenteAux.getVertice(), null));
    				Adyacente adyacenteAux2 = aux2.getAdyacente();
    				adyacenteAux = adyacenteAux.getSiguienteAdy();
    				while(adyacenteAux != null) {
    					adyacenteAux2.setSiguienteAdy(new Adyacente(adyacenteAux.getVertice(), null));
    					adyacenteAux2 = adyacenteAux2.getSiguienteAdy();
    					adyacenteAux = adyacenteAux.getSiguienteAdy();
    				}
    			}
    			aux = aux.getSigVertice();
    			aux2 = aux2.getSigVertice();
    		}
    	}
    	
    	return G2;
    }
    
    public String toString() {
    	Vertice aux = this.inicio;
    	String retorno = "";
    	
    	while(aux != null) {
    		Adyacente aux2 = aux.getAdyacente();
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
