*In short, what is a servlet?*
http://stackoverflow.com/questions/7213541/what-is-java-servlet

*This is how you create your first servlet*
http://www.journaldev.com/1854/java-web-application-tutorial-for-beginners

*If you want to learn more about servlets here is a short book (or an extended tutorial)*
http://pdf.coreservlets.com/Servlet-Basics.pdf

*And of course, Oracle's documentation on servlets __#tl;dr__*
http://docs.oracle.com/javaee/6/tutorial/doc/bnafe.html

*Eclipse EE*  
https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunar

*TomEE JAX-RS*  
http://www.apache.org/dyn/closer.cgi/tomee/tomee-1.7.1/apache-tomee-1.7.1-jaxrs.zip

### Stop the Tomcat instance launched from Eclipse
Shutdown Eclipse's use of tomcat. We will not let Eclipse manage tomcat for us this time.  
Forget Run as -> Server. We won't be using that again.

If you do not have running Tomcat instance from Eclipse, you don't have to do anything.  
Else, just click on the red button in the'Servers' view. 

(If you've just launched Eclipse, you don't have to do anything)

### Check out tomcat's installation directory
-Go to your tomcat installation directory. For me, it was `/home/georgi/Dev/tomcat/`
-Do an `ls` and notify me when you get there. 

- `tomcat/bin` => All the binaries for tomcat. If you need to start or stop tomcat, there are the binaries you need.
- `tomcat/conf` => All the configuration files for tomcat. tomcat-user.xml and others
- `tomcat/webapps` => The most important folder of all. You must delpoy your web applications here. 'Deploying' means copying one .war file to your webapps dir.

One web application = one .war file. It's like a .jar file, but it means 'webarchive' (.war).

-Start your tomcat using `startup.sh` or `startup.bat` in the `<your-tomcat-dir>/bin/` folder.

-Go to http://localhost:8080 . Do you see the cat? You need to see the cat.  
-Now take a look at http://localhost:8080/examples/

-Take a note - if you let eclipse manage your tomcat, you won't see neither a cat nor examples.

-Edit the tomcat-users.xml file in `your-tomcat-dir/conf`. See the commented lines and add *2 roles* one with a `rolеname="manager"` and the other with a `rolеname="manager-gui"`.
-Create a user with username "a" and password "a" with the role of "manager-gui"
-Create a user with username "test" and password "test" with the role of "manager"
-Save tomcat-users.xml

-Open http://localhost:8080/manager . Authenticate with "a"/"a".
-What you are seeing now is something called the "Tomcat Manager". Here you can see what applications do you have deployed, which of them are running, etc. If you have any problems with web applications, that's the place to check first:
-1) Your web application should be DEPLOYED
-2) Your web application should be RUNNING

### In Eclipse
- Create your Dynamic Web project. Name your project 'NewsService'.
- Create a servlet echoing "Hello World!" to the writer in the `doGet` method
- Add apache's commons-io library.

