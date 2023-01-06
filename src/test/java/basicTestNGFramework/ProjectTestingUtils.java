package basicTestNGFramework;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ProjectTestingUtils extends GenericWrappers  {
	@BeforeSuite
	public void createReport() {
		startResult();
	}
	@AfterSuite
	public void saveReport() {
		endResult();
	}

}
