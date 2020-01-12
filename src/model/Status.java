package model;

public enum Status {
		B("B"),S("S");
private String displayName;
	
	Status(String displayName){
		this.displayName = displayName;
	}
	
	public String displayName() {
		return displayName;
	}
}
