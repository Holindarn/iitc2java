package iitc2java;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Main {


	public static void main(String[] args) throws IllegalStateException, ParseException {
		
		Connect con =  new Connect();

		Object obj = con.startRequest(con.PAGINATEDPLEXTSV2);
		
		JSONObject jsonObject = (JSONObject) obj;
		
		
		JSONArray result = (JSONArray) jsonObject.get("result");
		
		for (Object object : result) {
			System.out.println(object);
		}
		
	}

}
