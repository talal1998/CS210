/**
 * Class which creates the Module object.
 * @author Talal Thaheem 956013
 * 19th April 2020
 */
public class Module {
	    Student student;
		private String title;
		private String moduleCoordinator;
		private int moduleCapacity;
		private int studentCount; 
		private int moduleCode = 0;

	/**
	 * Module constructor
	 * @param title name of module
	 * @param moduleCode code for module
	 * @param moduleCoordinator module teacher
	 * @param moduleCapacity size limit for module
	 */
	Module(String title, int moduleCode, String moduleCoordinator, int moduleCapacity){
		this.title = title;
		this.moduleCoordinator = moduleCoordinator;
		this.moduleCode = moduleCode;
		this.moduleCapacity = moduleCapacity;
	}

	public void incrementCount() {
		studentCount = studentCount + 1;
	}

	public void decrementCount() {
		studentCount = studentCount - 1;
	}
	
	public String getModuleTitle() {
		return title;
	}
	
	public int getModuleCapacity() {
		return moduleCapacity;
	}
	
	public String getModuleCoordinator() {
		return moduleCoordinator;
	}
	
	public int getModuleSize() {
		return studentCount;
	}
	
	public int getModuleCode() {
		return moduleCode;
	}


}
