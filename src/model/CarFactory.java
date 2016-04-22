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
import java.util.List;
import java.util.Properties;

import model.enums.CarKeys;;

public class CarFactory {
	
	private String PATH= "src/bases/rda.csv";
	private final String fieldSeparator = ";";
	
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
			return readFrom(new FileInputStream(PATH),";");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Car> getFromConsole() {
		//System.out.print("Enter Names sep by space: ");
		return readFrom(System.in," ");
	
	}
	
	public List<Car> readFrom(InputStream in, String fieldseparator) {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		List<Car> result = new ArrayList<Car>();
		try {
			String line = null;
			//for (String line = br.readLine(); line != null; line = br.readLine()) {
			//br.readLine();
			while (null != (line = br.readLine()) && line.length() > 0)  {			
				if (line.startsWith(CarKeys.MARK.name())) {line = br.readLine();}
				String[] indiv = line.split(fieldseparator);
				Car car = new Car();
				int i = 0;
				for (Object prop: CarKeys.values()) {
					String add;
					if (i >= indiv.length || null == indiv[i]){
						add = "unknown";
					} else { add = indiv[i]; }
					car.getProp().put(prop,add);
					i++;
				}
				
//				Improvment ? CONTROL whether value for field is auth, if not, check other field, if not, throw except
//				for (Object prop : CarKeys.values())
//					if 

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
				StringBuffer sb = new StringBuffer();
				for (CarKeys key : CarKeys.values()) {
					sb.append(car.getProp().get(key)+fieldSeparator);
				}
				sb.deleteCharAt(sb.length()-1);
				raf.writeUTF("\n"+sb.toString());
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
