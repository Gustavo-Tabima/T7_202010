package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.data_structures.ElementoNoExisteException;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws ElementoNoExisteException, ParseException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
	
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage(" Cargando Datos, Porfavor paciencia..");
				modelo.cargarGrafo();
				view.printMessage("Numero de Vertices "+modelo.grafoCarga.V());

				view.printMessage(" Numero de arcos"+modelo.grafoCarga.E());
	
				
				view.printMessage("Grafo cargado exitosamente");
				view.printMessage("Le pedimos porfavor revise el código del Modelo en caso de necesitar entender que pasó");
				break;

		
			}
		}

	}	
}
