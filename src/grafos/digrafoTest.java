package grafos;

public class digrafoTest {
	
	public static void main(String[] args) {
		Digrafo G = new Digrafo();
		//testemos la inserccion del grafo
		System.out.println("Testeamos vertices:");
		System.out.println("insertamos A en el grafo: Espera OK \t"+( G.insertarVertice('A') ? "Ok": "False"));
		System.out.println("insertamos B en el grafo: Espera OK \t"+( G.insertarVertice('B') ? "Ok": "False"));
		System.out.println("insertamos C en el grafo: Espera OK \t"+( G.insertarVertice('C') ? "Ok": "False"));
		System.out.println("insertamos D en el grafo: Espera OK \t"+( G.insertarVertice('D') ? "Ok": "False"));
		System.out.println("insertamos E en el grafo: Espera OK \t"+( G.insertarVertice('E') ? "Ok": "False"));
		//inseramos repetidos
		System.out.println("insertamos B en el grafo: Espera False \t"+( G.insertarVertice('B') ? "Ok": "False"));
		System.out.println("insertamos D en el grafo: Espera False \t"+( G.insertarVertice('D') ? "Ok": "False"));
		System.out.println(G.toString());
		//eliminamos
		System.out.println("eliminamos D en el grafo: Espera Ok \t"+( G.eliminarVertice('D') ? "Ok": "False"));
		System.out.println("insertamos D en el grafo: Espera Ok \t"+( G.insertarVertice('D') ? "Ok": "False"));
		System.out.println("eliminamos F en el grafo: Espera False \t"+( G.eliminarVertice('F') ? "Ok": "False"));
		System.out.println(G.toString());
		System.out.println("Testeamos arcos:");
		//testeamos la creacion de arcos
		System.out.println("insertamos arco A-B : Espera Ok \t"+( G.insertarArco('A', 'B')? "Ok": "False"));
		System.out.println("insertamos arco A-C : Espera Ok \t"+( G.insertarArco('A', 'C')? "Ok": "False"));
		System.out.println("insertamos arco A-D : Espera Ok \t"+( G.insertarArco('A', 'D')? "Ok": "False"));
		System.out.println("insertamos arco B-D : Espera Ok \t"+( G.insertarArco('B', 'D')? "Ok": "False"));
		System.out.println("insertamos arco C-E : Espera Ok \t"+( G.insertarArco('C', 'E')? "Ok": "False"));
		System.out.println("insertamos arco E-D : Espera Ok \t"+( G.insertarArco('E', 'D')? "Ok": "False"));
		System.out.println("insertamos arco A-B : Espera Ok \t"+( G.insertarArco('A', 'B')? "Ok": "False"));
		System.out.println("insertamos arco A-C : Espera Ok \t"+( G.insertarArco('A', 'C')? "Ok": "False"));
		System.out.println("insertamos arco A-F: Espera False \t"+(G.insertarArco('A', 'F')? "Ok": "False"));
		System.out.println("inseramos arco B-B: Espera Ok \t"+(G.insertarArco('B', 'B')?"Ok": "False"));
		System.out.println(G.toString());
		System.out.println("eliminamos el arco A-B : Espera Ok \t"+( G.eliminarArco('A', 'B')? "Ok": "False"));
		System.out.println("insertamos arco A-B : Espera Ok \t"+( G.insertarArco('A', 'B')? "Ok": "False"));
		System.out.println("eliminamos un bucle B-B: Espera Ok \t"+(G.eliminarArco('B', 'B')? "Ok": "False"));
		System.out.println("eliminamos un arco donde un vertice no existe A-F: Espera False \t"+(G.eliminarArco('A', 'F')? "Ok": "False"));
		System.out.println("eliminamos un arco que no existe A-E: Espera False \t"+(G.eliminarArco('A', 'E')? "Ok": "False"));
		//eliminamos un vertice con arcos
		System.out.println("Eliminamos un vertice con arcos: Espera Ok:"+(G.eliminarVertice('C')? "Ok": "False"));
		System.out.println(G.toString());
		//evaluamos la caminos
		System.out.println("Testeamos Caminos:");		
		System.out.println("existe camino entre A y D: Espera Ok \t"+(G.existeCamino('A', 'D')? "Ok": "False"));
		System.out.println("existe camino entre A y E: Espera Ok \t"+(G.existeCamino('A', 'E')? "Ok": "False"));
		System.out.println("inseramos F en el grafo: Espera Ok \t"+(G.insertarVertice('F')? "Ok": "False"));
		System.out.println("existe camino entre B y F: Espera False \t"+(G.existeCamino('B', 'F')? "Ok": "False"));
		System.out.println("existe camino entre A y F: Espera False \t"+(G.existeCamino('A', 'F')? "Ok": "False"));
		System.out.println("camino mas corto "+G.caminoMasCorto('A', 'E').toString());
		System.out.println("camino mas corto entre A y F: Espera Lista vacia \t"+G.caminoMasCorto('A', 'F').toString());
		System.out.println("camino mas largo "+G.caminoMasLargo('A', 'E').toString());
		//listados
		System.out.println("listamos en profundiad: "+G.listarEnProfundidad().toString());
		System.out.println("listamos en anchura: "+G.listarEnAnchura().toString());
		System.out.println("Testemos otras operaciones de grafo");
		Digrafo G2 = G.clone();
		Digrafo G3 = new Digrafo();
		System.out.println("grafo clonado: \n"+G2.toString());
		System.out.println("Es vacio G2: Espera False \t"+(G2.esVacio()? "Ok": "False"));
		System.out.println("Es vacio G3: Espera Ok \t"+(G3.esVacio()? "Ok": "False"));
	}
}
