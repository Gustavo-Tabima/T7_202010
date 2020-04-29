package model.data_structures;

public class Vertex  <K, E extends Comparable<E>>{
K llave ;
E contiene;
boolean marca;
Vertex<K,E> proviene;



public Vertex() {

	marca = false;
	proviene = null;

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
}
