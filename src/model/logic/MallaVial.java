package model.logic;

import model.data_structures.GrafoNoDirigido;
import model.data_structures.Vertex;

public class MallaVial {
	
	public infoMalla info ;
	
Vertex<Integer,Double,Double>[] vertices;
public GrafoNoDirigido<Integer,Double, Double> grafo;
Vertex<Integer,Double,Double> verticeInicial;
	public MallaVial(int vertices) {
		grafo = new GrafoNoDirigido<Integer, Double, Double>(vertices);
	}

	public void agregarVertex(int idVertex, double infoVertex){
		grafo.addVertex(idVertex, infoVertex);
	}
}
