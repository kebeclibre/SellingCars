package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import model.enums.CarKeys;
import model.enums.Color;
import model.enums.Option;

public class Car  {
	private Properties prop = new Properties();
	private Properties variables = new Properties();
	private List<Option> options;
	
	
	public Properties getProp() {
		return prop;
	}

	public List<Option> getOptions() {
		return options;
	}

	@Override
	public String toString() {
		return "Car [prop=" + prop + ", variables=" + variables + ", options=" + options + "]";
	} 
	
	
	
	
}
