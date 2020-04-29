package main;
import java.text.ParseException;

import controller.Controller;
import model.data_structures.ElementoNoExisteException;

public class Main {
	
	public static void main(String[] args) throws ElementoNoExisteException, ParseException 
	{
		Controller controler = new Controller();
		controler.run();
	}
}
