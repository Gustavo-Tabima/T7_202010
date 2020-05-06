package model.data_structures;

import model.logic.Haversine;

public class Arco<K extends Comparable<K>, V>
{	

	private K IdPRimerVertice;
	
	private K IdFinalVertice;
	
	Haversine haversinio;
	private V costoArco;
	
	
	 
	public Arco(K pVerIni, K pVerFin, V pCost)
	{
		IdPRimerVertice = pVerIni;
		IdFinalVertice = pVerFin;
		costoArco = pCost;
	}
	
	
	public K getIdVerticeInicio()
	{
		return IdPRimerVertice;
	}
	
	
	public K getIdVerticeFinal()
	{
		return IdFinalVertice;
	}
	

     
	public V getCostArc() 
    {
        return  costoArco;
    }
    
    /**
     * cambia el costo que tiene el arco
     */
    public void setCostArc(V pCost) 
    {
        costoArco = pCost;
    }
}
