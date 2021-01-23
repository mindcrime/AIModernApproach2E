package org.fogbeam.huntwumpus;

import java.io.IOException;

public class WumpusWorldMain 
{

	public static void main(String[] args) 
	{
		
		WumpusWorld world = new WumpusWorld();
		WumpusWorldLocator worldLocator = new WumpusWorldLocator( world );
	
		System.out.print("\033\143");
		System.out.flush();	
		
		System.out.println( "Are you ready to Hunt The Wumpus!?!??" );
		
		CommandParser commandParser = new CommandParser(worldLocator);
		
		String inputLine = "";
		while( !inputLine.equalsIgnoreCase( "quit" ))
		{
			inputLine = System.console().readLine("> ");
		
			// parse the inputLine and take action
			commandParser.parseAndExecute( inputLine );
		}
		
		System.out.println( "Goodbye!");
		
		
	}
}
