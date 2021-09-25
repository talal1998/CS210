/**
 * Main class
 * @author Talal Thaheem 956013
 * 19th April 2020
 */

public class MainApp {
    Module module;
    Student student;

    public static void main(String[] args) throws InterruptedException {
        //Creates specific module and student objects
        Module cs210 = new Module("Concurrency", 210, "Alma", 2);
        Module cs255 = new Module("Graphics", 255, "Leigh", 2);
        Module cs275 = new Module("Algorithms", 275, "Who", 2);
        Module cs200 = new Module("HCI", 230, "David", 2);

        Module[] moduleArray = {cs210, cs255, cs275, cs200};

        Student s1 = new Student("1", moduleArray);
        Student s2 = new Student("2", moduleArray);
        Student s3 = new Student("3", moduleArray);
        Student s4 = new Student("4", moduleArray);
        Student s5 = new Student("5", moduleArray);
        Student s6 = new Student("6", moduleArray);
        Student s7 = new Student("7", moduleArray);
        Student s8 = new Student("8", moduleArray);


        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);
        Thread t4 = new Thread(s4);
        Thread t5 = new Thread(s5);
        Thread t6 = new Thread(s6);
        Thread t7 = new Thread(s7);
        Thread t8 = new Thread(s8);

        //threads initialised
        t1.start();
        t2.start();
        t3.start();
        t4.start();


        t1.join();
        t2.join();
        t3.join();
        t4.join();


        t5.start();
        t6.start();
        t7.start();
        t8.start();

        t5.join();
        t6.join();
        t7.join();
        t8.join();

    }
}
