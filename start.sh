#!/bin/bash
JAVA=/usr/bin/java

$JAVA -cp .:classpath/curator-client-0.6.4.jar:classpath/zookeeper-3.3.3.jar CuratorZookeeperClientTest $1
