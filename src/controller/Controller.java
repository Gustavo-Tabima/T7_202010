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
		int datoInt = 0;
		int datoSig;
		String respuesta = "";
		String axulio = "";
		String momento ="0.3";
		String pana ="0.3";

		String entradaAdicional;
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage(" Cargando Datos, Porfavor paciencia..");

				view.printMessage("Cola Creada");
				modelo.cargarDatosComparendos();
				modelo.cargarDatosPolicia();
				view.printMessage("\n"+"\n"+"Cola Creada");
				view.printMessage("\n"+ " Tengo una cola de comparendos de tamaño: ");
				view.printMessage("\n"+ "  "+ modelo.darColaTamano(modelo.darColaComparendo()));
				view.printMessage("\n"+ " Tengo una cola de Tombos de tamaño: ");
				view.printMessage("\n"+ "  "+ modelo.darColaTamano(modelo.darColaTombos()));
				
				//view.printMessage("Numero actual de elementos " + modelo.darTamano() );

				break;

		
			}
		}

	}	
}
