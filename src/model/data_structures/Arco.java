package model.data_structures;

import model.logic.Haversine;

public class Arco <K,E extends Comparable<E>>{

Vertex<K,E> primero;

Vertex<K,E> segundo;
Haversine haversinio;
double costo;
Arco(Vertex<K,E> primerVer , Vertex<K,E> segundoVer, double costoso){
	
	primero = primerVer;
	segundo = segundoVer;
	costo= costoso;
}

public Vertex<K,E> darPrimero(){
	return primero;
}

public Vertex<K,E> darSegundo(){
	return primero;
}

}
