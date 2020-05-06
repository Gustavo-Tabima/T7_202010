package model.logic;

public class infoMalla {
	
	double lat;
	double longi;
	
	public infoMalla(double latitud, double longitud) {
			lat = latitud;
			longi = longitud;
	}

	
	double darlongitud(){
		return longi;
	}
	double darLatitud(){
		return lat;
	}
}
