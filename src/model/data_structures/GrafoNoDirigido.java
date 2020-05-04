package model.data_structures;

import java.util.Iterator;

public class GrafoNoDirigido <K,E extends Comparable<E>> {
	int nV;
	Vertex<K,E> verticeInicial;
	Vertex<K, E>[]  vertices;
	Object[] llaves;
	int arcosN;
	Arco[] Arcos;



	public GrafoNoDirigido(int Vertices) {
		vertices = new Vertex [Vertices];
		for (int i = 0; i < Vertices-1; i++) {


			if(verticeInicial==null) {
				verticeInicial = new Vertex<K,E>();
				vertices[0] = verticeInicial;
				nV++;
			}
			if(i != 0) {
				Vertex<K,E> actual  = new Vertex<K,E>();
				vertices[i] = actual;
				nV++;
			}


		}
	}


	public int darNumeroVertices() {
		return this.nV;
	}



	public void setCostArc() {

	}

	public void addVertex(K id,E info) {
		Vertex<K, E> nuevo = new  Vertex<K,E>();
		
		
		for (int i = 0; i < vertices.length; i++) {
			vertices.clone()
		}
		java.lang.System.arraycopy(src, srcPos, dest, destPos, length);
		vertices4
		nV++;

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
	public void addEdge( Vertex<K,E> ini,Vertex<K,E> fini,double costo) {
		Arco<K,E> nuevoArco = new Arco<K,E>(ini, fini, costo);
		arcosN++;
	}

	public void uncheck() {
		Vertex<K, E> actual = verticeInicial;
		while (actual.hasNext()) {
			actual.desmarcar();
			actual = actual.next();

		}
	}
}




