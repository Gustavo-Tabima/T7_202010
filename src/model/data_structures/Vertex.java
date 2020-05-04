package model.data_structures;

import java.util.Iterator;

public class Vertex  <K, E extends Comparable<E>> implements Iterator<Vertex<K,E>> {
K llave ;
E contiene;
boolean marca;
Vertex<K,E> proviene;
Vertex<K,E> Siguiente;


public Vertex() {
	llave = null;
	marca = false;
	proviene = null;
	contiene = null;
}

public K darllave() {
	return this.llave;
}

public void marcar() {
	if(marca!=true) {
		marca = true;	
	}
	
}
public void desmarcar() {
	if(marca!=false) {
		marca = false;	
	}
}

public void cambiarProviene(Vertex<K, E> entrada) {
	 proviene =entrada;
}

public boolean esMiKey(K entrada) {
	if(entrada.equals(llave)) {
		return true;
	}
	else 
		return false;
}


public Vertex<K,E> siguiente(){
	return siguiente();
}
public boolean hasNext() {
	
	boolean rta = false;
	if(this.Siguiente.darllave() != null) {
		rta = true;
	}
	else
		rta = false;
	
	return rta;
	
}

public Vertex<K, E> next() {
	return this.siguiente();
}

public void cambiarInfo(E info) {
	this.contiene = info;
}
}
