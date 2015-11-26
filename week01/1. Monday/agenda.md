### Agenda #1 ###
- Представете се
- Малко организационно:
    - как ще протече курса: 
    - прочели сте вкъщи материала, който ще използваме днес,
    - тук разказваме и обобщаваме материала,
    - решаваме задачи и четем още материали тук
    - и накрая решавате още повече и четете материали за следващия път вкъщи.
- Java - a little history
    + started as 'Oak' in 1991 => дъб
    + Created by Sun 
    + renamed to 'java', due to large ammounts of coffee the team used in development
    + released 1995
    + James Gosling
    + Brian Goetz(threading), Tim Peierls(threading), Joshua Bloch(annotations, collections, try-with-resource), Doug Lea (threading), Mark Reinhold(module system), Alex Buckley(generics), Neal Gafter(javac) (http://enos.itcollege.ee/~jpoial/allalaadimised/jdk7/jls7.pdf)
    + Java
    + Compile once, run everywhere
    #1 Development Platform
    9 Millions Developers
    1 Billion Java Downloads per Year
    3 Billion devices run Java
    97% of Enterprise Desktops run Java
    100% of BLU-RAY Disc Players ship with Java
    http://www.javacodegeeks.com/2014/03/java-facts-to-blow-your-mind.html
    Jit Compiler in J2SE (Java 1.2)
- Java, JRE, JVM, JDK
- JSR, JCP
- JSE, J2EE, J2ME
- Sun, Oracle, Google
- Cross-platform, compatibility
- Javac
- classpath

//what IDE does for us
C:\>javac -sourcepath src -classpath classes;lib\Banners.jar ^
            src\farewells\GoodBye.java -d classes
//source and target explanations
C\:>javac -sodurce 1.6 -target 1.6 -bootclasspath C:\jdk1.6.0\lib\rt.jar ^
            -extdirs "" OldCode.java

//bootclasspath option

- javap
- the javadoc tool
- jar format 
- Common VM Arguments

- if possible - Welcome to Eclipse
-Coding style format import
-Import Preferences and Quick Keys setup (Refactor Menu, Create getter, setter)
-Hello world from Eclipse
-Packages,Eclipse Views
