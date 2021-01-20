package org.fogbeam.huntwumpus;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;

public class WumpusWorld
{
	List<List<Room>> world = new ArrayList<List<Room>>();
	
	public WumpusWorld()
	{
		for( int i = 0; i < 4; i++ )
		{
			ArrayList<Room> roomsRow = new ArrayList<Room>();
			world.add( roomsRow );
			
			for( int j = 0; j < 4; j++ )
			{
				Room room = new Room();
				roomsRow.add( room );
			}
			
		}
	}
	
	// getLength
	
	// getWidth
	
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
		int goldIndex = ud.sample();
		
		// put the Wumpus in this room
		int wumpusIndex = ud.sample();
		
		
		// in addition, each room other than the start room can contain a pit with probability 0.2
		UniformIntegerDistribution pitDistribution = new UniformIntegerDistribution(1,100);
		for( int i = 1; i <= 15; i++)
		{
			int roomVal = pitDistribution.sample();
			if( roomVal <= 20 )
			{
				// this room gets a Pit
			}
		}
	}
	
}
