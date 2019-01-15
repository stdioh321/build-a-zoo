format:
	mvn formatter:format

package:
	mvn package

exec:
	mvn exec:java -Dexec.mainClass=animals.Main

run:
	java -jar target/building-zoo-1.0.jar

mdpdf-install:
	npm install mdpdf -g

readme:
	mdpdf README.md

clean:
	mvn clean
