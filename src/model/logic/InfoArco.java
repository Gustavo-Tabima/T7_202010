package model.logic;

public class InfoArco 
{
	
	//costo segun distancia
	private double precioDist;
	
	
	public InfoArco(double pCosto)
	{
		precioDist = pCosto;
	}
	
	
	public double getCosto()
	{
		return precioDist;
	}
	
	
	public void setCosto(double pCosto)
	{
		precioDist = pCosto;
	}
}