
package grafos;

import java.util.Map;

public class TesteListaAdjacencias {
	public static void main(String[] args) {
	
        ListaAdjacencia grafo = new ListaAdjacencia(18, false); 

        // Adicionar arestas
        grafo.adicionarAresta(0, 7, 130);
        grafo.adicionarAresta(0, 6, 70);
        grafo.adicionarAresta(0, 4, 150);
        grafo.adicionarAresta(0, 1, 50);
        grafo.adicionarAresta(1, 0, 50);
        grafo.adicionarAresta(1, 2, 260);
        grafo.adicionarAresta(1, 3, 135);
        grafo.adicionarAresta(2, 3, 170);
        grafo.adicionarAresta(2, 1, 260);
        grafo.adicionarAresta(3, 4, 80);
        grafo.adicionarAresta(3, 2, 170);
        grafo.adicionarAresta(4, 5, 100);
        grafo.adicionarAresta(4, 6, 120);
        grafo.adicionarAresta(4, 0, 150);
        grafo.adicionarAresta(4, 3, 80);
        grafo.adicionarAresta(5, 8, 80);
        grafo.adicionarAresta(5, 6, 150);
        grafo.adicionarAresta(5, 4, 100);
        grafo.adicionarAresta(6, 8, 200);
        grafo.adicionarAresta(6, 5, 150);
        grafo.adicionarAresta(6, 4, 120);
        grafo.adicionarAresta(6, 0, 70);
        grafo.adicionarAresta(7, 9, 70);
        grafo.adicionarAresta(7, 0, 130);
        grafo.adicionarAresta(8, 9, 160);
        grafo.adicionarAresta(8, 10, 100);
        grafo.adicionarAresta(8, 5, 80);
        grafo.adicionarAresta(8, 6, 200);
        grafo.adicionarAresta(9, 10, 160);
        grafo.adicionarAresta(9, 8, 160);
        grafo.adicionarAresta(9, 7, 70);
        grafo.adicionarAresta(9, 11, 80);
        grafo.adicionarAresta(9, 12, 80);
        grafo.adicionarAresta(10, 9, 160);
        grafo.adicionarAresta(10, 8, 100);
        grafo.adicionarAresta(10, 15, 200);
        grafo.adicionarAresta(10, 14, 150);
        grafo.adicionarAresta(10, 11, 80);
        grafo.adicionarAresta(11, 10, 80);
        grafo.adicionarAresta(11, 9, 80);
        grafo.adicionarAresta(11, 14, 110);
        grafo.adicionarAresta(11, 12, 100);
        grafo.adicionarAresta(12, 13, 70);
        grafo.adicionarAresta(12, 13, 70);
        grafo.adicionarAresta(13, 14, 120);
        grafo.adicionarAresta(13, 16, 50);
        grafo.adicionarAresta(13, 17, 80);
        grafo.adicionarAresta(14, 15, 140);
        grafo.adicionarAresta(14, 16, 100);
        grafo.adicionarAresta(14, 13, 120);
        grafo.adicionarAresta(14, 11, 110);
        grafo.adicionarAresta(14, 10, 150);
        grafo.adicionarAresta(16, 13, 50);
        grafo.adicionarAresta(16, 14, 100);
        grafo.adicionarAresta(16, 17, 50);
        grafo.adicionarAresta(17, 13, 80);
        grafo.adicionarAresta(17, 16, 50);

        // Mostrar a lista de adjacências
        System.out.println("Lista de Adjacências:");
        grafo.mostrarListaAdjacencias();
/*
        // Verificar se dois vértices são adjacentes
        int vertice1 = 0;
        int vertice2 = 1;
        System.out.println("Os vértices " + vertice1 + " e " + vertice2 + " são adjacentes? "
                + grafo.saoAdjacentes(vertice1, vertice2));

        // Remover uma aresta
        grafo.removerAresta(0, 1);
        System.out.println("Após remover a aresta (0, 1):");
        grafo.mostrarListaAdjacencias();

        // Remover um vértice
        int verticeARemover = 2;
        grafo.removerVertice(verticeARemover);
        System.out.println("Após remover o vértice " + verticeARemover + ":");
        grafo.mostrarListaAdjacencias();
*/
        // Verificar se o grafo é conexo
        System.out.println("O grafo é conexo? " + grafo.conexo());

        // Verificar se o grafo é completo
        //System.out.println("O grafo é completo? " + grafo.completo());

        System.out.println();
        // Executar o algoritmo de Dijkstra a partir do vértice 0
        Map<Integer, Integer> resultadosDijkstra = grafo.dijkstra(0);
        System.out.println("Resultados do algoritmo de Dijkstra a partir do vértice 0:");
        for (Map.Entry<Integer, Integer> entry : resultadosDijkstra.entrySet()) {
            System.out.println("Vértice " + entry.getKey() + ": Distância mínima = " + entry.getValue());
        }
    }
}
