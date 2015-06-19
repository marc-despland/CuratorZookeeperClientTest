# CuratorZookeeperClientTest
Test a connection to a Zookeeper cluster through CuratorZookeperClient to investigate a connection issue.

With an application that use [Curator](http://curator.apache.org/curator-client/) to access a Zookeeper cluster, we have a strange network issue.

It possible to connect from teh serve to each of the 3 Zookeper nodes using zkCli.sh, but when the application try to connect we have an exceeption

```Caused by: org.apache.zookeeper.KeeperException$ConnectionLossException: KeeperErrorCode = ConnectionLoss
        at com.netflix.curator.ConnectionState.getZooKeeper(ConnectionState.java:72) ~[curator-client-0.6.4.jar:na]
        at com.netflix.curator.CuratorZookeeperClient.getZooKeeper(CuratorZookeeperClient.java:74) ~[curator-client-0.6.4.jar:na]```

And with a TCP Dump we saw that :
Client (Curator) send a SYN packet to the Server (one of the Zookeeper node)
Server answer by a SYN,ACK (that look well formed)
Client answer by a RST that close the connection

On other platform everything work well

So this test is designed to investigate this behavior without having to play with the full apllication
