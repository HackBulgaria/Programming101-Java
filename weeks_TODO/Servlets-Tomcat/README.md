### 1. Servlet/HelloWorld
- Create an Http Servlet. Override the `doGet` method, and write 'HelloWorld!' to the response's outputStream.
- Run your application on Eclipse ('Run as Server').
- See your own message at 'localhost:8080/YourAppName/YourServletName'
- Make your servlet respond at 'localhost:8080/YourAppName/' (Edit the @WebServlet annotation path to '/')
- See that your servlet now responds at 'localhost:8080/YourAppName/'
- Now undo your change (restore the @WebServlet annotation path).
- Right click on your project -> Java EE tools -> Generate Deployment descriptor stub. 
- - You will now have a 'web.xml' file. It is called a deployment descriptor.
- - Edit the deployment descriptor, and add a first welcome-file tag pointing to 'YourServletName'. We want to register the servlet as a welcome page for your server :)
- Check the 'html source code' returned by your servlet. You will see no HTML tags. Why?
- Write an HTML response to your client. For instance `<h1>Now that's a big title!</h1>`

Congratulations. You've just witnessed what ASP/JSP/PHP is all about. We are not going to do any of that ~~sh**~~ stuff.


### 2. Simple news agregator
Do you know what an [RSS](http://en.wikipedia.org/wiki/RSS) is?   
It is a simple format for describing **content** (just the content, and not it's visualization). It is an XML-based format.  

[This is an RSS](http://www.sportal.bg/uploads/rss_category_2.xml)
Your task is simple - create a service (using just a servlet), that shows the latest news **in bulgarian** in the following categories:  
- General/Bulgaria  
- Technology  
- Sport   

Write the ~~ugliest~~ simplest html output you possibly can.  
Something like is completely OK.   
![this](http://i.imgur.com/uZvmOlRl.jpg)


If you don't know HTML, it's okay, just check http://www.w3schools.com/html/html_basic.asp You'll learn a few tricks in no time.  

Hints:
- Pick some RSS feed links from popular news websites. Dnevnik.bg, sportal.bg, etc have RSS feed functionality. Maybe even FMI had one?  
- Do not parse the XML yourself. There are libraries for that, use the ones given in this github folder (the ROME library).  
- Add both jars in the WEB-INF/lib folder. Don't do anything after that, Eclipse will automatically add them to the project's build path.  
- Use this ROME tutorial: http://blog.manishchhabra.com/2011/10/rome-library-example-for-parsing-rss-and-atom-feeds/  
  

### 3. Simple JSON pretty printer service.
Just look at the JSON at http://hackbulgaria.com/api/checkins . It is horrible - completely unreadable. What are the elements? What are the JSON objects? You cannot easily tell.

- Deploy a servlet, that accepts a named "POST" parameter "json". 
- Read the json as a POST parameter given to the request (as a parameter from the `HttpServletRequest` via the `getParameter` method.)
- Use google gson to pretty-print the json given.
- See how to it here:  http://stackoverflow.com/questions/4105795/pretty-print-json-in-java
