import org.apache.log4j.BasicConfigurator;

public class Test {
    public static void main(String [] args) {
        BasicConfigurator.configure();

        Thread t1 = new Thread(new Worker());
        Thread t2 = new Thread(new Worker());
        t1.start();
        t2.start();
    }

}
