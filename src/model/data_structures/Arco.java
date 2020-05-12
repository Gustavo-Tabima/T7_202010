package model.data_structures;

import model.logic.Haversine;

public class Arco
{	

	private int IdPRimerVertice;
	
	private int IdFinalVertice;
	
	Haversine haversinio;
	private double costoArco;
	
	
	 
	public Arco(int pVerIni, int pVerFin, double pCost)
	{
		IdPRimerVertice = pVerIni;
		IdFinalVertice = pVerFin;
		costoArco = pCost;
	}
	
	
	public int getIdVerticeInicio()
	{
		return IdPRimerVertice;
	}
	
	
	public int getIdVerticeFinal()
	{
		return IdFinalVertice;
	}
	

     
	public double getCostArc() 
    {
        return  costoArco;
    }
    
    /**
     * cambia el costo que tiene el arco
     */
    public void setCostArc(double pCost) 
    {
        costoArco = pCost;
    }
}
