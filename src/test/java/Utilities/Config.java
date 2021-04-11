package Utilities;

public enum Config {
	CSV("testData.csv"),Log4J("log4j.xml");
	private String config;
	
	private Config(String config) {
		this.config=config;
	}
	
	public String getConfig() {
		return config;
	}
	

}
