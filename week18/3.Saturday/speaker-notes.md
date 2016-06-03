Plan
### 1. Some history
How did the compiling process start?
Java, javac, jar, jarsigner, shell scripts, makes, other tools
#### Age of IDEs?
#### Age of Ant 2000?
- Similiar to which program that you know?
- Ease to begin with (very low learning curve - hence the name)
- Targets, dependencies,
- Examples - it says 'how', not 'what' - tends to be more verbose. 
- Based on plugins
- Can actually still do quite a lot - scp, android, ssh, etc
- Dependency management was difficult
### Maven era
- Dependency  management over the network - hooray!
- Very, very rigid structure. Very standartized, concisely defined phases
- Relies on predefined phases, 'goals'
- Extensible via plugins
- Hard to write non-trivial build scripts with lot of intermediate steps - frequently had to write plugins
- Heavy, standartized, rigid XML - tend to become very very big without doing that much out of the ordinary
- Compiling a subset of the classes with maven is... interesting
### Honorable mention: Ivy
###### Okay, we got, ant, maven. Why gradle?
0. Power/flexibility of ant, lifecycle based like maven
1. Gradle wraps itself and carries itself in the project (unlike maven, nat)
2. Gradle versioning is intended to be source-controlled
3. Gradle runs on the Groovy language (e.g. apply plugin: is calling method 'apply' with plugin: java a key-value pair). Unlike ant and maven, NO XML here!
4. Gradle is the chosen build platform for all new android projects. The previous was 'ant'.
5. Used for polyglot builds (javascript/java/c++/android and more) - LinkedIn has over 60 languages in their toolchain and ... use gradle
6. Declarative modeling instead of implementation modelling (writing what you WANT to happen, not HOW)
7. Compatible with all old Maven/Nexus repos
8. http://twimgs.com/ddj/images/article/2014/0514/Gradle1.gif
9. Maven vs gradle codebase comparison http://www.drdobbs.com/jvm/why-build-your-java-projects-with-gradle/240168608
10. Backed by a professional company, but open source and community driven
11. Gradle is built... with gradle. You can also install it... with gradle
