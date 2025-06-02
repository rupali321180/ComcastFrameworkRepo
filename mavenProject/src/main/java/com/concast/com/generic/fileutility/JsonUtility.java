package com.concast.com.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {

	public String getdatafromJsonfile(String key) throws IOException, ParseException
	{
		FileReader filer=new FileReader("./ConfigappData/data3.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(filer);
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(key);
		
		return data;
		
		
		
		
	}
}
