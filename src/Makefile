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
		#cp Etapa1.jar /mnt/c/WinBoard-4.8.0/Winboard
		#cd /mnt/c/WinBoard-4.8.0/Winboard
		#./winboard.exe -debug -fcp "java -jar ./Etapa1.jar"
	
run: 
	java -jar Hades.jar

clean: 
	$(RM) *.class
