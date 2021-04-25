all: doc cls 

cls:
	
	cd src; javac Game/*.java -d ../classes
	cd src; javac WarGame/*.java -d ../classes
	cd src; javac FarmGame/*.java -d ../classes

	

doc:
	javadoc -d ../docs -subpackages Game
	javadoc -d ../docs -subpackages FarmGame
	javadoc -d ../docs -subpackages WarGame


guerre.jar:
	cd classes; jar cvfm ../guerre.jar ../manifest-guerre WarGame
	
agricole.jar:
	cd classes; jar cvfm ../agricole.jar ../manifest-agricole FarmGame
	

clean:
	rm -r classes/*
	rm -r docs/*

.PHONY: clean all

