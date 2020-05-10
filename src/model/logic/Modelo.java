package model.logic;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.ElementoNoExisteException;
import model.data_structures.GrafoNoDirigido;
import model.data_structures.MaxPQ;
import model.data_structures.Vertex;



/**
 * Definicion del modelo del mundo
 * @param <T>
 */
public class Modelo<T extends Comparable<T> > {
	public static String PATHARCOS = "./data/bogota_arcos.txt";
	public static String PATH = "./data/Comparendos_DEI_2018_Bogota_D.C_small.geojson";
	public static String PATHVERTEX = "./data/bogota_vertices.txt";
	public static String PATHPOLICE = "./data/estacionespoli.geojson";
	public MaxPQ<Comparendo> comparendosCola = new MaxPQ<Comparendo>();
	public MaxPQ<Policia> tombosCola = new MaxPQ<Policia>();
	public GrafoNoDirigido<String, InfoVertice, InfoArco> grafoCarga= new GrafoNoDirigido<String, InfoVertice, InfoArco>();
	public Modelo(){




	}


	/**
	 * Metodo para cargar grafo 
	 */
	
	//aca esta cargando la malla
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

		
			BufferedReader bufferArcos = new BufferedReader(new FileReader("./data/bogota_arcos.txt"));
			String lineasArcos;
			while((lineasArcos = bufferArcos.readLine()) != null)
			{
				arcosCargar.add(lineasArcos);
			}
			bufferArcos.close();
			
			int numeroArcos = arcosCargar.size();
			for(int i = 0; arcosCargar != null && i < numeroArcos; i++)
			{
				String lineaActual = arcosCargar.get(i);
				String[] valores = lineaActual.split(",");
				String id = valores[0];
				for(int j = 1; j < valores.length; j++)
				{
					double pLonIn = grafoCarga.getInfoVertex(id).getLongitud();
					double pLatIn = grafoCarga.getInfoVertex(id).getLatitud();
					double pLonFi = grafoCarga.getInfoVertex(valores[j]).getLongitud();
					double pLatFi = grafoCarga.getInfoVertex(valores[j]).getLatitud();

					double pCosto = Haversine.distance(pLatIn, pLonIn, pLatFi, pLonFi);
					grafoCarga.addEdge(id, valores[j], new InfoArco(pCosto));
				}
			}

		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return grafoCarga;
	
		
		
	}

	
	

	public void cargarDatosPolicia() {


		JsonReader reader;

		try {
			reader = new JsonReader(new FileReader(PATHPOLICE));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			for (int i = 0; i < e2.size();i++) {
				JsonElement e = e2.get(i);
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();


				String EPODESCRIP = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPODESCRIP").getAsString();
				String EPODIR_SITIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPODIR_SITIO").getAsString();
				double EPOLATITUD = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOLATITUD").getAsDouble();
				double EPOLONGITU = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOLONGITU").getAsDouble();
				String EPOSERVICIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOSERVICIO").getAsString();
				String EPOHORARIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOHORARIO").getAsString();
				int EPOTELEFON = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOTELEFON").getAsInt();
				int EPOIULOCAL = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOIULOCAL").getAsInt();

				Policia	c= new Policia(OBJECTID, EPODESCRIP, EPODIR_SITIO, EPOLONGITU, EPOLATITUD, EPOSERVICIO, EPOHORARIO, EPOTELEFON, EPOIULOCAL);
				tombosCola.insert(c);






			}}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}






public String darColaTamano (MaxPQ<T> cola) {
	return "" +cola.size();
}

public MaxPQ<Comparendo> darColaComparendo () {
	return this.comparendosCola;
}

public MaxPQ<Policia> darColaTombos(){
	return this.tombosCola;
}
}



