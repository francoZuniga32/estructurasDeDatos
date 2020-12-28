package grafos;

public class testGrafos {
	public static void main(String[]args) {
		//comenzamos credo un grafo
		Grafo G = new Grafo();
		System.out.println("insertamos A en el grafo: Espera OK \t"+( G.insertarVertice('A') ? "Ok": "False"));
		System.out.println("insertamos B en el grafo: Espera OK \t"+( G.insertarVertice('B') ? "Ok": "False"));
		System.out.println("insertamos C en el grafo: Espera OK \t"+( G.insertarVertice('C') ? "Ok": "False"));
		System.out.println("insertamos D en el grafo: Espera OK \t"+( G.insertarVertice('D') ? "Ok": "False"));
		System.out.println("insertamos E en el grafo: Espera OK \t"+( G.insertarVertice('E') ? "Ok": "False"));
		System.out.println("insertamos B en el grafo: Espera False \t"+( G.insertarVertice('B') ? "Ok": "False"));
		System.out.println("insertamos D en el grafo: Espera False \t"+( G.insertarVertice('D') ? "Ok": "False"));
		System.out.println(G.toString());
		System.out.println("insertamos arco A-B : Espera Ok \t"+( G.insertarArco('A', 'B')? "Ok": "False"));
		System.out.println("insertamos arco A-C : Espera Ok \t"+( G.insertarArco('A', 'C')? "Ok": "False"));
		System.out.println("insertamos arco A-D : Espera Ok \t"+( G.insertarArco('A', 'D')? "Ok": "False"));
		System.out.println("insertamos arco B-D : Espera Ok \t"+( G.insertarArco('B', 'D')? "Ok": "False"));
		System.out.println("insertamos arco C-E : Espera Ok \t"+( G.insertarArco('C', 'E')? "Ok": "False"));
		System.out.println("insertamos arco E-D : Espera Ok \t"+( G.insertarArco('E', 'D')? "Ok": "False"));
		System.out.println(G.toString());
		System.out.println("existe camino entre A y D: Espera Ok \t"+(G.existeCamino('A', 'D')? "Ok": "False"));
		System.out.println("existe camino entre B y D: Espera False \t"+(G.existeCamino('B', 'D')? "Ok": "False"));

		System.out.println("camino mas corto "+G.caminoMasCorto('A', 'E').toString());
		System.out.println("camino mas largo "+G.caminoMasCorto('A', 'D').toString());
	}
}
