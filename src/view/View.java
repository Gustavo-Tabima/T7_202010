package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("Bienvenido al proyecto 2 de Estructuras de datos "
					+ "De Josue Rivera y Gustavo Tabima."  );
			
			
			System.out.println("Todos los métodos cargan, lo hemos comprobado varias veces en diferentes equipos así que porfavor paciencia");
			
			System.out.println("A2 Demora cierto tiempo en cargar pero no es menos de 1:30, depende del día también.");
			
			System.out.println("Las tablas (Req C) funcionan pero debido a los cálculos demoran cierto tiempo en cargar. Algunos métodos van a diferir de los resultados debido"
					+ "a las tildes y símbolos del Json, pero los resultados  optimos estan en el Documento, el documento está en DOCS ");
			
			
			System.out.println("1. Realizar Carga de Datos. ");
			System.out.println("2. (A1) dar Comparendor de mayor gravedad.   ");
			System.out.println("3. (A2) Dar Comparendos según mes y según día de la semana. ");
			System.out.println("4. (A3) Dar Comparendos que han ocurrido en una localidad dada según un rango de fechas determinado. ");

			System.out.println("5. (B1) Dar comparendos pedidios según su cercanía a la estación de policía el Campín");
			System.out.println("6. (B2) Dar comparendos pedidios según detección, clase de vehículo, tipo de servicio y localidad.");
			System.out.println("7. (B3) Dar comparendos pedidios según rango de latitudes y tipo de vehiculo.");
			System.out.println("8. (C1) Dar Tabla de fechas según un rango de días decididos por el usuario");
			System.out.println("9. (C2) Dar Tabla de comparendos según el sistema actual");
			System.out.println("10.(C3) Dar Tabla de comparendos según el sistema actual(atencion: para evitar irregularidades al activar c3, porfavor no activar las otras tablas antes)");

		
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
