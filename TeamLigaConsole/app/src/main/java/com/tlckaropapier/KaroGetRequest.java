package com.tlckaropapier;

//import KaroJsonHandler;
import com.tlckaropapier.KaroGetRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class KaroGetRequest
{
   
	//simple http get request
	private static final String USER_AGENT = "Mozilla/5.0";
    
    //static CookieManager cookieManager;
    static CookieStore cookieStore;
	// set 'public' Cookie Object
	static HttpCookie keks;
	
	
	public void karoGetRequest(String karoURL, String caseOption) throws IOException{
	
	        //debug output
		System.out.println("#debug cookie = "+keks);
		// trying to set cookie if available
		//CookieManager cookieManager = new CookieManager();
		//CookieHandler.setDefault(cookieManager);
	   // CookieStore cookieStore = cookieManager.getCookieStore();
	   // List<HttpCookie> cookieList = cookieStore.getCookies();
	   // HttpCookie keks = cookieList.get(0);
	   // String keksString = keks.toString();
	   // System.out.println("keksString"+keksString);
		String keksString = keks.toString();
		URL obj = new URL(karoURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// add cookie to request
		con.setRequestProperty("Cookie",keksString);
		
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
        
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        
	    System.out.println("post request goes here ...");

        URL url = new URL("https://www.karopapier.de/api/login");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

		// sending json
		byte[] out = "{\"login\":\"\",\"password\":\"\"}" .getBytes(StandardCharsets.UTF_8);
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
        con.getContent();
        cookieStore = cookieManager.getCookieStore();
        List<HttpCookie> cookieList = cookieStore.getCookies();
        System.out.println(cookieList.size()+": listsize");
        keks = cookieList.get(0);
        //keks = cookie;
        
        
        System.out.println(keks.getName()+": Name");
        System.out.println(cookieList.get(0).getComment()+": Comment");
        System.out.println(cookieList.get(0).getCommentURL()+": CommentURL");
        System.out.println(cookieList.get(0).getDiscard()+": Discard");
        System.out.println(cookieList.get(0).getDomain()+": Domain");
        System.out.println(cookieList.get(0).getMaxAge()+": MaxAge");
        System.out.println(cookieList.get(0).getPath()+": Path");
        System.out.println(cookieList.get(0).getPortlist()+": Portlist");
        System.out.println(cookieList.get(0).getSecure()+": Secure");
        System.out.println(cookieList.get(0).getValue()+": Value");
        System.out.println(cookieList.get(0).getVersion()+": Version");
        
        
        
       // String headerCookie = con.getHeaderField("Set-Cookie");
       // System.out.println(headerCookie);
       // List<HttpCookie> cookies = HttpCookie.parse(headerCookie);
       // String test = cookies.get(0).getValue();
       // System.out.println(cookies.get(0).getValue());
       // System.out.println(cookies.get(0).getName());
       // System.out.println(cookies.size());
        
        
        
        
        //Map<String, List<String>> headerFields = con.getHeaderFields();
 
        //Set<String> headerFieldsSet = headerFields.keySet();
        //Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
         
        //while (hearerFieldsIter.hasNext()) {
             
             //String headerFieldKey = hearerFieldsIter.next();
              
             //if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {
                  
                 //List<String> headerFieldValue = headerFields.get(headerFieldKey);
                  
                 //for (String headerValue : headerFieldValue) {
                      
                    //System.out.println("Cookie Found...");
                      
                    //String[] fields = headerValue.split(";");
 
                    //String cookieValue = fields[0];
                    //String expires = null;
                    //String path = null;
                    //String domain = null;
                   // boolean secure = false;
                     
                    // Parse each field
                    //for (int j = 1; j < fields.length; j++) {
                        //if ("secure".equalsIgnoreCase(fields[j])) {
                           // secure = true;
                       // }
                       // else if (fields[j].indexOf('=') > 0) {
                           // String[] f = fields[j].split("=");
                          //  if ("expires".equalsIgnoreCase(f[0])) {
                             //   expires = f[1];
                          //  }
                           // else if ("domain".equalsIgnoreCase(f[0])) {
                                //domain = f[1];
                           // }
                          //  else if ("path".equalsIgnoreCase(f[0])) {
                          //      path = f[1];
                          //  }
                      //  }
                         
                   // }
                     
                   // System.out.println("cookieValue:" + cookieValue);
                  //  System.out.println("expires:" + expires);
                  //  System.out.println("path:" + path);
                   // System.out.println("domain:" + domain);
                   // System.out.println("secure:" + secure);
                      
                  //  System.out.println("*****************************************");
             
    
              //   }
                  
           //  } 
	   
	    
	    //con.disconnect();
	}

}
