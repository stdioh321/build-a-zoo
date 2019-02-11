# Building a Zoo

### Prereq

* Java 8+
* Maven 3
* Make (Optional)

### How to run

```
mvn package
mvn exec:java -D"exec.mainClass=zoo.Main"
```

### Test

```
mvn test
```


### Features

1. List all zoo with their properties and friends’ names.

```
Menu.doListAllAnimals()
```

2. Live one day.

```
Menu.doLiveOneDay()
```

3. Exit.

```
Menu.doExit()
```
