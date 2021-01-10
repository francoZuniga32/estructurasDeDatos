package grafos;
import lineales.dinamicas.*;

public class Digrafo {
private Vertice inicio;
    
    /**
     * Creamos un grafo vacio
     */
    public Digrafo() {
    	this.inicio = null;
    }
    
    /**
     * Inseramos un objeto como un vertice del grafo
     * @param element que sera inserado como vertice
     * @return true si no existe el vertice, false caso contrario
     */
    public boolean insertarVertice(Object element) {
    	boolean retorno = false;
    	Vertice nodo = this.inicio;
    	if(nodo == null) {
    		this.inicio = new Vertice(element, null, null);
    		retorno = true;
    	}else {
    		if(!nodo.getElemento().equals(element)) {
    			while(nodo.getSigVertice() != null && !nodo.getSigVertice().getElemento().equals(element)) {
    				nodo = nodo.getSigVertice();
    			}
    			if(nodo.getSigVertice() == null) {
    				nodo.setSigVertice(new Vertice(element, null, null));
    				retorno = true;
    			}
    		}
    	}
    	
    	return retorno;
    }
    
    /**
     * ubicamos un nodo, si el nodo no existe retorna null
     * @param elem
     * @return Vertice
     */
    private Vertice ubicarNodo(Object elem) {
    	Vertice aux = this.inicio;
    	while(aux != null && !aux.getElemento().equals(elem)) {
    		aux = aux.getSigVertice();
    	}
    	return aux;
    }
    
    /**
     * eliminamos un vertice del grafo
     * @param elemento
     * @return true si se elimino, false caso contrario
     */
    public boolean eliminarVertice(Object  elemento){
    	boolean retorno = false;
    	Vertice nodo = this.inicio;
    	if(nodo != null) {
    		if(nodo.getElemento().equals(elemento)) {
    			this.inicio = nodo.getSigVertice();
    			retorno = true;
    		}else{
    			Vertice sigNodo = nodo.getSigVertice();
    			while(sigNodo != null && !sigNodo.getElemento().equals(elemento)) {
    				nodo = nodo.getSigVertice();
    				sigNodo = sigNodo.getSigVertice();
    			}
    			
    			if(sigNodo != null) {
    				nodo.setSigVertice(sigNodo.getSigVertice());
    				retorno = true;
    			}
    		}
    	}
    	
    	if(retorno) {
    		//eliminamos los arcos donde este involucrado el nodo buscado
    		nodo = this.inicio;
    		while(nodo != null) {
    			Adyacente adyacente = nodo.getAdyacente();
    			if(adyacente != null) {
    				if(adyacente.getVertice().getElemento().equals(elemento)) {
    					nodo.setAdyacente(adyacente.getSiguienteAdy());
    				}
    				Adyacente sigAdyacente = adyacente.getSiguienteAdy();
					while(sigAdyacente != null) {
						if(sigAdyacente.getVertice().getElemento().equals(elemento)) {
							adyacente.setSiguienteAdy(sigAdyacente.getSiguienteAdy());
						}
						adyacente = adyacente.getSiguienteAdy();
						sigAdyacente = sigAdyacente.getSiguienteAdy();
					}
    			}
    			nodo = nodo.getSigVertice();
    		}
    	}
    	
    	return retorno;
    }
    
    /**
     * Evaluamos la existencia de un vertice
     * @param elemento
     * @return true si existe, false caso contrario
     */
    public boolean existeVertice(Object elemento){
    	return this.ubicarNodo(elemento) != null;
    }
    
    /**
     * Insertamos un arco especificando los nodos involucrados
     * @param nodo
     * @param adyacente
     * @return true si se logro crear el arco, false caso contrario
     */
    public boolean insertarArco(Object verticeA, Object verticeB) {
    	boolean retorno = false;
    	Vertice nodoA = this.ubicarNodo(verticeA);
    	Vertice nodoB = this.ubicarNodo(verticeB);
    	
    	if(nodoA != null && nodoB != null) {
    		Adyacente adyacenteA = nodoA.getAdyacente();	
    		if(adyacenteA != null) {
    			while(adyacenteA.getSiguienteAdy() != null) {
    				adyacenteA = adyacenteA.getSiguienteAdy();
    			}
    			adyacenteA.setSiguienteAdy(new Adyacente(nodoB, null));
    			retorno = true;
    		}else {
    			nodoA.setAdyacente(new Adyacente(nodoB, null));
    			retorno = true;
    		}
    	}
    	return retorno;
    }
    
    /**
     * Eliminamos un arco especificando los nodos 
     * @param nodoElem
     * @param adyacenteElem
     * @return true en caso de poder eliminarlo, false en caso contrario
     */
    public boolean eliminarArco(Object verticeA, Object verticeB) {
    	boolean retorno = false;
    	Vertice nodoA = this.ubicarNodo(verticeA);
    	Vertice nodoB = this.ubicarNodo(verticeB);
    	
    	if(nodoA != null && nodoB != null) {
    		//eliminamos el adyacente de nodo
    		Adyacente adyacenteA = nodoA.getAdyacente();
    		Adyacente adyacenteB = nodoB.getAdyacente();
    		
    		if(adyacenteA != null) {
    			if(adyacenteA.getVertice().getElemento().equals(verticeB)) {
        			nodoA.setAdyacente(adyacenteA.getSiguienteAdy());
        			retorno = true;
        		}else {
        			Adyacente sigAdyacenteA = adyacenteA.getSiguienteAdy();
        			while(sigAdyacenteA != null && !sigAdyacenteA.getVertice().getElemento().equals(verticeB)) {
        				sigAdyacenteA = sigAdyacenteA.getSiguienteAdy();
        				adyacenteA = adyacenteA.getSiguienteAdy();
        			}
        			
        			if(sigAdyacenteA != null) {
        				adyacenteA.setSiguienteAdy(sigAdyacenteA.getSiguienteAdy());
        				retorno = true;
        			}
        		}
    		}
        	
    		//aliminamos el nodo de adyacente
        	if(adyacenteB != null && !verticeA.equals(verticeB)) {
        		if(adyacenteB.getVertice().getElemento().equals(verticeA)) {
        			nodoB.setAdyacente(adyacenteB.getSiguienteAdy());
        			retorno = true;
        		}else {
        			Adyacente sigAdyacenteB = adyacenteB.getSiguienteAdy();
        			while(sigAdyacenteB != null && !sigAdyacenteB.getVertice().getElemento().equals(verticeA)) {
        				sigAdyacenteB = sigAdyacenteB.getSiguienteAdy();
        				adyacenteB = adyacenteB.getSiguienteAdy();
        			}
        			
        			if(sigAdyacenteB != null) {
        				adyacenteB.setSiguienteAdy(sigAdyacenteB.getSiguienteAdy());
        				retorno = true;
        			}
        		}
        	}
    	}
    	
    	return retorno;
    }
    
    /**
     * evaluamos si existe un arco.
     * @param nodo
     * @param adyacente
     * @return true si existe dicho arco, false caso contrario
     */
    public boolean existeArco(Object inicio, Object destino) {
    	Vertice nodoInicio = this.ubicarNodo(inicio);
    	Vertice nodoDestino = this.ubicarNodo(destino);
    	boolean retorno = false;
    	
    	if(nodoInicio != null && nodoDestino != null) {
    		Adyacente aux = nodoInicio.getAdyacente();
    		while(aux != null && !retorno) {
    			if(aux.getVertice().getElemento().equals(destino)) {
    				retorno = true;
    			}else {
    				aux = aux.getSiguienteAdy();
    			}
    		}
    	}
    	return retorno;
    }
    
    public boolean vacio() {
    	return this.inicio == null;
    }
    
    //busquedas y listados
    
    /**
     * evaluamos si existe un camino entre dos nodos
     * @param inicio
     * @param destino
     * @return true si existe camino, false caso contrario
     */
    public boolean existeCamino(Object inicio, Object destino) {
    	boolean retorno = false;
    	Vertice nodoInicio = this.ubicarNodo(inicio);
    	Vertice nodoDestino = this.ubicarNodo(destino);
    	Lista visitados = new Lista();
    	
    	if(nodoInicio != null && nodoDestino != null) {
    		retorno = existeCaminoAux(nodoInicio, nodoDestino, visitados);
    	}
    	return retorno;
    }
    
    /**
     * Metodo auxiliar para verificar existencia de camino
     * @param inicio
     * @param destino
     * @param visitados
     * @return true en caso de existir el camino, false caso contrario
     */
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
    
    /**
     * Listamos una Lista listando los vertices que indican el camino mas Corto
     * @param inicio
     * @param destino
     * @return Lista de vertices con el camino
     */
    public Lista caminoMasCorto(Object inicio, Object destino) {
    	Lista camino = new Lista();
    	Lista visitados = new Lista();
    	Lista visitadosExisteCamino = new Lista();
    	Vertice nodoInicio = this.ubicarNodo(inicio);
    	Vertice nodoDestino = this.ubicarNodo(destino);
    	
    	if(nodoInicio != null && nodoDestino != null && this.existeCaminoAux(nodoInicio, nodoDestino, visitadosExisteCamino) ) {
    		camino = caminoMasCortoAux(nodoInicio, nodoDestino, visitados);
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
    
    
    /**
     * Retornamos una lista con el camino mas largo entre dos nodos
     * @param inicio
     * @param destino
     * @return Lista de Vertices de dicho camino
     */
    public Lista caminoMasLargo(Object inicio, Object destino) {
    	Lista camino = new Lista();
    	Lista visitados = new Lista();
    	Lista visitadoExisteCamino = new Lista();
    	Vertice nodoInicio = this.ubicarNodo(inicio);
    	Vertice nodoDestino = this.ubicarNodo(destino);
    	
    	if(nodoInicio != null && nodoDestino != null && this.existeCaminoAux(nodoInicio, nodoDestino, visitadoExisteCamino)) {
    		camino = caminoMasLargoAux(ubicarNodo(inicio), ubicarNodo(destino), visitados);
    	}
    	return camino;
    }
    
    /**
     * Metodo auxiliar para listar el camino mas largo
     * @param inicio
     * @param destino
     * @param visitados
     * @return Lista de vertices de dicho camino
     */
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
    
    /**
     * Listamos el grafo con el algoritmo de produndiad
     * @return Lista de nodos visitados
     */
    public Lista listarEnProfundidad() {
    	Lista visitados = new Lista();
    	Vertice aux = this.inicio;
    	
    	while(aux != null) {
    		if(visitados.localizar(aux.getElemento()) == -1) {
    			listarEnProfundidadAux(aux, visitados);
    		}
    		aux = aux.getSigVertice();
    	}
    	return visitados;
    }
    
    /**
     * Metodo auxiliar para listar los vertices en profundiad
     * @param nodo
     * @param visitados
     */
    private void listarEnProfundidadAux(Vertice nodo, Lista visitados) {
    	visitados.insertar(nodo.getElemento(), visitados.longitud()+1);
    	if(nodo != null) {
    		Adyacente aux = nodo.getAdyacente();
    		while(aux != null) {
    			if(visitados.localizar(nodo.getElemento()) == -1) {
    				listarEnProfundidadAux(aux.getVertice(), visitados);
    			}
    			aux = aux.getSiguienteAdy();
    		}
    	}
    }
    
    /**
     * Listamos el grafo con el algoritmo de anchura
     * @return Lista de vertices visitados
     */
    public Lista listarEnAnchura() {
    	Lista visitados = new Lista();
    	Vertice aux = this.inicio;
    	while(aux != null) {
    		if(visitados.localizar(aux.getElemento()) == -1) {
    			listarEnAnchuraAux(aux, visitados);
    		}
    		aux = aux.getSigVertice();
    	}
    	return visitados;
    }
    
    /**
     * Metodo auxiliar para listar por anchura
     * @param nodo
     * @param visitados
     */
    private void listarEnAnchuraAux(Vertice nodo, Lista visitados) {
    	Cola q = new Cola();
    	visitados.insertar(nodo.getElemento(), visitados.longitud()+1);
    	q.poner(nodo);
    	
    	while(!q.esVacia()) {
    		Vertice u = (Vertice)q.obtenerFrente();
    		q.sacar();
    		Adyacente aux = u.getAdyacente();
    		while(aux != null) {
    			if(visitados.localizar(aux.getVertice().getElemento()) == -1) {
    				visitados.insertar(aux.getVertice().getElemento(), visitados.longitud()+1);
    				q.poner(aux.getVertice());
    			}
    			aux = aux.getSiguienteAdy();
    		}
    	}
    }
    
    /**
     * evalua si el grafo esta vacio
     * @return true si esta vacio, false caso contrario.
     */
    public boolean esVacio() {
    	return this.inicio == null;
    }
    
    /**
     * retorna un clon del grafo actual
     */
    public Digrafo clone() {
    	Digrafo G2 = new Digrafo();
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
    
    /***
     * retorna un String donde se visualiza el grafo como una lista de adyacencia.
     * metodo auxliar de depuracion.
     */
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
