import java.util.ArrayList;

public class Portfolio {
	ArrayList<Project> projects = new ArrayList<Project>();

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	public void setProject(Project project) {
		projects.add(project);
	}
	
	
	/*****************************/
	
	public double getPortfolioCost() {
		double total = 0;
		for(Project project : this.projects) {
			total += project.getInitialCost();
		}
		return total;
	}
	
	public void showPortfolio() {
		for(Project project : this.projects) {
			System.out.println(project.elevatorPitch());
		}
		
		double total = this.getPortfolioCost();
		System.out.println("total cost: "+ total);
	}
}
