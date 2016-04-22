package model.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Serializator<T> {
	
	public void saveObject(T o, String filename) throws IOException {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		oos = new ObjectOutputStream(fos = new FileOutputStream(filename));
		oos.writeObject(o);

		fos.close();
		oos.close();

		
		}
	
	
	
	public T recoverObject(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis=null;
		ObjectInputStream ois = null;
		T retour = null;
		ois = new ObjectInputStream(fis = new FileInputStream(filename));
		retour = (T) ois.readObject();
		fis.close();
		ois.close();
		return retour;
	}
	
	
}
