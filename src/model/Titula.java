package model;

public enum Titula {
	PROF("Prof.dr"), DR("Dr");
	
	private String displayName;
	
    Titula(String displayName) {
        this.displayName = displayName;
    }
    
    public String displayName() { return displayName; }
}
