package grafos;

public class MatrizAdjacencia {

    private int[][] G;
    private int numVertices;
    private boolean ponderado;
    private boolean direcionado;

    public MatrizAdjacencia(int numVertices, boolean ponderado, boolean direcionado) {

        this.numVertices = numVertices;
        this.ponderado = ponderado;
        this.direcionado = direcionado;
        G = new int[numVertices][numVertices];
    }

    public void inserirAresta(int vertice1, int vertice2) {
        if (!ponderado) {
            G[vertice1][vertice2] = 1;
            if (!direcionado) {
                G[vertice2][vertice1] = 1;
            }
        } else {
            System.out.println("Grafo ponderado. Necessita peso da aresta");
        }
    }

    public void inserirAresta(int vertice1, int vertice2, int peso) {
        if (ponderado) {
            G[vertice1][vertice2] = peso;
            if (!direcionado) {
                G[vertice2][vertice1] = peso;
            }
        } else {
            System.out.println("Grafo não ponderado. Arestas não possuem pesos");
        }
    }

    public void removerAresta(int vertice1, int vertice2) {
        G[vertice1][vertice2] = 0;
        if (!direcionado) {
            G[vertice2][vertice1] = 0;
        }
    }

    public void mostrarMatrizAdjacencia() {
        for (int i = 0; i < numVertices; i++) {
            for (int m = 0; m < numVertices; m++) {
                System.out.print(G[i][m] + " ");
            }
            System.out.println();
        }
    }

    public boolean verAdjacencia(int vertice1, int vertice2) {
        return G[vertice1][vertice2] != 0;
    }
    
    public void removerVertice(int vertice) {
        for (int i = 0; i < numVertices; i++) {
            G[vertice][i] = 0;
            G[i][vertice] = 0;
        }
        numVertices--;
    }
    
    public boolean conexo() {
        boolean[] verticesVisitados = new boolean[numVertices];
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
        for (int i = 0; i < numVertices; i++) {
            if (G[vertice][i] != 0 && !verticesVisitados[i]) {
                buscaProfundidade(i, verticesVisitados);
            }
        }
    }

    
    
    public boolean completo() {
        for (int i = 0; i < numVertices; i++) {
            for (int m = 0; m < numVertices; m++) {
                if (i != m && G[i][m] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


}
