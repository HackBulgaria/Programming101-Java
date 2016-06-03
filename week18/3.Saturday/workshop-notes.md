#### 1. Install gradle
sudo add-apt-repository ppa:cwchien/gradle  
sudo apt-get update  
sudo apt-get install gradle  

#### 2. Create your first build.gradle file
echo apply plugin: 'java' > build.gradle  
gradle build  
Examine the resulting tasks and map it to a project   build lifecycle!

#### 3. Reinitialize build file
Delete your build.gradle file    
Initialize your java project (with gradle wrapper)  
`gradle init --type java-library`

### 4. Great, we have a java project. How do we edit this?
But where does the IDE come in?  
`apply plugin: 'eclipse'` at the top,
then run `'gradle eclipse'`
Examine now the newly created files (ls -lah)
Try and import the project in Eclipse!

### 5. Add dependency to your project - commons lang
compile group: 'org.apache.commons', name:'commons-lang3', version:'3.0'

### 6. It does not compile in eclipse? Why?

### Run Gradle eclipse

### 7. Make 'gradle eclipse' run every time a 'gradle build' is invoked
tasks.getByName("build").dependsOn "eclipse"

### Behold - graph configuration API
Java plugin task dependency picture

### Create your own task and plug it in!
task hodor << {
 5.times { println "HOLD THE DOOOOR" }
}

### Create main method and run your program WITHOUT distributing it
apply plugin: 'application'
mainClassName = 'com.hackbulgaria.com.test.Main'
gradle run

### Generate a Fat Jar!
Excercise for the reader : )

### Download mkyong's exmaple https://github.com/mkyong/spring4-mvc-gradle-xml-hello-world
run it via gradle jettyRun
examine the code!

