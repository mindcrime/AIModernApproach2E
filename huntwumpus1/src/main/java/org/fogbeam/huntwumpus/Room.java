
package org.fogbeam.huntwumpus;


public class Room
{
	private boolean wumpusPresent;
	private boolean goldPresent;
	private boolean pitPresent;
	
	
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
	
}
