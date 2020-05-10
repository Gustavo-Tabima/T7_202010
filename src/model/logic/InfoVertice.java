package model.logic;

public class InfoVertice {
	
		
		
		private double longitud;
		
		
		private double latitud;
		
	
		 
		public InfoVertice(double pLongitud, double pLatitud)
		{
			this.longitud = pLongitud;
			this.latitud = pLatitud;
		}
	
		 
		public double getLongitud()
		{
			return longitud;
		}
		
	
		public double getLatitud()
		{
			return latitud;
		}
		
	
		public void setLongitud(double pLongitud)
		{
			longitud = pLongitud;
		}
		
		
		public void setLatitud(double pLatitud)
		{
			latitud = pLatitud;
		}
	}