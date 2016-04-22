package launch;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.CarFactory;
import model.Garage;
import model.serialization.Serializator;

public class Main {

	public static void main(String[] args) {
		
		Serializator<Garage> seri = new Serializator<>();
		try {
			seri.recoverObject("src/bases/serial.ser");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Garage g = new Garage();
		g.getStock().addAll(g.getUsine().getSFromFile());
		
		System.out.println(g.getStock());
		
		g.getStock().addAll(g.getUsine().getFromConsole());
		
		System.out.println(g.getStock());
		
		try {
			seri.saveObject(g, "src/bases/serial.ser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
