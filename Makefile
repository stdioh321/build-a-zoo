format:
	mvn formatter:format

package:
	mvn package

exec:
	mvn exec:java -Dexec.mainClass=animals.Main

run:
	java -jar target/building-zoo-1.0.jar

clean:
	mvn clean
