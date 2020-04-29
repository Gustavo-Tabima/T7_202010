package model.logic;


import java.io.FileReader;
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
import model.data_structures.MaxPQ;



/**
 * Definicion del modelo del mundo
 * @param <T>
 */
public class Modelo<T> {
	public static String PATH = "./data/Comparendos_DEI_2018_Bogota_D.C.geojson";
	//public static String PATH = "./data/Comparendos_DEI_2018_Bogota_D.C_small.geojson";
	public static String PATHPOLICE = "./data/Comparendos_DEI_2018_Bogota_D.C_small.geojson";


	public Modelo(){




	}

	public void cargarDatosComparendos() {


		JsonReader reader;

		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();

			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

			for (int i = 0; i < e2.size();i++) {
				JsonElement e = e2.get(i);
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				Date FECHA_HORA = parser.parse(s);

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();
				String MUNICIPIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("MUNICIPIO").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();


				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, DES_INFRAC, LOCALIDAD, MUNICIPIO, longitud, latitud);



			}}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
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

				





			}}
		catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	








}



