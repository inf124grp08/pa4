build: clean
	javac -d WEB-INF/classes/ src/Product.java
	javac -d WEB-INF/classes/ src/Category.java
	javac -d WEB-INF/classes/ src/Database.java
	javac -d WEB-INF/classes/ src/DataHelper.java
	javac -d WEB-INF/classes/ src/*Servlet.java

restart:
	-tstop
	tstart

clean:
	rm -rf WEB-INF/classes/*
