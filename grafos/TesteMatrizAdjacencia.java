package grafos;

public class TesteMatrizAdjacencia {

	public static void main(String[] args) {
	
		int numVertices = 3;
		MatrizAdjacencia grafo = new MatrizAdjacencia( numVertices, false, false);
		
		grafo.inserirAresta(0, 1);
		grafo.inserirAresta(0, 2);
		grafo.inserirAresta(1, 2);
		
		grafo.mostrarMatrizAdjacencia();
		
		
		
		System.out.println();
		
		
		MatrizAdjacencia grafo2 = new MatrizAdjacencia( numVertices, true, true);
		
		grafo2.inserirAresta(0, 1, 3);
		grafo2.inserirAresta(1, 2, 5);
		grafo2.inserirAresta(2, 0, 1);
		
		grafo2.mostrarMatrizAdjacencia();
	}

}
