import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class Worker implements Runnable {


    @Override
    public void run() {
        String hostPort = "localhost:2181";
        ZooKeeper zk  = null;
        try {
            zk = new ZooKeeper(hostPort, 2000, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String basePath = "/LockNode";
        String lockName = "id";
        DistributedLock lock = new DistributedLock(zk, basePath, lockName);
        try {
            lock.lock();
            for (int i = 1; i<=10; i++)
                System.out.println(i);
            lock.unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
