package org.fogbeam.huntwumpus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WumpusWorldLocator
{
	Logger logger = LoggerFactory.getLogger(  WumpusWorldLocator.class );
	
	private WumpusWorld world;
	private int locationX = 1;
	private int locationY = 1;
	
	public WumpusWorldLocator( final WumpusWorld world )
	{
		this.world = world;
	}
	
	
	public void moveLocation( int x, int y ) throws IllegalMoveException
	{
		logger.info( "this.locationX: {}, this.locationY: {}, x: {}, y: {}", this.locationX, this.locationY, x, y );
		
		// first validate that the move is legal
		if( x > 4 || y > 4 || ( x == this.locationX && y == this.locationY ) || x < 1 || y < 1 
				|| ( ( Math.max( x, this.locationX ) - Math.min( x, this.locationX ) ) > 1 )
				|| ( ( Math.max( y, this.locationY ) - Math.min( y, this.locationY ) ) > 1 ) )
		{
			throw new IllegalMoveException();
		}
		
		// if it is, change the x and y location values
		this.locationX = x;
		this.locationY = y;
	}
	
	public Room getCurrentRoom()
	{
		Room currentRoom = world.getRoomByIndex( world.convertCoordinatesToIndex( locationX, locationY ) );
		
		return currentRoom;
	}

	public String getCurrentIndex()
	{
		return Integer.toString( world.convertCoordinatesToIndex( locationX, locationY ) );
	}
	
	public String getCurrentLocation()
	{
		return "[" + this.locationY + "," + this.locationX + "]";
	}

	public void describeWorld()
	{
		System.out.println( this.world.toString() );
	}
}
