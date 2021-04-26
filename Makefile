all: cls guerre.jar agricole.jar  guerre-multi.jar agricole-multi.jar



cls:
	
	cd src; javac Game/*.java -d ../classes
	cd src; javac WarGame/*.java -d ../classes
	cd src; javac FarmGame/*.java -d ../classes

	

doc:
	javadoc -d ../docs -subpackages Game
	javadoc -d ../docs -subpackages FarmGame
	javadoc -d ../docs -subpackages WarGame


guerre.jar:
ifeq ("$(wildcard ./classes/WarGame/*.class)", "")
	make cls
endif
	cd classes; jar cvfm ../jar/guerre.jar ../jar/manifests/manifest-guerre WarGame Game

guerre-multi.jar:
ifeq ("$(wildcard ./classes/WarGame/*.class)", "")
	make cls
endif	
	cd classes; jar cvfm ../jar/guerre-multi.jar ../jar/manifests/manifest-guerre-multi WarGame Game

agricole-multi.jar:
ifeq ("$(wildcard ./classes/FarmGame/*.class)", "")
	make cls
endif	
	cd classes; jar cvfm ../jar/agricole-multi.jar ../jar/manifests/manifest-agricole-multi FarmGame Game
		
agricole.jar:
ifeq ("$(wildcard ./classes/FarmGame/*.class)", "")
	make cls
endif
	cd classes; jar cvfm ../jar/agricole.jar ../jar/manifests/manifest-agricole FarmGame Game
	

clean:
	rm -f jar/*.jar
	rm -r classes/*
	rm -r docs/*

.PHONY: clean all

