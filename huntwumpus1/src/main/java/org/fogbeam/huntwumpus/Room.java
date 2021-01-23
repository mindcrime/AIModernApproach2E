
package org.fogbeam.huntwumpus;

import java.util.UUID;

public class Room
{

	private String id = UUID.randomUUID().toString();
	private boolean wumpusPresent;
	private boolean goldPresent;
	private boolean pitPresent;
	private int index;

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}
	
	public boolean isWumpusPresent()
	{
		return wumpusPresent;
	}
	
	public void setWumpusPresent( boolean wumpusPresent )
	{
		this.wumpusPresent = wumpusPresent;
	}
	
	public boolean isGoldPresent()
	{
		return goldPresent;
	}
	
	public void setGoldPresent( boolean goldPresent )
	{
		this.goldPresent = goldPresent;
	}
	
	public boolean isPitPresent()
	{
		return pitPresent;
	}
	
	public void setPitPresent( boolean pitPresent )
	{
		this.pitPresent = pitPresent;
	}
	
	public int getIndex()
	{
		return index;
	}

	public void setIndex( int index )
	{
		this.index = index;
	}

	public String getDescription()
	{
		return "ID: " + this.id + "\n"
				+ "Gold: " + this.goldPresent + "\n" 
				+ "Pit: " + this.pitPresent + "\n"
				+ "Wumpus: " + this.wumpusPresent + "\n"
				+ "Index: " + this.index;
	}
	
}
