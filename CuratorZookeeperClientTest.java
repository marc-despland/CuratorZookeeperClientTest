import com.netflix.curator.*;

public class CuratorZookeeperClientTest implements RetryPolicy 	{

    public boolean	allowRetry(int retryCount, long elapsedTimeMs){
	return ((retryCount<2) && (elapsedTimeMs<20000));
    }

    public static void main(String[] args) {

	CuratorZookeeperClientTest test=new CuratorZookeeperClientTest();
	CuratorZookeeperClient client=null;

        System.out.println("CuratorZookeeperClientTest");

	if (args.length==0) {
		System.out.println("Usage : CuratorZookeeperClientTest zkservers list");
		System.exit(0);
	}
	System.out.println("Creating CuratorZookeeperClient with zklist : "+args[0]);
	try{
		client=new CuratorZookeeperClient(args[0],20000,20000,null,test);
	} catch(java.io.IOException e) {
		System.out.println("IOException : "+e.getMessage());
		e.printStackTrace();
		System.exit(0);
	}
	try {
                ;client.start();
        } catch(Exception e) {
                System.out.println("Exception : "+e.getMessage());
                e.printStackTrace();
                System.exit(0);
        }
	try {
		boolean success=client.blockUntilConnectedOrTimedOut();
		System.out.println("Connected : "+success);
	} catch(InterruptedException e) {
		System.out.println("Timeout");
		System.exit(0);
	}
	try {
		org.apache.zookeeper.ZooKeeper zk=client.getZooKeeper();
	} catch(Exception e) {
                System.out.println("Exception : "+e.getMessage());
                e.printStackTrace();
		System.exit(0);
        }
    }

}

