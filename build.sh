#!/bin/bash
JAVAC=/usr/bin/javac

$JAVAC -cp .:classpath/curator-client-0.6.4.jar:classpath/zookeeper-3.3.3.jar CuratorZookeeperClientTest.java
