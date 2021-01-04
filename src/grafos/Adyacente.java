package grafos;

public class Adyacente {
	private Vertice NodoVert;
	private Adyacente NodoAdy;
	
	public Adyacente(Vertice nodoVert, Adyacente nodoAdy) {
		this.NodoVert = nodoVert;
		this.NodoAdy = nodoAdy;
	}
	
	public Vertice getVertice() {
		return this.NodoVert;
	}
	
	public void setVertice(Vertice nodo) {
		this.NodoVert = nodo;
	}
	
	public Adyacente getSiguienteAdy() {
		return this.NodoAdy;
	}
	
	public void setSiguienteAdy(Adyacente nodo) {
		this.NodoAdy = nodo;
	}
}
