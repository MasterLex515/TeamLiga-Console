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
				
				
				
		}
	}
}
