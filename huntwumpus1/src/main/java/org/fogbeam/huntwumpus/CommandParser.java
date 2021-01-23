package org.fogbeam.huntwumpus;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class CommandParser
{
	Logger logger = LoggerFactory.getLogger(  WumpusWorldLocator.class );
	
	private WumpusWorldLocator worldLocator;
	
	public CommandParser( final WumpusWorldLocator worldLocator )
	{
		this.worldLocator = worldLocator;
	}

	public void parseAndExecute( final String inputLine )
	{	
		if( inputLine.startsWith( "go " ))
		{
			// go [2,3] for example
			String destination = StringUtils.substringAfter( inputLine, "go " );
			String yStr = destination.substring( 1, 2 );
			String xStr = destination.substring( 3, 4 );
		
			int x = Integer.parseInt( xStr );
			int y = Integer.parseInt( yStr );
		
			try
			{
				worldLocator.moveLocation( x, y );
			}
			catch( IllegalMoveException e )
			{
				System.out.println( "Sorry, you can't do that" );
			}
			
		}
		else if( inputLine.equalsIgnoreCase( "location"  ))
		{
			System.out.println( worldLocator.getCurrentLocation() );
		}
		else if( inputLine.equalsIgnoreCase( "index"  ))
		{
			System.out.println( worldLocator.getCurrentIndex() );
		}
		else if( inputLine.equalsIgnoreCase( "look" ))
		{
			Room currentRoom = worldLocator.getCurrentRoom();
			System.out.println( currentRoom.getDescription() );
		}
		else if( inputLine.equalsIgnoreCase( "cheat"  ))
		{
			this.worldLocator.describeWorld();
		}
		else if( inputLine.equalsIgnoreCase( "clear"  ))
		{
			System.out.print("\033\143");
			System.out.flush();	
		}
		else if( inputLine.equalsIgnoreCase( "debug on"  ))
		{
			System.out.println( "Turning debug ON" );
			final ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);	
			root.setLevel( Level.DEBUG );
		}
		else if( inputLine.equalsIgnoreCase( "debug off"  ))
		{
			System.out.println( "Turning debug OFF" );
			final ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
			root.setLevel(Level.WARN);
		}
		else
		{
			logger.info( "Unknown command: \"{}\"", inputLine );
		}
		
	}
}
