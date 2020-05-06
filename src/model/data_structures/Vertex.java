package model.data_structures;

import java.util.ArrayList;


public class Vertex<K extends Comparable<K>,V,E>
{
	private K idVeritice;
	
	
	
	//va a ser en este caso la lat y long de lo de lamalla creo
	
	public V infoVertice;
	
	//el numero del vertice, el numero en plan este es el 5( el quinto anadido)
    private int idNumumeroVertice;
    
    //cuanta gente esta conectada a este vertice
    private int componenteConectado;
    
    
    
    
    //lista de arcos que empiezan en este vertice

    private ArrayList<Arco<K, E>> arcosSalen;
    
    
    //lista de arcos que acaban en este vertice
    private ArrayList<Arco<K, E>> arcosEntran;

    
    
    
    
    
    
    // constructor
    
	public Vertex(K pIdVertice, V pValorVertice, int pIdNumero)
	{
		this.idVeritice = pIdVertice;
		this.infoVertice = pValorVertice;
		arcosSalen = new ArrayList<Arco<K,E>>();
		arcosEntran =  new ArrayList<Arco<K,E>>();
		componenteConectado = -1;
		idNumumeroVertice = pIdNumero;
	}
	
	
	public K getIdVertice()
	{
		return idVeritice;
	}
	
	
	public int getIdNumeroVertice()
	{
		return idNumumeroVertice;
	}
	
	
	public V getInfoVertice()
	{
		return infoVertice;
	}
	
	
	public void setValorVertice(V pValor)
	{
		infoVertice = pValor;
	}
	
	
	public int getComponenteConectado()
	{
		return componenteConectado;
	}
	
	
	public void setComponenteConectado(int pComponente)
	{
		componenteConectado = pComponente;
	}
	
	public ArrayList<Arco<K, E>> getArcosSaliente()
	{
		return arcosSalen;
	}
	
	
	public void anadirArcoEntrante(Arco<K,E> pArco)
	{
		arcosEntran.add(pArco);
	}
	
	
	public void anadirArcoSaliente(Arco<K,E> pArco)
	{
		arcosSalen.add(pArco);
	}
	
	
	public Arco<K,E> getEdge(K idVertexFin)
	{
		Arco<K,E> encontrado = null;
		for (int i = 0; i < arcosSalen.size() && encontrado == null; i++) 
		{
			if(arcosSalen.get(i).getIdVerticeFinal().compareTo(idVertexFin) == 0)
			{
				encontrado = arcosSalen.get(i);
			}
		}
		return encontrado;
	}
}
