package model.serialization;

import java.io.FileNotFoundException;
import java.io.IOException;



public class FileFacade <T>{
	
	Serializator<T> seri = new Serializator<>();
	private String filename;
	private T recup;
	
	public void Object2File(T o) {
		try {
			seri.saveObject(o, this.filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public T File2Object() {

			try {
				this.recup = (T) seri.recoverObject(this.filename);
			} catch (FileNotFoundException e) {
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}
	
	public boolean testExist(String filename) {
		return true;
	}
	
}
