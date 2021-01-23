package org.fogbeam.huntwumpus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WumpusWorld
{
	Logger logger = LoggerFactory.getLogger( WumpusWorld.class );
	
	
	List<List<Room>> world = new ArrayList<List<Room>>();
	int goldIndex;
	int wumpusIndex;
	List<Integer> pitList = new ArrayList<Integer>();
	
	
	public WumpusWorld()
	{
		for( int i = 0; i < 4; i++ )
		{
			ArrayList<Room> roomsRow = new ArrayList<Room>();
			world.add( roomsRow );
			
			for( int j = 0; j < 4; j++ )
			{
				Room room = new Room();
				logger.info( "Adding room with id {} at index {}", room.getId(), ((i*4) + j)  );
				room.setIndex( ((i*4) + j) );
				roomsRow.add( room );
			}
			
		}
	
		this.randomlyInitializeRooms();
	}
	
	// getYDimension
	public int getYDimension()
	{
		return world.size();
	}
	
	// getXDimension
	public int getXDimension()
	{
		return world.get( 0 ).size();
	}
	
	public void randomlyInitializeRooms()
	{
		// choose location of Gold and Wumpus randomly with a uniform distribution
		// from any room except the start room (always [1,1])
		
		// our convention will be that the start room [1,1] is in the lower left corner
		// of the grid, and [4,4] is in the upper right corner. We'll id the rooms by
		// a sequential index from 0 to 15
		
		// use 1 as the min, so we can never get room 0 (the start room at [1,1])
		UniformIntegerDistribution ud = new UniformIntegerDistribution(1, 15);
		
		// put the Gold in this room
		goldIndex = ud.sample();
		logger.info(  "goldIndex = {}", goldIndex );
		Room goldRoom = getRoomByIndex( goldIndex );
		logger.info(  "Using room {} as goldRoom", goldRoom.getId() );
		goldRoom.setGoldPresent( true );
		
		// put the Wumpus in this room
		wumpusIndex = ud.sample();
		logger.info(  "wumpusIndex = {}", wumpusIndex );
		Room wumpusRoom = getRoomByIndex( wumpusIndex );
		logger.info(  "Using room {} as wumpusRoom", wumpusRoom.getId() );
		wumpusRoom.setWumpusPresent( true );

		
		// in addition, each room other than the start room can contain a pit with probability 0.2
		UniformIntegerDistribution pitDistribution = new UniformIntegerDistribution(1,100);
		for( int i = 1; i <= 15; i++)
		{
			int roomVal = pitDistribution.sample();
			if( roomVal <= 20 )
			{
				// this room gets a Pit
				Room pitRoom = getRoomByIndex( i );
				pitList.add( i );
				logger.info(  "Adding Pit in room {}", pitRoom.getId() );
				pitRoom.setPitPresent( true );
			}
		}
	}
	
    Room getRoomByIndex( int index )
	{
    	logger.debug( "getRoomByIndex : index = {}", index );
    	
		int x = 0;
		int y = 0;
		
		if( index - 12 >= 0 )
		{
			y = 3;
			x = index - 12;
		}
		else if( index - 8 >= 0 )
		{
			y = 2;
			x = index - 8;
		}
		else if( index - 4 >= 0 )
		{
			y = 1;
			x = index - 4;
		}
		else
		{
			y = 0;
			x = index;
		}
		
		logger.debug(  "getRoomByIndex: x = {}, y = {}", x, y );
		
		List<Room> row = world.get( y );
		Room room = row.get( x );
		return room;
	}

    public int convertCoordinatesToIndex( final int x, final int y )
    {
    	int index = ( (y-1) * 4 ) + (x-1);
    	
    	return index;
    }
    
	public int getSize()
	{
		return this.getXDimension() * this.getYDimension();
	}

	public String toString()
	{
		return "wumpusIndex: " + wumpusIndex + ", goldIndex: " + goldIndex + ", pits: "
				+ Arrays.toString(pitList.toArray());
	}
}
