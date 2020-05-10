package model.data_structures;

import java.util.ArrayList;


public class GrafoNoDirigido<K extends Comparable<K>,V,E>
{

	//k va a se la llave , V la infromacion que se le vya a meter al vertice, y E va a ser la informacion de el arco

	private int numeroVertices;

	private int numeroArcos;

	private SeparateChainingHashST<K, Vertex<K,V,E>> vertices;


	private Queue<Integer>[] adjacentesVertices;


	//camino hecho de los numeros de los vertices ya marcados por el dfs;
	private int edgeToDfs[];

	//lista de todos los marcados
	private boolean marcados[];

	/**
	 * Referencia del numero del vertice
	 */
	private int idReferenciaNum;



	public GrafoNoDirigido() 
	{
		vertices = new SeparateChainingHashST<K, Vertex<K,V,E>>();
		numeroVertices = 0;
		numeroVertices = 0;
		idReferenciaNum = 0;
	}



	public GrafoNoDirigido(int V) 
	{
		if (V < 0) {
			throw new IllegalArgumentException("Pana, el numero de vertices no puede ser negativo");
		}

		this.numeroVertices = V;
		this.numeroArcos = 0;
		adjacentesVertices = (Queue<Integer>[]) new Queue[V];
		for (int v = 0; v < V; v++) {
			adjacentesVertices[v] = new Queue<Integer>();
		}
	}


	// inicia los arreglos, es un reset para cuando se vaya a usar nuevamnete;
	public void iniciarDfs()
	{
		edgeToDfs = new int[vertices.size()];
		marcados = new boolean[vertices.size()];
	}

	/**
	 * Arreglo de los vertices marcados
	 * @return Arreglo boolean de los vertices marcados
	 */
	public boolean[] getMarcados()
	{
		return marcados;
	}


	public int V() 
	{
		return vertices.size();
	}


	public int E() 
	{
		return numeroArcos;
	}



	// se supone que segun el documento se va a hacer una lectura de la mlla vial ,e entonce el id de el vertice va a ser un int y la info la lat y long
	public void addVertex(K idVertex, V infoVertex)
	{
		Vertex<K,V,E> v = new Vertex<K,V,E>(idVertex, infoVertex, idReferenciaNum);
		vertices.put(idVertex, v);
		numeroVertices++;
		idReferenciaNum++;
	}

// crea arco basado en vertices y se le asigna el precio, toca mirar eso
	public void addEdge(K idVertexIni, K idVertexFin, E pCost) 
	{
		Vertex<K,V,E> verticeIni = vertices.get(idVertexIni);
		Vertex<K,V,E> verticeFini = vertices.get(idVertexFin);

		if(!idVertexIni.equals(idVertexFin))
		{
			if(verticeIni != null && verticeFini != null)
			{
				Arco<K,E> arco = new Arco<K,E>(idVertexIni, idVertexFin, pCost);
				verticeIni.anadirArcoSaliente(arco);
				verticeFini.anadirArcoEntrante(arco);
				numeroArcos++;
			}							
		}
	}


	public V getInfoVertex(K idVertex)
	{
		Vertex<K,V,E> v = vertices.get(idVertex);
		if(v != null)
		{
			return v.getInfoVertice();
		}
		else
		{
			return null;
		}	
	}


	public void setInfoVertex(K idVertex, V infoVertex)
	{
		Vertex<K,V,E> v = vertices.get(idVertex);
		if(v != null)
		{
			v.setValorVertice(infoVertex);;
		}
	}

// este es el metdo que da el costo de un arco basado en los vertices metidos 
	public double getCostArc(K idVertexIni, K idVertexFin)
	{
		double costArc = 0.0;
		Arco<K,E> arCosto = getArco(idVertexIni, idVertexFin);
		if(arCosto != null)
		{
			costArc = (double) arCosto.getCostArc();
		}
		else if(arCosto == null)
		{
			costArc = -1.0;
		}	
		return costArc;
	}

	//cambia el costo
	public void setCostArc(K idVertexIni, K idVertexFin, E pCost)
	{
		Arco<K,E> v = getArco(idVertexIni, idVertexFin);
		if(v != null)
		{
			v.setCostArc(pCost);
		}	
	}

	 
	public Arco<K,E> getArco(K idVertexIni, K idVertexFin)
	{
		Vertex<K,V,E> verticeActual = vertices.get(idVertexIni);
		Arco<K,E> reactorArc = null;
		if(verticeActual != null)
		{			
			Arco<K,E> arctual = verticeActual.getEdge(idVertexFin);
			if(arctual != null)
			{
				reactorArc = arctual;
			}
		}
		return reactorArc;
	}

	
	 // Desmarca todos los vertices del grafo
	
	public void uncheck()
	{
		iniciarDfs();
		if(vertices != null)
		{
			for (int i = 0; i < vertices.size(); i++) 
			{
				marcados[i] = false;
			}
		}
	}

	// metdo de dfs :v
	public void dfs(K vertex)
	{
		iniciarDfs();
		
		Vertex<K,V,E> verticeActual = vertices.get(vertex);
		marcados[verticeActual.getIdNumeroVertice()] = true;

		ArrayList<Vertex<K,V,E>> arreglo = getAdjacencias(vertex);
		
		for(int i = 0; i < arreglo.size(); i++)
		{
			Vertex<K,V,E> vertice = arreglo.get(i);
			
			if (! marcados[vertice.getIdNumeroVertice()])
			{
				edgeToDfs[vertice.getIdNumeroVertice()] = verticeActual.getIdNumeroVertice();
				
				dfs(vertice.getIdVertice());
				
				
			}
		}
	}

	// numero de vertices conectados
	public int CC()
	{
		int componentesConectados = 0;
		
		for(int j = 0; j < vertices.size(); j++)
		{
			if(marcados[j] = true && idReferenciaNum == j)
			{
				componentesConectados++;
			}
			else
			{
				idReferenciaNum++;
			}
		}
		return componentesConectados;
	}

	//array de vertices adjacentes a un indicado
	public ArrayList<Vertex<K,V,E>> getAdjacencias(K idVertex)
	{
		ArrayList<Vertex<K,V,E>> arreglo = new ArrayList<Vertex<K,V,E>>();
		
		Vertex<K,V,E> v = vertices.get(idVertex);
		if(v != null)
		{
			for(int i = 0; i < v.getArcosSaliente().size(); i++)
			{
				arreglo.add(vertices.get(v.getArcosSaliente().get(i).getIdVerticeFinal()));
			}
		}
		return arreglo;
	}

	
	public Iterable<K> adj(K idVertex) 
	{
		Queue<K> cola = new Queue<K>();
		Vertex<K,V,E> verticeActual = vertices.get(idVertex);
		if(verticeActual != null)
		{
			for(int i = 0; i < verticeActual.getArcosSaliente().size(); i++)
			{
				cola.enqueue(verticeActual.getArcosSaliente().get(i).getIdVerticeFinal());
			}
		}
		return (Iterable<K>) cola; 
	}

	//iterador despues de hacer metdo cc y dfs creo
	public Iterable<K> getCC(K idVertex) 
	{
		Queue<K> cola = new Queue<K>();
		Vertex<K,V,E> verticeActual = vertices.get(idVertex);
		if(verticeActual != null)
		{
			dfs(idVertex);
			for(int i = 0; i < vertices.size(); i++)
			{
				for(int j = 0; j < CC(); j++)
				{
					if(verticeActual.getComponenteConectado() == j)
					{
						cola.enqueue(verticeActual.getArcosSaliente().get(i).getIdVerticeFinal());
					}
				}
			}
		}
		return cola; 
	}
}
