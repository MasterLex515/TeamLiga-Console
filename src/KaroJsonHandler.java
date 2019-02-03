import java.util.*;
import java.io.*;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.lang.reflect.*;

public class KaroJsonHandler
{

	public void calculateTL(String karoJsonString)
	{
		System.out.println("");
		try {
			//convert JSONString to Object
			JSONObject objTL = new JSONObject(karoJsonString);
			//Integer objLenght = objTL.length();

			Integer gid = objTL.getInt("id");
			System.out.println("GID: "+gid);
			String gameName = objTL.getString("name");
			System.out.println("Spiel: "+gameName);
			//extract "player" array as JSONString
			JSONArray arrPlayers = objTL.getJSONArray("players");
			//System.out.println("#debug: object lenght = "+objLenght);
			System.out.println("");
			System.out.println("#debug: players: "+arrPlayers);
		    JSONObject objPlayerIndextest = arrPlayers.getJSONObject(0);
			System.out.println("");
			System.out.println("#debug: objPlayerIndex[0]: "+objPlayerIndextest);


			//convert player JSON to array
			//JSONArray arrPlayers = new JSONArray(players);
			Integer arrLenght = arrPlayers.length();
			
			//extract all players from array and define TL-points
			for (int i = 0; i < arrLenght; ++i){
			JSONObject objPlayerIndex = arrPlayers.getJSONObject(i);
			
			System.out.println("");
			//System.out.println("#debug: arrLenght = "+arrLenght);
			//System.out.println("#debug: arrIndex["+i+"] = "+arrString);
			//convert extracted array index from string to Object
			
			Integer playerId = objPlayerIndex.getInt("id");
			System.out.println("playerId: "+playerId);
			String playerName = objPlayerIndex.getString("name");
			System.out.println("playerName: "+playerName);
			Integer playerRank = objPlayerIndex.getInt("rank");
			System.out.println("playerRank: "+playerRank);
			
			//define Results/Points
			Integer TeamLigaPoints = null;
			if (playerRank == 1){
				TeamLigaPoints = 11;
			}
			if (playerRank == 2){
				TeamLigaPoints = 6;
			}
			if (playerRank == 3){
				TeamLigaPoints = 3;
			}
			if (playerRank == 4){
				TeamLigaPoints = 1;
			}
			if (playerRank == 5){
				TeamLigaPoints = 0;
			}
			if (playerRank == 6){
				TeamLigaPoints = -1;
			}
			
			System.out.println("Punkte: "+TeamLigaPoints);
			
			}//for Loop end
			
		} catch (JSONException je){
			System.out.println(je);
		}
	}//end calculateTL
	
	public void formatUserData(String karoJsonString)
	{
		//code for JSON-formatting of user data
		System.out.println("#debug: "+ karoJsonString);
		System.out.println("");
		JSONObject playerData = new JSONObject(karoJsonString);
		Integer playerId = playerData.getInt("id");
		System.out.println("ID: "+playerId);
		String playerName = playerData.getString("login");
		System.out.println("Name: "+playerName);
		String playerColor = playerData.getString("color");
		System.out.println("Farbe: "+playerColor);
		Integer playerLastVisit = playerData.getInt("lastVisit");
		System.out.println("letzter Login: "+playerLastVisit);
		Integer playerSignUp = playerData.getInt("signup");
		System.out.println("dabei seit: "+playerSignUp);
		Integer playerDran = playerData.getInt("dran");
		System.out.println("dran bei: "+playerDran);
		Integer playerActiveGames = playerData.getInt("activeGames");
		System.out.println("laufende Spiele: "+playerActiveGames);
		Boolean playerDayGame = playerData.getBoolean("acceptsDayGames");
		System.out.println("Day games: "+playerDayGame);
		Boolean playerNightGame = playerData.getBoolean("acceptsNightGames");
		System.out.println("Night game: "+playerNightGame);
		Integer playerMaxGames = playerData.getInt("maxGames");
		System.out.println("max. Spiele: "+playerMaxGames);
		Boolean playerDesperate = playerData.getBoolean("desperate");
		System.out.println("spielegeil: "+playerDesperate);
		Boolean playerBot = playerData.getBoolean("bot");
		System.out.println("ist ein Bot: "+playerBot);
		
		
	}
	
	
}
