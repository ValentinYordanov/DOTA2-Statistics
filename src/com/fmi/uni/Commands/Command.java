package com.fmi.uni.Commands;

public abstract class Command {
	
	protected long profile_id;
	
	public abstract void execute();
	protected void setProfileId(long profile_id) {
		this.profile_id = profile_id;
	}
	
}
