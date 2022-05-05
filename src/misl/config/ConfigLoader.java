package misl.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigLoader {

	private Properties prop;
	
	public String getProp(String key) {
		return prop.getProperty(key);
	}
	
	public ConfigLoader() {
		 String fileName = "application.properties";
		 prop = new Properties();

	    try {
	       InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
	       prop.load(is);
	       is.close();
	    } catch(IOException e) {
	       e.printStackTrace();
	    }
	}

}
