package com.tlckaropapier;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import org.json.JSONObject;
//import org.json.JSONArray;
//import org.json.JSONException;
//import KaroJsonHandler;


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

	public void karoPostRequest(String karoURL) throws IOException
	{
	    // TODO need to access cookies | append data to send

	    System.out.println("post request goes here ...");

        URL url = new URL(karoURL);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

		// sending json
		byte[] out = "{\"username\":\"root\",\"password\":\"password\"}" .getBytes(StandardCharsets.UTF_8);
        int length = out.length;
        
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		http.connect();
		try(OutputStream os = http.getOutputStream()) {
		os.write(out);
		}
		// Do something with http.getInputStream()

	
	}

}
