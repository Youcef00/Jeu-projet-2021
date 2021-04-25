all: doc cls 

cls:
	javac src/Game/*.java -d ../classes
	javac src/Game/util/*.java -d ../classes
	javac FarmGame/*.java -d ../classes
	javac WarGame/*.java -d ../classes
	javac -classpath tests/*.java

doc:
	javadoc -d ../docs -subpackages Game
	javadoc -d ../docs -subpackages FarmGame
	javadoc -d ../docs -subpackages WarGame


clean:
	rm -f classes/*
	rm -f docs/*

.PHONY: clean all

