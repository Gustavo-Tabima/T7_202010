package model.logic;
/**
 * Para el Requerimiento B1 se usa esta clase para el manejo de los puntos georeferenciados
 * Se le da todo el crédito al creador original de este algoritmo y su uso no emplea
 * en ningún momento el lucro o la creación de un programa con fines estatales, su uso es meramente
 * académico y está avalado por la Universidad de los Andes, Colombia. 
 * 
 * La fuentre de este código se puede encontrar en el siguiente enlace
 * 
 * https://github.com/jasonwinn/haversine/blob/master/Haversine.java
 * 
 * 
 * @author Gustavo Tabima.
 * 
 *
 */
public class Haversine {
	
	
	
	/**
	 * Jason Winn
	 * http://jasonwinn.org
	 * Created July 10, 2013
	 *
	 * Description: Small class that provides approximate distance between
	 * two points using the Haversine formula.
	 *
	 * Call in a static context:
	 * Haversine.distance(47.6788206, -122.3271205,
	 *                    47.6788206, -122.5271205)
	 * --> 14.973190481586224 [km]
	 *
	 */

	
	    private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

	    public static double distance(double startLat, double startLong,
	                                  double endLat, double endLong) {

	        double dLat  = Math.toRadians((endLat - startLat));
	        double dLong = Math.toRadians((endLong - startLong));

	        startLat = Math.toRadians(startLat);
	        endLat   = Math.toRadians(endLat);

	        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
	        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	        return EARTH_RADIUS * c; // <-- d
	    }

	    public static double haversin(double val) {
	        return Math.pow(Math.sin(val / 2), 2);
	    }
	}