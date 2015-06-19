#!/bin/bash
JAVA=/opt/jdksun64/1.6.0_33/bin/java

$JAVA -cp .:classpath/curator-client-0.6.4.jar:classpath/zookeeper-3.3.3.jar:classpath/guava-14.0.jar:classpath/log4j-1.2.14.jar CuratorZookeeperClientTest $1
