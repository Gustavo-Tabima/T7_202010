package model.data_structures;

import java.util.ArrayList;


public class GrafoNoDirigido<V>
{

	//k va a se la llave , V la infromacion que se le vya a meter al vertice, y E va a ser la informacion de el arco

	private int numeroVertices;

	private int numeroArcos;

	private SeparateChainingHashST<Integer, Vertex> vertices;


	private Queue<Integer>[] adjacentesVertices;


	//camino hecho de los numeros de los vertices ya marcados por el dfs;
	private int edgeToDfs[];

	//lista de todos los marcados
	private boolean marcados[];

	private int numeroAsignadoVertice;



	public GrafoNoDirigido() 
	{
		vertices = new SeparateChainingHashST<Integer, Vertex>();
		numeroVertices = 0;
		numeroVertices = 0;
		numeroAsignadoVertice = 0;
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
	public void addVertex(int idVertex, V infoVertex)
	{
		Vertex v = new Vertex(idVertex, infoVertex);
		vertices.put(idVertex, v);
		numeroVertices++;
	}

// crea arco basado en vertices y se le asigna el precio, toca mirar eso
	public void addEdge(int idVertexIni, int idVertexFin, double pCost) 
	{
		Vertex verticeIni = vertices.get(idVertexIni);
		Vertex verticeFini = vertices.get(idVertexFin);

		if(!(idVertexIni==idVertexFin))
		{
			if(verticeIni != null && verticeFini != null)
			{
				Arco arco = new Arco(idVertexIni, idVertexFin, pCost);
				verticeIni.anadirArcoSaliente(arco);
				verticeFini.anadirArcoEntrante(arco);
				numeroArcos++;
			}							
		}
	}


	public V getInfoVertex(int idVertex)
	{
		Vertex v = vertices.get(idVertex);
		if(v != null)
		{
			return (V) v.getInfoVertice();
		}
		else
		{
			return null;
		}	
	}


	public void setInfoVertex(int idVertex, V infoVertex)
	{
		Vertex v = vertices.get(idVertex);
		if(v != null)
		{
			v.setInfoVertice(infoVertex);;
		}
	}

// este es el metdo que da el costo de un arco basado en los vertices metidos 
	public double getCostArc(int idVertexIni, int idVertexFin)
	{
		double costArc = 0.0;
		Arco arCosto = getArco(idVertexIni, idVertexFin);
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
	public void setCostArc(int idVertexIni, int idVertexFin, double pCost)
	{
		Arco v = getArco(idVertexIni, idVertexFin);
		if(v != null)
		{
			v.setCostArc(pCost);
		}	
	}

	 
	public Arco getArco(int idVertexIni, int idVertexFin)
	{
		Vertex verticeActual = vertices.get(idVertexIni);
		Arco reactorArc = null;
		if(verticeActual != null)
		{			
			Arco arctual = verticeActual.getEdge(idVertexFin);
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
	public void dfs(int vertex)
	{
		iniciarDfs();
		
		Vertex verticeActual = vertices.get(vertex);
		marcados[ verticeActual.getIdVertice()] = true;

		ArrayList<Vertex> arreglo = getAdjacencias(vertex);
		
		for(int i = 0; i < arreglo.size(); i++)
		{
			Vertex vertice = arreglo.get(i);
			
			if (! marcados[vertice.getIdVertice()])
			{
				edgeToDfs[vertice.getIdVertice()] = verticeActual.getIdVertice();
				
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
			if(marcados[j] = true && numeroAsignadoVertice == j)
			{
				componentesConectados++;
			}
			else
			{
				numeroAsignadoVertice++;
			}
		}
		return componentesConectados;
	}

	//array de vertices adjacentes a un indicado
	public ArrayList<Vertex> getAdjacencias(int idVertex)
	{
		ArrayList<Vertex> arreglo = new ArrayList<Vertex>();
		
		Vertex v = vertices.get(idVertex);
		if(v != null)
		{
			for(int i = 0; i < v.getArcosSaliente().size(); i++)
			{
				arreglo.add(vertices.get(((Arco) v.getArcosSaliente().get(i)).getIdVerticeFinal()));
			}
		}
		return arreglo;
	}

	
	public Iterable<Integer> adj(int idVertex) 
	{
		Queue<Integer> cola = new Queue<Integer>();
		Vertex verticeActual = vertices.get(idVertex);
		if(verticeActual != null)
		{
			for(int i = 0; i < verticeActual.getArcosSaliente().size(); i++)
			{
				cola.enqueue(((Arco) verticeActual.getArcosSaliente().get(i)).getIdVerticeFinal());
			}
		}
		return (Iterable<Integer>) cola; 
	}

	//iterador despues de hacer metdo cc y dfs creo
	public Iterable<Integer> getCC(int idVertex) 
	{
		Queue<Integer> cola = new Queue<Integer>();
		Vertex verticeActual = vertices.get(idVertex);
		if(verticeActual != null)
		{
			dfs(idVertex);
			for(int i = 0; i < vertices.size(); i++)
			{
				for(int j = 0; j < CC(); j++)
				{
					if(verticeActual.getComponenteConectado() == j)
					{
						cola.enqueue(((Arco) verticeActual.getArcosSaliente().get(i)).getIdVerticeFinal());
					}
				}
			}
		}
		return cola; 
	}
}
