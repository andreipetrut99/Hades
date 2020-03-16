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

default: build

build: $(CLASSES:.java=.class)
		jar cfm Etapa1.jar MANIFEST.MF *.class
		java -jar Etapa1.jar
		#cp Etapa1.jar /mnt/c/WinBoard-4.8.0/Winboard
		#cd /mnt/c/WinBoard-4.8.0/Winboard
		#./winboard.exe -debug -fcp "java -jar ./Etapa1.jar"
		#java -jar Etapa1.jar
		#java -classpath /mnt/c/Users/Eduard\ Păunoiu/Desktop/Hades-master/src/Etapa1.jar Main

#run: 	jar cfm Etapa1.jar MANIFEST.MF *.class
#		java -jar Etapa1.jar

clean: $(RM) $*.class