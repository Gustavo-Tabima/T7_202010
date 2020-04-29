package model.data_structures;

public class Arco <K,E extends Comparable<E>>{

Vertex<K,E> primero;

Vertex<K,E> segundo;

Arco(Vertex<K,E> primerVer , Vertex<K,E> segundoVer){
	
	primero = primerVer;
	segundo = segundoVer;
}

public Vertex<K,E> darPrimero(){
	return primero;
}

public Vertex<K,E> darSegundo(){
	return primero;
}

}
