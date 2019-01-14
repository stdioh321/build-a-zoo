format:
	mvn formatter:format

package:
	mvn package

exec:
	mvn exec:java -Dexec.mainClass=animals.Main

clean:
	mvn clean
