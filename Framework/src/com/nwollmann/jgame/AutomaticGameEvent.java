package com.nwollmann.jgame;

public class AutomaticGameEvent {
	
	private long nextExecute;
	
	public final void setNextExecute(long nextExecute){
		this.nextExecute = nextExecute;
	}
	
	public final long getNextExecute(){
		return nextExecute;
	}

	public int getDelay(){
		//return 1000;
		return 500;
	}
	
	public void execute(){
		//System.out.println("Executed");
	}
	
}
