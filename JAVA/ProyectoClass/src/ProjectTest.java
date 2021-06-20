
public class ProjectTest {

	public static void main(String[] args) {
		
		Project projectOne = new Project("Primer Projecto",10000,"");
		Project projectTwo = new Project("Segundo Projecto",10020,"");
		Project projectThree = new Project("Tercer Projecto",15000,"");
		
		Portfolio portfolio = new Portfolio();
		
		portfolio.setProject(projectOne);
		portfolio.setProject(projectTwo);
		portfolio.setProject(projectThree);
		
		portfolio.showPortfolio();

	}

}
