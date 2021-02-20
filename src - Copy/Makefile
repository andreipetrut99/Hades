JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		Board.java \
		Constants.java \
		Main.java \
		MoveGenerator.java

default: build run clean

build: $(CLASSES:.java=.class)
		jar cfm Hades.jar MANIFEST.MF *.class
	
run: 
	java -jar Hades.jar

clean: 
	$(RM) *.class
