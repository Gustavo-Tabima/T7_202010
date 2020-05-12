import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.GrafoNoDirigido;

public class TestsGrafo {

	
private GrafoNoDirigido<ArrayList<Integer>> grafPrueba;
	
	
	@Before
	public void setUp1()
	{
		grafPrueba = new GrafoNoDirigido<ArrayList<Integer>>();		
		grafPrueba.addVertex(2, new ArrayList<Integer>());
		
		
		grafPrueba.addVertex(3, new ArrayList<Integer>());
		
		grafPrueba.addVertex(6, new ArrayList<Integer>());
		grafPrueba.addVertex(4, new ArrayList<Integer>());
		
		grafPrueba.addEdge(1, 2, 1.0);
		grafPrueba.addEdge(1, 6, 6.0);
		grafPrueba.addEdge(4, 2, 2.0);
	}
	
	
	
	@Test
	public void testUnGraph() 
	{
		grafPrueba = new GrafoNoDirigido< ArrayList<Integer>>();
		
	}

	
	@Test
public	void testV() 
	{
		setUp1();
		
		
		assertEquals(4, grafPrueba.V());
	}
	
	@Test
public	void testE()
	{
		setUp1();
		
		assertEquals(3, grafPrueba.E());
	}

	
	
	@Test
public	void testAddVertex() 
	{
		setUp1();
		
		grafPrueba.addVertex(9, new ArrayList<Integer>());

		assertEquals(5, grafPrueba.V());

	}

	
	@Test
public	void testAddEdge() 
	{
		setUp1();
		
		grafPrueba.addEdge(1, 9, 4.0);
		
		assertEquals(4, grafPrueba.E());

	}


	
	@Test
public	void testUncheck() 
	{
		setUp1();
		
		grafPrueba.uncheck();
	}

	
	@Test
	
public	void testDfs()
	{
		setUp1();
		
		grafPrueba.dfs(2);
	}

	
}
