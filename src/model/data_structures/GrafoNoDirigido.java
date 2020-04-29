package model.data_structures;

public class GrafoNoDirigido <K,E extends Comparable<E>> {
int nV;

int arcosN;
Arco[] Arcos;



public GrafoNoDirigido(int Vertices) {
	for (int i = 0; i < Vertices-1; i++) {
		  new Vertex<K,E>();
		  nV++;
	}
}


public int darNumeroVertices() {
	return this.nV;
}


public int darNumeroArcos() {
	return this.arcosN;
}
}
