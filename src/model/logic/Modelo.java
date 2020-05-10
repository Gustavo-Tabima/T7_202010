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
	public MallaVial mallavial;
	public MaxPQ<Comparendo> comparendosCola = new MaxPQ<Comparendo>();
	public MaxPQ<Policia> tombosCola = new MaxPQ<Policia>();
	public Modelo(){




	}

	public void cargarDatosGrafo() {
		File archivo = new File(PATHVERTEX);
		File archivoA = new File(PATHARCOS);
		FileReader fr;
		try {
			fr = new FileReader(archivo);
			BufferedReader bf = new BufferedReader(fr);
			int lineas = 0;
			while (bf.readLine() != null) { lineas++;
			}
			String linea = bf.readLine();
			GrafoNoDirigido<Integer, Double, Double>  grafo = new GrafoNoDirigido<Integer, Double, Double>(lineas);
			while(linea !=null){
				String [] lineasnuevas =  linea.split(",");

//				Vertex<Integer,Double,Double> n = new Vertex<Integer, Double, Double>(Integer.parseInt(lineasnuevas[0]),Double.parseDouble(lineasnuevas[1]));
				linea = bf.readLine();
				
			}
			bf.close();
			fr.close();
			
			
		} catch (  IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		try {
		FileReader fra = new FileReader(archivoA);
		BufferedReader bfa = new BufferedReader(fra);
		
		String lineaA = bfa.readLine();
		while(lineaA !=null){
			String [] lineasnuevasA =  lineaA.split(" ");

//			Aqui debería ir la creación de cada Arco según los vértices creados anteriormente.
			lineaA = bfa.readLine();
			
		}
		
		bfa.close();
		fra.close();
		
		
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
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



