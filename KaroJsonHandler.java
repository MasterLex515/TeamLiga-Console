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
			Integer objLenght = objTL.length();
			//extract "player" array as JSONString
			String players = objTL.getString("players");
			System.out.println("#debug: object lenght = "+objLenght);
			System.out.println("#debug: players: "+players);
			
			//convert player JSON to array
			JSONArray arrPlayers = new JSONArray(players);
			Integer arrLenght = arrPlayers.length();
			
			//extract all players from array and define TL-points
			for (int i = 0; i < arrLenght; ++i){
			String arrString = arrPlayers.getString(i);
			System.out.println("");
			System.out.println("#debug: arrLenght = "+arrLenght);
			System.out.println("#debug: arrIndex["+i+"] = "+arrString);
			//convert extracted array index from string to Object
			JSONObject objPlayer = new JSONObject(arrString);
			Integer playerId = objPlayer.getInt("id");
			System.out.println("playerId: "+playerId);
			String playerName = objPlayer.getString("name");
			System.out.println("playerName: "+playerName);
			Integer playerRank = objPlayer.getInt("rank");
			System.out.println("playerRank: "+playerRank);
			
			//define Results/Points
			Integer TeamLigaPoints = -404;
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
	
	
	
	
}
