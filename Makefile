format:
	mvn formatter:format

package:
	mvn package

exec:
	mvn exec:java -Dexec.mainClass=animals.Main

run:
	java -jar target/building-zoo-1.0.jar

test:
	mvn test

mdpdf-install:
	npm install mdpdf -g

readme:
	mdpdf README.md

clean:
	mvn clean

dist:
	zip -9 -r --exclude=*.git* --exclude=*.idea* dist.zip .

sonar-docker:
	docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube

sonar:
	mvn sonar:sonar