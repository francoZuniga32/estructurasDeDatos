package grafos;

public class NodoAdy {
	private NodoVertice NodoVert;
	private NodoAdy NodoAdy;
	
	public NodoAdy(NodoVertice nodoVert, NodoAdy nodoAdy) {
		this.NodoVert = nodoVert;
		this.NodoAdy = nodoAdy;
	}
	
	public NodoVertice getVertice() {
		return this.NodoVert;
	}
	
	public void setVertice(NodoVertice nodo) {
		this.NodoVert = nodo;
	}
	
	public NodoAdy getSiguienteAdy() {
		return this.NodoAdy;
	}
	
	public void setSiguienteAdy(NodoAdy nodo) {
		this.NodoAdy = nodo;
	}
}
