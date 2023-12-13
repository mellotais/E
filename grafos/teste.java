package grafos;
import java.util.Map;

public class teste {
	public static void main(String[] args) {
        ListaAdjacencia grafo = new ListaAdjacencia(5, false); // Exemplo com 5 vértices e grafo não direcionado

        // Adicionando arestas
        grafo.adicionarAresta(0, 1, 2);
        grafo.adicionarAresta(0, 3, 1);
        grafo.adicionarAresta(1, 2, 4);
        grafo.adicionarAresta(1, 4, 3);
        grafo.adicionarAresta(2, 3, 7);
        grafo.adicionarAresta(3, 4, 5);

        // Mostrando lista de adjacências
        System.out.println("Lista de Adjacências:");
        grafo.mostrarListaAdjacencias();

        // Verificando se o grafo é conexo
        System.out.println("Grafo é conexo? " + grafo.conexo());

        // Verificando se o grafo é completo
        System.out.println("Grafo é completo? " + grafo.completo());

        // Verificando se o grafo é Euleriano, Semi-Euleriano ou Não Euleriano
        System.out.println("O grafo é " + grafo.verificaEuleriano());

        // Executando o algoritmo de Dijkstra a partir do vértice 0
        Map<Integer, Integer> resultadosDijkstra = grafo.dijkstra(0);
        System.out.println("Distâncias mínimas a partir do vértice 0:");
        for (Map.Entry<Integer, Integer> entry : resultadosDijkstra.entrySet()) {
            System.out.println("Vértice " + entry.getKey() + ": " + entry.getValue());
        }

        // Verificando se o grafo é Hamiltoniano, Semi-Hamiltoniano ou Não Hamiltoniano
        System.out.println("O grafo é " + grafo.verificaHamiltoniano());

        // Removendo a aresta entre o vértice 1 e o vértice 4
        grafo.removerAresta(1, 4);

        // Mostrando novamente a lista de adjacências após a remoção
        System.out.println("Lista de Adjacências após remoção:");
        grafo.mostrarListaAdjacencias();
    }
}
