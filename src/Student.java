/**
 * Class which creates the student object.
 * @author Talal Thaheem 956013
 * 19th April 2020
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Student implements Runnable{
	private Module[] moduleArray; //array that stores module objects
	private String studentID; //string that identifies students
	Semaphore sem = new Semaphore(4); //lock that prevents more than 4 threads from running at once
	private int sleepScaler = 1000;

	/**
	 * Constructer for the student object
	 * @param studentID
	 * @param moduleArray
	 */
	Student(String studentID, Module[] moduleArray){
		this.moduleArray = moduleArray;
		this.studentID = studentID;

	}

	/**
	 *
	 * @return returns a randomised student ID.
	 */
	public String getStudentID() {
		//String[] studentArray = {studentID};
		//Random random = new Random();
		//int n = random.nextInt(studentArray.length);
		//return studentArray[n];
		return studentID;
	}

	/**
	 * Method that enrols student objects onto a module by comparing module sizes with preset size limits.
	 * @param moduleIndex used to distinguish each individual module in the array
	 * @throws InterruptedException
	 */
	public synchronized void enrol(Module moduleIndex) throws InterruptedException {
		sem.acquire(); //lock acquired

		//comparing module size to module capacity
		if (moduleIndex.getModuleSize() < moduleIndex.getModuleCapacity()) {
			System.out.println(getStudentID() + " has enrolled onto module: " + moduleIndex.getModuleTitle());
			moduleIndex.incrementCount();//increases module size by 1 if space is available
		} else {
			System.out.println(getStudentID() + " couldn't enroll onto the module " + moduleIndex.getModuleTitle() + " because it is full.");
		}
	}

	/**
	 * method that moves student objects from one module to another by comparing preset module size limits
	 * @param oldModule index of module which is being changed
	 * @param newModule index of new module
	 * @throws InterruptedException
	 */
	public synchronized void transferModule(Module oldModule, Module newModule) throws InterruptedException {
		if ((newModule.getModuleSize() < newModule.getModuleCapacity())) {
			    oldModule.decrementCount();
			    newModule.incrementCount();
				System.out.println(getStudentID() + " has changed to: " + newModule.getModuleTitle());
				sem.release(); //lock released
			}
		}

	/**
	 * randomises the indexes of the module array and then compares them,
	 * keeps indexes consistent in both enrol and transfer methods
	 */
	@Override
	public void run() {
		try {
			Random random = new Random();
			int n = random.nextInt(moduleArray.length);
			int m = random.nextInt(moduleArray.length);
			enrol(moduleArray[n]);
			double mathRandom = Math.random();
			while (m == n){
				m = random.nextInt(moduleArray.length);
			}
			transferModule(moduleArray[n], moduleArray[m]);
			Thread.sleep((long) (mathRandom * sleepScaler));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
