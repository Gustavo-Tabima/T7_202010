import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.GrafoNoDirigido;
import model.logic.InfoArco;

public class TestsGrafo {

	
private GrafoNoDirigido<String, ArrayList<Integer>, InfoArco> grafPrueba;
	
	
	@Before
	public void setUp1()
	{
		grafPrueba = new GrafoNoDirigido<String, ArrayList<Integer>, InfoArco>();		
		grafPrueba.addVertex("2", new ArrayList<Integer>());
		
		
		grafPrueba.addVertex("1", new ArrayList<Integer>());
		
		grafPrueba.addVertex("6", new ArrayList<Integer>());
		grafPrueba.addVertex("4", new ArrayList<Integer>());
		
		grafPrueba.addEdge("1", "2", new InfoArco(1.0));
		grafPrueba.addEdge("1", "6", new InfoArco(6.0));
		grafPrueba.addEdge("4", "2", new InfoArco(2.0));
	}
	
	
	
	@Test
	public void testUnGraph() 
	{
		grafPrueba = new GrafoNoDirigido<String, ArrayList<Integer>, InfoArco>();
		
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
		
		grafPrueba.addVertex("9", new ArrayList<Integer>());

		assertEquals(5, grafPrueba.V());

	}

	
	@Test
public	void testAddEdge() 
	{
		setUp1();
		
		grafPrueba.addEdge("1", "9", new InfoArco(4.0));
		
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
		
		grafPrueba.dfs("2");
	}

	
}
