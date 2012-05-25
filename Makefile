JAVAC=javac
JAVA=java

SOURCE=.
SOURCE_FILES=$(SOURCE)/*.java
CLASS_FILES=$(SOURCE)/*.class
MAIN_CLASS=Game

run: compile
	$(JAVA) $(MAIN_CLASS)


compile:
	$(JAVAC) $(SOURCE_FILES) 


clean:
	rm $(CLASS_FILES) *~