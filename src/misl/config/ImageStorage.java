package misl.config;

public class ImageStorage {
	
	ConfigLoader cl;
	public final String DEFAULT_PATH;
	
	public ImageStorage(){
		cl = new ConfigLoader();
		DEFAULT_PATH = cl.getProp("upload.image.defualt");
	}

}
