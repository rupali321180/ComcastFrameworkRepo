package com.concast.com.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {

	public String getdatafromPropertiesfile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./ConfigappData/data2.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}
}
