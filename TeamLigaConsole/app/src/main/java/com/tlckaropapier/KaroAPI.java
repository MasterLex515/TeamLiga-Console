package com.tlckaropapier;

//import KaroGetRequest;
import java.io.IOException;

//TODO create karoAPI alike karo-api-browser for Team-Liga

public class KaroAPI
{
	
	public void getGameInfo(String gid, String caseOption) throws IOException
	{
		String karoLink = "https://www.karopapier.de/api/games/"+gid+"?players=1";
		KaroGetRequest karoRequest = new KaroGetRequest();
		karoRequest.karoGetRequest(karoLink,caseOption);
	}
	
	public void getUserInfo(String user, String caseOption) throws IOException
	{
		String karoLink = "https://www.karopapier.de/api/users/"+user;
		KaroGetRequest karoRequest = new KaroGetRequest();
		karoRequest.karoGetRequest(karoLink, caseOption);
	}
	
	public void checkUser(String caseOption) throws IOException
	{
		String karoLink = "https://www.karopapier.de/api/users/check";
		KaroGetRequest karoRequest = new KaroGetRequest();
		karoRequest.karoGetRequest(karoLink, caseOption);
	}
	
}
