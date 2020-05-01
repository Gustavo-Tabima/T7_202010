package model.data_structures;

import java.util.Iterator;

public class GrafoNoDirigido <K,E extends Comparable<E>> {
int nV;
Vertex<K,E> verticeInicial;

Object[] llaves;
int arcosN;
Arco[] Arcos;



public GrafoNoDirigido(int Vertices) {
	
	llaves= (K[]) new Object[Vertices];
	for (int i = 0; i < Vertices-1; i++) {
		if (i==0){
			verticeInicial = new Vertex<K, E>();
			llaves[0] = verticeInicial.darllave();
		}  
		
		new Vertex<K,E>();
		  nV++;
	}
}


public int darNumeroVertices() {
	return this.nV;
}



public void setCostArc() {
	
}

public void addVertex(K id,E info) {
	Vertex<K, E> nuevo = new  Vertex<K,E>();
	
}

public int darNumeroArcos() {
	return this.arcosN;
}

void setInfoVertex(K idVertex,E info) {
	Vertex<K,E> actual = verticeInicial;
	while(actual.hasNext()) {
		if(actual.esMiKey(idVertex)) {
			actual.cambiarInfo(info);
		}
		else {
			actual = actual.Siguiente;
		}
	}
}
public void addEdge( K idIni, K iDFinal, double cost) {
	
}







}

