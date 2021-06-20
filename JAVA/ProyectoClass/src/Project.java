
public class Project {
	String name;
	String description;	
	double initialCost;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getInitialCost() {
		return initialCost;
	}
	public void setInitialCost(double initialCost) {
		this.initialCost = initialCost;
	}
	/****************************************************/	
	
	public Project() { 
		this("name",0);
	}
	public Project(String name,int cost) { 
		this.name = name;
		this.initialCost = cost;
	}
	public Project(String name, String description) { 
		this.name = name;
		this.description = description;
	}
	
	public Project(String name,int cost, String description) { 
		this.name = name;
		this.initialCost = cost;
		this.description = description;
	}
	
	public String elevatorPitch() {
		return this.name +" ("+this.initialCost+")"+ ": " + this.description;
	}
}
