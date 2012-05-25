JAVAC=javac
JAVA=java

SOURCE=.
SOURCE_FILES=$(SOURCE)/*.java
CLASS_FILES=$(SOURCE)/*.class


main: compile

compile:
	$(JAVAC) $(SOURCE_FILES) 

run: compile
	java game

clean:
	rm $(CLASS_FILES) *~