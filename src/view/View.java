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
			System.out.println("\n"+"\n"+"Bienvenido al proyecto 2 de Estructuras de datos "
					+ "De Josue Rivera y Gustavo Tabima."  );
			
			
			
			System.out.println("\n" + "1. Realizar Carga de Datos. ");
			

		
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
		}
}
