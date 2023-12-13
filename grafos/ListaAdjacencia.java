package grafos;

import java.util.*;

class Aresta {
	int origem;
	int destino;
	int peso;

	public Aresta(int origem, int destino, int peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
}

public class ListaAdjacencia {
	private int nVertices;
	private List<List<Aresta>> adjacencias;
	private boolean direcioanado;
	
	public ListaAdjacencia (int nVertices, boolean direcionado) {
		this.nVertices = nVertices;
		this.direcioanado = direcionado;
		this.adjacencias = new ArrayList<>(nVertices);
		for (int i=0; i<nVertices;i++) {
			adjacencias.add(new ArrayList<Aresta>());
		}
	}
	
	public void adicionarAresta(int u, int v, int peso) {
		Aresta aresta = new Aresta(u,v,peso);
		adjacencias.get(u).add(aresta);
		if(!direcioanado) {
			Aresta arestaInvertida = new Aresta(v,u,peso);
			adjacencias.get(v).add(arestaInvertida);
		}
	}
	
	public void AdiconarAresta(int u,int v) {
		adicionarAresta(u, v, 1);
	}
	
	public void mostrarListaAdjacencias() {
		for (int i=0;i<nVertices;i++) {
			System.out.print("Vertice "+i+": ");
			for(Aresta aresta: adjacencias.get(i)) {
				System.out.print("("+aresta.destino+", peso: "+aresta.peso+")");
			}
			System.out.println();
		}
			
	}
	
	public void removerAresta(int u, int v) {
		List<Aresta> arestaU = adjacencias.get(u);
		for (Aresta aresta : arestaU) {
			if (aresta.destino == v) {
				arestaU.remove(aresta);
				break;
			}
		}
		if (!direcioanado) {
			List<Aresta> arestaV = adjacencias.get(v);
			for (Aresta aresta : arestaV) {
				if (aresta.destino == u) {
					arestaV.remove(aresta);
					break;
				}
			}
		}
	}
	
	public boolean saoAdjacentes(int u, int v) {
		for(Aresta aresta: adjacencias.get(u)) {
			if(aresta.destino==v) {
				return true;
			}
		}
		return false;
	}

	public void mostrarListaAdjacenciasDoVertice(int vertice) {
		System.out.println("Vértice" + vertice+ ":");
		for(Aresta aresta : adjacencias.get(vertice)) {
			System.out.println("("+aresta.destino+", Peso:"+aresta.peso+")");
		}
		System.out.println();
	}
	
	public void removerVertice(int vertice) {
	    adjacencias.remove(vertice);
	    for (List<Aresta> arestas : adjacencias) {
	        for (Aresta aresta : arestas) {
	            if (aresta.destino == vertice) {
	                arestas.remove(aresta);
	                break;
	            }
	        }
	    }
	    nVertices--;
	}
	
	public boolean conexo() {
	    boolean[] verticesVisitados = new boolean[nVertices];
	    buscaProfundidade(0, verticesVisitados);
	    for (boolean visitado : verticesVisitados) {
	        if (!visitado) {
	            return false;
	        }
	    }
	    return true;
	}

	private void buscaProfundidade(int vertice, boolean[] verticesVisitados) {
	    verticesVisitados[vertice] = true;
	    for (Aresta aresta : adjacencias.get(vertice)) {
	        if (!verticesVisitados[aresta.destino]) {
	            buscaProfundidade(aresta.destino, verticesVisitados);
	        }
	    }
	}
	
	public boolean completo() {
	    for (int i = 0; i < nVertices; i++) {
	        for (int j = 0; j < nVertices; j++) {
	            if (!saoAdjacentes(i, j)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}

	
	//lista adjacencia
	public String verificaEuleriano() {
	    int numVerticesComGrauImpar = 0;
	    for (int i = 0; i < nVertices; i++) {
	        if (adjacencias.get(i).size() % 2 != 0) {
	            numVerticesComGrauImpar++;
	        }
	    }

	    if (numVerticesComGrauImpar == 0) {
	        return "Euleriano";
	    } else if (numVerticesComGrauImpar == 2) {
	        return "Semi-Euleriano";
	    } else {
	        return "Não Euleriano";
	    }
	}


	//Lista Adjacencia
	public Map<Integer, Integer> dijkstra(int origem) {
	 Map<Integer, Integer> resultados = new HashMap<>();
	 PriorityQueue<Integer> fila = new PriorityQueue<>(Comparator.comparingInt(resultados::get));

	 for (int i = 0; i < nVertices; i++) {
	 resultados.put(i, Integer.MAX_VALUE);
	 }

	 resultados.put(origem, 0);
	 fila.add(origem);

	 while (!fila.isEmpty()) {
	 int u = fila.poll();
	 for (Aresta ar : adjacencias.get(u)) {
	 int v = ar.destino;
	 int pesoUV = ar.peso;
	 
	 if (resultados.get(u) + pesoUV < resultados.get(v)) {
		 resultados.put(v, resultados.get(u) + pesoUV);
		 fila.add(v);
		 }
		 }
		 }

		 return resultados;
		}

	
	public String verificaHamiltoniano() {
	    boolean[] visitados = new boolean[nVertices];

	    // Inicializar todos os vértices como não visitados
	    Arrays.fill(visitados, false);

	    // Verificar se o grafo é conexo
	    if (!conexo()) {
	        return "Não Hamiltoniano"; // Se não for conexo, não pode ser Hamiltoniano
	    }

	    // Verificar se cada vértice, exceto o último, possui grau >= nVertices/2
	    for (int vertice = 0; vertice < nVertices - 1; vertice++) {
	        if (grauDoVertice(vertice) < nVertices / 2) {
	            return "Não Hamiltoniano";
	        }
	    }

	    // Verificar se o último vértice possui grau >= nVertices/2
	    if (grauDoVertice(nVertices - 1) < nVertices / 2) {
	        return "Semi-Hamiltoniano";
	    }

	    // Verificar se há ciclos Hamiltonianos a partir de cada vértice
	    for (int vertice = 0; vertice < nVertices; vertice++) {
	        Arrays.fill(visitados, false);
	        if (verificaCicloHamiltoniano(vertice, visitados, 1)) {
	            return "Hamiltoniano";
	        }
	    }

	    return "Não Hamiltoniano";
	}

	// Método auxiliar para verificar ciclos Hamiltonianos
	private boolean verificaCicloHamiltoniano(int vertice, boolean[] visitados, int count) {
	    visitados[vertice] = true;

	    if (count == nVertices) {
	        return true; // Ciclo Hamiltoniano encontrado
	    }

	    for (Aresta aresta : adjacencias.get(vertice)) {
	        if (!visitados[aresta.destino]) {
	            if (verificaCicloHamiltoniano(aresta.destino, visitados, count + 1)) {
	                return true;
	            }
	        }
	    }

	    visitados[vertice] = false; 
	    return false;
	}

	// Método auxiliar para obter o grau de um vértice
	private int grauDoVertice(int vertice) {
	    return adjacencias.get(vertice).size();
	}


}