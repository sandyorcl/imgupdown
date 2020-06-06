package com.iud.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonProperties {

	public static Properties propBag;
	
	private CommonProperties(){}

	static{
		loadCommonProperites();
	}
	
	private static void loadCommonProperites() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("Common.properties");
			propBag = new Properties();
			propBag.load(input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 



	}


}
