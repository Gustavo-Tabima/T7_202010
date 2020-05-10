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
    private int numConectados;
    
    
    
    
    //lista de arcos que empiezan en este vertice

    private ArrayList<Arco<K, E>> arcosEmp;
    
    
    //lista de arcos que acaban en este vertice
    private ArrayList<Arco<K, E>> arcosFini;

    
    
    
    
    
    
    // constructor
    
	public Vertex(K pIdVertice, V pValorVertice, int pIdNumero)
	{
		this.idVeritice = pIdVertice;
		this.infoVertice = pValorVertice;
		arcosEmp = new ArrayList<Arco<K,E>>();
		arcosFini =  new ArrayList<Arco<K,E>>();
		idNumumeroVertice = pIdNumero;
		numConectados = -1;

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
		return numConectados;
	}
	
	
	public void setComponenteConectado(int pComponente)
	{
		numConectados = pComponente;
	}
	
	public ArrayList<Arco<K, E>> getArcosSaliente()
	{
		return arcosEmp;
	}
	
	
	public void anadirArcoEntrante(Arco<K,E> pArco)
	{
		arcosFini.add(pArco);
	}
	
	
	public void anadirArcoSaliente(Arco<K,E> pArco)
	{
		arcosEmp.add(pArco);
	}
	
	
	public Arco<K,E> getEdge(K idVertexFin)
	{
		Arco<K,E> encontrado = null;
		for (int i = 0; i < arcosEmp.size() && encontrado == null; i++) 
		{
			if(arcosEmp.get(i).getIdVerticeFinal().compareTo(idVertexFin) == 0)
			{
				encontrado = arcosEmp.get(i);
			}
		}
		return encontrado;
	}
}
