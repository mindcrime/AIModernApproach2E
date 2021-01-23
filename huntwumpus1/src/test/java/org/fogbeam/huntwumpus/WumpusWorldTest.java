package org.fogbeam.huntwumpus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WumpusWorldTest
{
	@Test
	void testRandomlyInitializeRooms()
	{
		WumpusWorld world = new WumpusWorld();
		assertTrue( world.getYDimension() == 4 );
		assertTrue( world.getXDimension() == 4 );
	}
	
	@Test
	void testGetRoomByIndex()
	{
		WumpusWorld world = new WumpusWorld();
		
		int yDim = world.getYDimension();
		int xDim = world.getXDimension();
		int size = yDim * xDim;
		
		for( int i = 0; i < size; i++ )
		{
			Room room = world.getRoomByIndex( i );
			System.out.println( room.getId());
			assertNotNull( room );
		}
	}

	@Test
	void testStartRoomEmpty()
	{
		WumpusWorld world = new WumpusWorld();
		Room room = world.getRoomByIndex( 0 );
		
		assertFalse( room.isGoldPresent() );
		assertFalse( room.isWumpusPresent() );
		assertFalse( room.isPitPresent() );
		
	}
	
	@Test
	void testGetSize()
	{
		WumpusWorld world = new WumpusWorld();
		assertTrue( world.getSize() == 16 );
	}
	
	@Test
	void testGoldCount()
	{
		WumpusWorld world = new WumpusWorld();
		int size = world.getSize();
		int goldCount = 0;
		for( int i = 0; i < size; i++ )
		{
			Room room = world.getRoomByIndex( i );
			if( room.isGoldPresent() )
			{
				goldCount++;
			}
		}
		
		assertTrue( goldCount == 1 );
	}
	
	@Test
	void testWumpusCount()
	{
		WumpusWorld world = new WumpusWorld();
		int size = world.getSize();
		int wumpusCount = 0;
		for( int i = 0; i < size; i++ )
		{
			Room room = world.getRoomByIndex( i );
			if( room.isWumpusPresent() )
			{
				wumpusCount++;
			}
		}
	
		assertTrue( wumpusCount == 1 );
	}
}
