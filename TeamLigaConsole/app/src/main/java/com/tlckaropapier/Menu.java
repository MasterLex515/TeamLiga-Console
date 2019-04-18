package com.tlckaropapier;

//import KaroAPI;
import com.tlckaropapier.KaroGetRequest;
import java.io.*;
import java.util.*;

public class Menu
{
	public void printHeadPattern()
	{
		System.out.println("");
		System.out.println("     #################");
		System.out.println("     #   Team-Liga   #");
		System.out.println("     #    Console    #");
		System.out.println("     #               #");
		System.out.println("     # Karopapier.de #");
		System.out.println("     #################");
		System.out.println("");
	}
	
	public void menuOptions()
	{
		System.out.println("1: lade User-Daten");
		System.out.println("2: berechne TeamLiga-Spiel");
		System.out.println("3: lade Spieldaten (noch nicht aktiv)");
		System.out.println("4: login test");
		System.out.println("");
		
	}
	
	public void chooseOption() throws IOException
	{
		System.out.print("Deine Auswahl: ");
		Scanner input = new Scanner(System.in);
		String auswahl = input.next();
		System.out.println("#debug: "+auswahl);
		//fixed: programm does not jump into if condition
		
		switch (auswahl){
			case "1":
			    String case1 = "UserDaten";
				System.out.println("#debug: case 1");
				System.out.println("UserId oder UserNamen eingeben: ");
				Scanner inputUser = new Scanner(System.in);
				String user = inputUser.next();
				System.out.println("");
				KaroAPI requestUserData = new KaroAPI();
				requestUserData.getUserInfo(user,case1);
				break;
			case "2":
				String case2 = "TeamLigaGame";
				System.out.println("#debug: case 2");
				System.out.print("Enter GID: ");
				Scanner inputGID = new Scanner(System.in);
				String gid = inputGID.next();
				System.out.println("");
				KaroAPI requestGameInfo = new KaroAPI();
				requestGameInfo.getGameInfo(gid,case2);
				break;
			case "3":
			    System.out.println("geht noch nicht!!!");
			    break;
			case "4":
			    System.out.println("logging in ...");
			    KaroGetRequest post = new KaroGetRequest();
			    post.karoPostRequest();
			    //KaroGetRequest.karoPostRequest();
			    break;
			default:
			    System.out.println("#debug: default case");
		}
	}
	
}
