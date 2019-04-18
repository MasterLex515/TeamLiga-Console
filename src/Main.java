package com.tlckaropapier;

import java.util.*;
//import TeamLigaConsole.src.KaroAPI;
import java.io.*;
//import TeamLigaConsole.src.Menu;


public class Main
{
	public static void main(String[] args) throws IOException
	{
		Boolean Loop = true;
		//TODO outsource headpattern to seperate class or method
		//TODO create UI for karoAPI options
		do {
		Menu headline = new Menu();
		headline.printHeadPattern();
		headline.menuOptions();
		headline.chooseOption();
		
		System.out.println("");
		System.out.println("nochmal? (y/n): ");
		Scanner input = new Scanner(System.in);
		String input1 = input.next();
		if (input1.equals("y")){
			Loop=true;
			System.out.println("#debug: set bool Loop to true");
			System.out.println("------------------------");
			System.out.println("");
		} else {
			Loop=false;
			System.out.println("#debug: set bool Loop to false");
		}
		
		} while (Loop == true);
		

		System.out.println("#debug: program terminated!");
	}



}
	

