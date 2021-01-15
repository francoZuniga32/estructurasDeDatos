package grafos;
import java.util.HashMap;

public class grafoEtiquetadoTest {
	public static void main(String[] args) {
		GrafoEtiquetado G1 = new GrafoEtiquetado();
		System.out.println("TEST DE VERTICES");
		System.out.println("Insertamos A en el grafo: Espera Ok:\t"+(G1.insertarVertice('A')? "Ok": "False"));
		System.out.println("Insertamos B en el grafo: Espera Ok:\t"+(G1.insertarVertice('B')? "Ok": "False"));
		System.out.println("Insertamos C en el grafo: Espera Ok:\t"+(G1.insertarVertice('C')? "Ok": "False"));
		System.out.println("Insertamos D en el grafo: Espera Ok:\t"+(G1.insertarVertice('D')? "Ok": "False"));
		System.out.println("Insertamos E en el grafo: Espera Ok:\t"+(G1.insertarVertice('E')? "Ok": "False"));
		System.out.println("Insertamos A en el grafo: Espera False:\t"+(G1.insertarVertice('A')? "Ok": "False"));
		System.out.println("Existe A: Espera Ok:\t"+(G1.existeVertice('A')? "Ok": "False"));
		System.out.println("Existe F: Espera False:\t"+(G1.existeVertice('F')? "Ok": "False"));
		System.out.println("Eliminamos E del grafo: Espera Ok:\t"+(G1.eliminarVertice('E')?"Ok": "False"));
		System.out.println("Insertamos E en el grafo: Espera Ok:\t"+(G1.insertarVertice('E')? "Ok": "False"));
		System.out.println("Eliminamos F del grafo: Espera False:\t"+(G1.eliminarVertice('F')?"Ok": "False"));
		System.out.println(G1.toString());
		System.out.println("TEST DE ARCOS");
		System.out.println("Insertamos arco entre A y A con la etiqueta '5': Espera Ok:\t"+(G1.insertarArco('A', 'A', 5)? "Ok": "False"));
		System.out.println("Insertamos arco entre A y B con la etiqueta '10': Espera Ok:\t"+(G1.insertarArco('A', 'B', 10)? "Ok": "False"));
		System.out.println("Insertamos arco entre A y D con la etiqueta '13': Espera Ok:\t"+(G1.insertarArco('A', 'D', 13)? "Ok": "False"));
		System.out.println("Insertamos arco entre B y C con la etiqueta '5': Espera Ok:\t"+(G1.insertarArco('B', 'C', 15)? "Ok": "False"));
		System.out.println("Insertamos arco entre C y D con la etiqueta '4': Espera Ok:\t"+(G1.insertarArco('C', 'D', 15)? "Ok": "False"));
		System.out.println("Insertamos arco entre B y C con la etiqueta '5': Espera Ok:\t"+(G1.insertarArco('B', 'C', 15)? "Ok": "False"));
		System.out.println("Insertamos arco entre F y F con la etiqueta '15': Espera False:\t"+(G1.insertarArco('F', 'F', 15)? "Ok": "False"));
		System.out.println("Insertamos arco entre F y C con la etiqueta '15': Espera Ok:\t"+(G1.insertarArco('F', 'C', 15)? "Ok": "False"));
		System.out.println(G1.toString());
		System.out.println("Obtenemos la etiqueta del arco A A:\t"+G1.getEtiquetaArco('A', 'B').toString());
		System.out.println("Camino mas corto entre A y D: "+G1.caminoMasCorto('A', 'D').toString());
		System.out.println("Camino mas largo entre A y D: "+G1.caminoMasLargo('A', 'D').toString());
		System.out.println("Listar en profundidad: "+G1.listarProfundidad().toString());
		System.out.println("Listar en anchura: "+G1.listarAnchura().toString());
		System.out.println("clone: "+G1.clone().toString());
	}
}
