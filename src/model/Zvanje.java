package model;

public enum Zvanje {
	REDOVNI("Redovni profesor"), VANREDNI("Vanredni profesor"), DOCENT("Docent");
	
	private String displayName;
	
	Zvanje(String displayName){
		this.displayName = displayName;
	}
	
	public String displayName() {
		return displayName;
	}
}
