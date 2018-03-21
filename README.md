# quasar-cglib-agent
This is a minimal example project of quasar(https://github.com/puniverse/quasar) to work with cglib using java agent and Classifier

## Step 1
mvn clean  install

## Step 2
java -javaagent:./target/lib/quasar-core-0.7.9-jdk8.jar -jar ./target/Quasar-Cglib-0.0.1-SNAPSHOT.jar

## Result
```
0
1
2
3
4
5
6
7
8
9
```

