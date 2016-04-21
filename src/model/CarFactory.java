package model;
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;;

public class CarFactory {
	
	private final String PATH= "src/cars.csv"; 
	
	private static CarFactory instance;
	
	private CarFactory() {
		
	}
	
	
	public static CarFactory getInstance() {
		if (null == instance) {
			instance = new CarFactory();
			return instance;
		} else {
			return instance; }
	}
	
	public List<Car> getSFromFile() {
		try {
			return readFrom(new FileInputStream(PATH));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Car> getFromConsole() {
		//System.out.print("Enter Names sep by space: ");
		return readFrom(System.in);
	
	}
	
	public List<Car> readFrom(InputStream in) {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<Car> result = new ArrayList<Car>();
		try {
			String line = null;
			//for (String line = br.readLine(); line != null; line = br.readLine()) {
			while (null != (line = br.readLine()) && line.length() > 0)  {
				String[] indiv = line.split(" ");
				Car car = new Car();
				// fill in the fields
				String last="";
				for (byte i = 1; i < indiv.length; i++) {
					if (i == indiv.length - 1) {
						last += indiv[i];
					} else {last += indiv[i]+", "; }
				}
				//last = last.substring(0, last.length()-2);
				// fill in here to
				result.add(car);
				
			}
			in.close();
			br.close();
			
		} catch (FileNotFoundException e) {	e.printStackTrace();
		} catch (IOException e) {e.printStackTrace(); }
		return result;
	}

	
	
	public void writeToFile (List<Car> cars) {
		try {
			RandomAccessFile raf = new RandomAccessFile(new File(PATH),"rw");
			long offset = raf.length();
			raf.seek(offset);
			//raf.writeUTF("\n");
			for (Car car : cars) {
				//raf.writeUTF("\n"+stud.getFirstname()+" "+stud.getLastname());
			}
			raf.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void consoleToFile() {
		writeToFile(getFromConsole());
	}
}
