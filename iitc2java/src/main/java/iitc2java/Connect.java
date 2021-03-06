package iitc2java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.parser.JSONParser;

public class Connect {

	
	private String QUERY = "";
	public String GAMESCORE = "dashboard.getGameScore";
	public String PAGINATEDPLEXTSV2 = "dashboard.getPaginatedPlextsV2"; //COMM Daten
	public String THINNEDENTITIESV4 = "dashboard.getThinnedEntitiesV4"; //Portaldaten Daten
	
	
	
	
	public Object startRequest(String query) throws IllegalStateException, org.json.simple.parser.ParseException
	{
			this.QUERY = query;
			
			Object obj = null;
		    
		    try {
		    	 
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost postRequest = new HttpPost("http://www.ingress.com/r/" + this.QUERY);
		 
				StringEntity input = null; 
				
				if(this.QUERY.equals(this.GAMESCORE))
					input = new StringEntity("{\"4kr3ofeptwgary2j\":\"" + this.QUERY + "\"}");
				
				if(this.QUERY.equals(this.PAGINATEDPLEXTSV2))
					input = new StringEntity("{\"4kr3ofeptwgary2j\":\"" + this.QUERY + "\",\"tmb0vgxgp5grsnhp\":100,\"pg98bwox95ly0ouu\":51263706,\"eib1bkq8znpwr0g7\":12294066,\"ilfap961rwdybv63\":51371504,\"lpf7m1ifx0ieouzq\":12466542,\"hljqffkpwlx0vtjt\":1379535212982,\"sw317giy6x2xj9zm\":-1,\"0dvtbatgzcfccchh\":true}");
				
				if(this.QUERY.equals(this.THINNEDENTITIESV4))
					input = new StringEntity("{\"4kr3ofeptwgary2j\":\"dashboard.getThinnedEntitiesV4\",\"n27qzc8389kgakyv\":[{\"39031qie1i4aq563\":\"15_17510_10923\",\"bgxibcomzoto63sn\":\"15_17510_10923\",\"pg98bwox95ly0ouu\":51316881,\"eib1bkq8znpwr0g7\":12370605,\"ilfap961rwdybv63\":51323747,\"lpf7m1ifx0ieouzq\":12381592},{\"39031qie1i4aq563\":\"15_17514_10923\",\"bgxibcomzoto63sn\":\"15_17514_10923\",\"pg98bwox95ly0ouu\":51316881,\"eib1bkq8znpwr0g7\":12414551,\"ilfap961rwdybv63\":51323747,\"lpf7m1ifx0ieouzq\":12425537},{\"39031qie1i4aq563\":\"15_17510_10924\",\"bgxibcomzoto63sn\":\"15_17510_10924\",\"pg98bwox95ly0ouu\":51310013,\"eib1bkq8znpwr0g7\":12370605,\"ilfap961rwdybv63\":51316881,\"lpf7m1ifx0ieouzq\":12381592},{\"39031qie1i4aq563\":\"15_17514_10924\",\"bgxibcomzoto63sn\":\"15_17514_10924\",\"pg98bwox95ly0ouu\":51310013,\"eib1bkq8znpwr0g7\":12414551,\"ilfap961rwdybv63\":51316881,\"lpf7m1ifx0ieouzq\":12425537}]}");
				
				
				
				input.setContentType("application/json");
			
				
				postRequest.setHeader("Cookie", "GOOGAPPUID=207; ingress.intelmap.lat=51.31760470947741; ingress.intelmap.lng=12.380304336547852; ingress.intelmap.zoom=15; ACSID=AJKiYcFc-1uqw8nXDFTxd8yrds5AmL3_EAkRT3-EuVCUcCHOe3G54fcHMbKCwjcjuxO2xnD37W9vL5AFF0oqhbI6BD26bhyOwYhFlG-mP_6x5DTRUq8t0ptJHGjf-aQtExhuWk00cvP5p4lBu4oaL1o0k6EUK6wYWOi7bCBqGhbQQjO3LLsBChZaM43H3fV7t7Oa6hyt3q1riMBjd2uzs_kI3FTBt5u0DL5fHRRd6n1tDmXOZ2I0ikMu50RY-SZ9WAyf4cPqDgBQXXetJy1L_GTBrWSGhgNvT0bKjjsyoaGA9ESSlbuoQDUkqSf9LWpbRuMijeg6ekVHuUQ57IR2ERx51QgWdL44mw5f1SWlPPsJOuR_7kP7NVDkE_VX1pjL9FG6ttsJbg-Kd8AKxQFIqSfbHxT4KZgzQ5NqaGDmpubCoXKdVoJl_vq1Gr7h5SfNDihz13F5OsYwtLeSQQEnUVSrnZLUWsIO38gMGbOVQnaJab9lHMBVMUCtVm0w3UoOFbsLdqO13gIFFRpoJhSc-ApXIVYwS6Ej4EC67m2OvnKD_v4nBhYjWCDOA643D1MjAqIrYF-ZtKolYOjaEW_P-wq0wganya5B6yvyM59HXwQUSaSCrqHirLo; __utma=24037858.241732761.1374247053.1379245002.1379528834.18; __utmb=24037858.12.9.1379532361669; __utmc=24037858; __utmz=24037858.1379245002.17.2.utmcsr=google.de|utmccn=(referral)|utmcmd=referral|utmcct=/imgres; csrftoken=jY0zp05U3V3B8X9xNZLpiINs995uMMMv");
				postRequest.setHeader("X-Requested-With", "XMLHttpRequest");
				postRequest.setHeader("X-CSRFToken", "jY0zp05U3V3B8X9xNZLpiINs995uMMMv");
				
				postRequest.setEntity(input);
		 
				HttpResponse response = httpClient.execute(postRequest);
		 
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
				}
				
				
				JSONParser parser = new JSONParser();
				
				obj = parser.parse(new InputStreamReader((response.getEntity().getContent())));
				
						 
				httpClient.getConnectionManager().shutdown();
		 
			  } catch (MalformedURLException e) {
		 
				e.printStackTrace();
		 
			  } catch (IOException e) {
		 
				e.printStackTrace();
		 
			  }
		    
		    
		 return obj;
	}


}
