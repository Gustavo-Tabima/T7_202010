package model.data_structures;

import java.util.ArrayList;


public class Vertex<V>
{
	private int idVeritice;
	
	
	
	//va a ser en este caso la lat y long de lo de lamalla creo
	
	public V infoVertice;
	
	//cuanta gente esta conectada a este vertice
    private int numConectados;
    
    
    
    
    //lista de arcos que empiezan en este vertice

    private ArrayList<Arco> arcosEmp;
    
    
    //lista de arcos que acaban en este vertice
    private ArrayList<Arco> arcosFini;

    
    
    
    
    
    
    // constructor
    
	public Vertex(int pIdVertice, V pValorVertice)
	{
		this.idVeritice = pIdVertice;
		this.infoVertice = pValorVertice;
		arcosEmp = new ArrayList<Arco>();
		arcosFini =  new ArrayList<Arco>();
		numConectados = -1;

	}
	
	
	public int getIdVertice()
	{
		return idVeritice;
	}
	
	

	
	public V getInfoVertice()
	{
		return infoVertice;
	}
	
	
	public void setInfoVertice(V pValor)
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
	
	public ArrayList<Arco> getArcosSaliente()
	{
		return arcosEmp;
	}
	
	
	public void anadirArcoEntrante(Arco pArco)
	{
		arcosFini.add(pArco);
	}
	
	
	public void anadirArcoSaliente(Arco pArco)
	{
		arcosEmp.add(pArco);
	}
	
	
	public Arco getEdge(int idVertexFin)
	{
		Arco encontrado = null;
		for (int i = 0; i < arcosEmp.size() && encontrado == null; i++) 
		{
			if(arcosEmp.get(i).getIdVerticeFinal() == idVertexFin)
			{
				encontrado = arcosEmp.get(i);
			}
		}
		return encontrado;
	}
}
