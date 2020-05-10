package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.data_structures.GrafoNoDirigido;


public class MallaVial 
{
	
	private GrafoNoDirigido<String, InfoVertice, InfoArco> grafoCarga;	
	public MallaVial()
	{
		grafoCarga = new GrafoNoDirigido<String, InfoVertice, InfoArco>();
		
	}

	// Metodos

	
	public double sacarDistanciaHaversine(double startLat, double startLong, double endLat, double endLong) 
	{

		return 0;
	}
	
	
	
	
	/**
	 * Metodo para cargar grafo 
	 */
	public GrafoNoDirigido<String, InfoVertice, InfoArco> cargarGrafo()
	{
		ArrayList<String> verticesCargar = new ArrayList<String>();
		
		ArrayList<String> arcosCargar =new ArrayList<String>();
		try
		{
			BufferedReader bfferVertice = new BufferedReader(new FileReader("./data/bogota_vertices.txt"));
			String lineaVetice;
			while((lineaVetice = bfferVertice.readLine()) != null)
			{
				verticesCargar.add(lineaVetice);
			}
			bfferVertice.close();
	
			grafoCarga = new GrafoNoDirigido<String, InfoVertice, InfoArco>();
			int numeroVertices = verticesCargar.size();
			
			//carga de los vertices
			
			for(int i = 0; verticesCargar != null && i < numeroVertices; i++)
			{
				String lineaActual = verticesCargar.get(i);
				
				String[] infoVertice = lineaActual.split(",");
				
				String id = infoVertice[0];
				
				double longitudVertice = Double.parseDouble(infoVertice[1]); 
				
				double LatitudVertices = Double.parseDouble(infoVertice[2]); 
				
				grafoCarga.addVertex(id, new InfoVertice(longitudVertice, LatitudVertices));
			}
			
			// carga de arcos
			
			
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return grafoCarga;
	}
	
	
	public void generarJSON(String filePath, String fileName)
	{	
		
	}
	

	
	
}