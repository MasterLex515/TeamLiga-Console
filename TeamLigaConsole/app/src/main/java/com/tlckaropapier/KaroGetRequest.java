package com.tlckaropapier;

//import KaroJsonHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class KaroGetRequest
{
	//simple http get request
	private static final String USER_AGENT = "Mozilla/5.0";
	
	
	public void karoGetRequest(String karoURL, String caseOption) throws IOException{
		
		URL obj = new URL(karoURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("#debug: GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
													   con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

				// print result
				String result = response.toString();	
				System.out.println("#debug: "+result);
				System.out.println("#debug: requested: "+karoURL);
				//TODO send requested json string to class with json parser
				//convert json string to object or array
				
				if (caseOption.equals("TeamLigaGame"))
				{
					KaroJsonHandler calcResult = new KaroJsonHandler();
					calcResult.calculateTL(result);
				}
				
				if (caseOption.equals("UserDaten"))
				{
					KaroJsonHandler getUserData = new KaroJsonHandler();
					getUserData.formatUserData(result);
				}
				
				
		}
	}

	public void karoPostRequest() throws IOException
	{
	    // TODO need to access cookies | append data to send

	    System.out.println("post request goes here ...");

        URL url = new URL("https://www.karopapier.de/api/login");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

		// sending json
		byte[] out = "{\"login\":\"username\",\"password\":\"userpassword\"}" .getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		os.write(out);
		}
		// Do something with http.getInputStream()
        
        StringBuilder content; 
        try (BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()))) 
        { 
        String line; 
        content = new StringBuilder(); 
        while ((line = in.readLine()) != null) 
            { 
        content.append(line); 
        content.append(System.lineSeparator()); 
            } 
        } 
        System.out.println(content.toString());
        
        // trying to get cookie
        Map<String, List<String>> headerFields = con.getHeaderFields();
 
        Set<String> headerFieldsSet = headerFields.keySet();
        Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
         
        while (hearerFieldsIter.hasNext()) {
             
             String headerFieldKey = hearerFieldsIter.next();
              
             if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
                  
                 List<String> headerFieldValue = headerFields.get(headerFieldKey);
                  
                 for (String headerValue : headerFieldValue) {
                      
                    System.out.println("Cookie Found...");
                      
                    String[] fields = headerValue.split(";");
 
                    String cookieValue = fields[0];
                    String expires = null;
                    String path = null;
                    String domain = null;
                    boolean secure = false;
                     
                    // Parse each field
                    for (int j = 1; j < fields.length; j++) {
                        if ("secure".equalsIgnoreCase(fields[j])) {
                            secure = true;
                        }
                        else if (fields[j].indexOf('=') > 0) {
                            String[] f = fields[j].split("=");
                            if ("expires".equalsIgnoreCase(f[0])) {
                                expires = f[1];
                            }
                            else if ("domain".equalsIgnoreCase(f[0])) {
                                domain = f[1];
                            }
                            else if ("path".equalsIgnoreCase(f[0])) {
                                path = f[1];
                            }
                        }
                         
                    }
                     
                    System.out.println("cookieValue:" + cookieValue);
                    System.out.println("expires:" + expires);
                    System.out.println("path:" + path);
                    System.out.println("domain:" + domain);
                    System.out.println("secure:" + secure);
                      
                    System.out.println("*****************************************");
             
    
                 }
                  
             }
	   
	    
	    //con.disconnect();
	}

}}
