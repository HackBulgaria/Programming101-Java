### 1. Add serialization to the Bank account exercise from last time
[Last time](https://github.com/HackBulgaria/Programming101-Java/tree/master/week06/2.Friday) you made a program which operates with bank accounts, as well as a command line interpreter for it. 

Using your existing solution, you must now add logic to save and restore the state of the program. This means that when you add bank accounts and do some transactions (add, witdraw, etc.) and restart the program, all of the accounts should be there with the exact same information as they were before the restart. Do this by writing everything to a file (when saving the state) and reading it from the file (when restoring the state).

Think of what the best way is and what the best place is to implement this logic.

### 2. Prepare utility methods for reading and writing to files

Create a class `FileUtils`. Make it a [Singleton](http://en.wikipedia.org/wiki/Singleton_pattern).
Implement two methods - `String readFrom(File file)` and `String readFrom(Path path)`.
They should read **all the contents** from the file to a String, using the default (OS-default) charset.
As this method is an **API**, you should NOT catch the exceptions in the method's body, remember?
For this task, do not worry about different encoding.
Do the same for a 'write' method.

### 3. Implement a 'Properties' file parser.
[.properties files](http://en.wikipedia.org/wiki/.properties) are commonly used in java as a resources and configuration. They just represent a key=value pairs, where each pair is a new line. The `#` sign denotes a comment.

Make a **utility** method `Map<String, String> parseProperties` that reads a .properties file and returns its content as a Map<String,String>.

The `#`-sign, when seen as a **first character in a line**,  denotes that **the line is a comment and should not be parsed**. 

```
# this=comment
a1=b1 
a2 =b2
a3    =    b3
   a4 = b4
a5=b6=b7=b8
a6=b9 #comment 
a7==b10
```
All of the above entries (`a1` to `a7`) are valid key-value pairs. 
The value for `a5` is `b6=b7=b8`
The value for `a6` is `b9 #comment`
The value for `a7` is `=b10`

Hints and suggestions:
- Use JUnit @Before, @BeforeClass, @After, @AfterClass http://stackoverflow.com/questions/20295578/difference-between-before-and-beforeclass
- Make a helper method, that does all the parsing logic (generates the Map from List<String>).
- Do **not** split the lines on your own like `fileContents.split("\n")`. This is not a cross-platform solution. 
- First test your helper method, which creates the Map from a given List<String>. 
- After assuring yourself your helper method works great, test the `parseProperties` method.
- Create (write) your .properties file (for testing) programmatically, in `setUp`. Do not depend on external resources for testing if you can avoid it!
- Do not polute the filesystem because you are writing tests. Clean up (delete the file in `tearDown`) after your each test run. Your file is relevant ONLY for the tests, and it should not outlive them. 

### 4. Implement the wc command

Create a **utility** method `WordCountResult wordCount(Path path)` with an overload `WordCountResult wordCount(File file)`.
This method, when given a file, returns the number of words, lines and characters in that file.
Java can't return multiple values. You can return an instance of `WordCountResult` which is a class that contains three integers - word count, lines count, characters count.

Follow the testing approach described in the previous task.

### 5. Fix these subtitles
Have you ever wanted to watch a movie, and all the cyrillic characters be like ������? 

Have you ever received emails like "Greetings, dear �������"?

These things happen because of different encoding and decoding schemes used.   

As we all know, even text files and strings are retained as binary in memory. 
So if we have the string 'Dumbledore', we need to store an array of bytes to represent it. 

The way we choose what bytes represent 'Dumbledore' in memory is called an **encoding scheme**. (a.k.a. encoding)
"windows-1251" is a type of encoding scheme.
"ISO-8859-1" is another type of encoding scheme.

The way we choose to convert it from a byte array to a char array is called a **decoding scheme**.

**Unicode** is an industry standard of encodings. There is no good reason against an Unicode encoding scheme.
UTF-8 is a good encoding scheme from the Unicode standard. (There are others, which differ slightly.)

So, here you are given a text file with a Windows-1251 encoding. Your task is to convert it to UTF-8. You can test this in your browser, just open the text file and choose to view it with UTF-8 encoding. (You might have to rename it to .html though)

The subtitle you need to fix are here: http://subsunacs.net/get.php?id=41854
It is okay not to use TDD for this one. 

In summary:
- Create a utility method `fixEncoding(Path path)`
- Backup the subtitles file so you don't have to download it again if you fail to write it.
- The text in the file given is encoded using a **windows-1251** scheme. 
- Conver it to UTF-8.

### 6. Reduce-file-path in 1 line
*This is a really quick one.*
Solve the [reduce-file-path problem (number 27)] (https://github.com/HackBulgaria/Programming101/blob/master/week0/simple_problems2.md) with no more than 1 line of Java code.
Check out [the normalize method] (http://docs.oracle.com/javase/7/docs/api/java/nio/file/Path.html#normalize%28%29)


### 7. Find all broken links in a given folder
A broken link is a link that points to something that is simply not there.   
Make a **utility** method that is given a folder (as a Path),  and searches recursively for bad links.  
If it finds a bad link, it should simply print it out.  

How to detect a bad link? Use `Files.isSymbolicLink(path)` in order to check if a file is a link, and `Files.readSymbolicLink(path)` in order to follow it and receive its target's path.


### 8. Implement a simple text file compression

Create a **utility** method `compress(Path filePath)`
that reads the text from `filePath` and writes it back in a compressed way, adding the `.compr` extension (or one of your choosing).

Let's have the file 
`buffalo buffalo buffalo rides a buffalo buffalo buffalo.`
There are a lot of repeating words here (duuh).

Parse all the words from a file, add them to an index, and assign them numbers.
Replace all the words in the file with their respective indices, prepending them with '~' or another letter of your choosing.
E.g. our sentence becomes

~0 ~0 ~0 ~1 ~2 ~0 ~0 ~0.

Implement a decompressing scheme (another **utility** method)

Check out the file compression you've just made : )


### BONUS: Find all duplicated files

##### Summary:
Two files are **duplicates** if all the **bytes** from file1 are the same as the **bytes** from file2.
Find and print out all touples of duplicate files.

##### Detailed

We are going to make a command line java tool, that receives a folder location and finds and prints outs all groups of duplicating files, ancestors of the given folder.
It is called like this:
```java
java -jar duplicates-finder.jar /home/georgi/Dev 

//Ouput below:
//Group A
/home/georgi/Dev/eclipse/settings.xml
/home/georgi/Dev/ADT/settings.xml //duplicate
/home/georgi/Dev/eclipse/plugins/default/settings.xml //duplicate

//Group B
/home/georgi/Dev/eclipse/update-site.xml
/home/georgi/Dev/ADT/update-site.xml //duplicate
/home/georgi/Dev/tmp/copies/site_backup.xml //duplicate

//Group C
/home/georgi/Dev/eclipse/readme.txt 
/home/georgi/Dev/workspace/Project1/data/readme.txt //duplicate

3 groups of duplications found.
A total of 5 duplicate files can be deleted, freeing up /*the sum of the lengths of those 5 files*/ disk space
...
```

All the files from Group A are equivalent (every file from Group A has the same contents).   
Same for group B and group C. As you can see, the **name** of the file does not matter.   
File A can be a duplicate of file B regardless of them having different names.


Hints:
- When visiting files, be careful with links. You should check if the file currently being visited is a link by using `Files.isSymbolicLink(Path)`. If the file happens to be a symbolic link, find and use **it's target**, by using `Files.readSymbolicLink(pathOfSymbolicLink);`.
- When following symbolic links in the way described above, be careful, because symbolic links may lead to files that **do not exist** (broken links). Your program should not stop working merely because it saw a broken link!
- Ignore files with size over 512KB. If we want our tool to work for large files, the task get's a little bit more interesting and non-trivial :)
- Be very careful when dealing with **OS-Special files (devices files)**. You should ignore them, as the OS call might block/hang when you try to read or write into of them. Use `Files.isRegular(path)` to check whether a file is a normal file, or it's a special file and we should probably not play with it.
- Create a folder `testData` in your project. Create several folders and files with which you can test your problem. If you are too lazy for that, just download and unzip [this test data] (https://github.com/HackBulgaria/Core-Java-1/blob/master/7-Files1/testData.zip) in your project.
[More spoilers and possible approaches] (https://gist.github.com/GeorgiPachov/039d2c339358dbfcc650)


### BONUS: MP3 organizer

Traverse a given directory recusrivelly and extract the ID3 tags from all mp3 files.
Use this information to give the mp3 files appropriate names in order to fix the titles. For instance Unknown Artist - Unknown Song should be renamed to Amaranthe - The Nexus (if you have good taste of course).
As a plus organize the files based on artist and album. For every artist create a directory, containing a directory for each of his albums. Move the songs into the respective albums.

Usage: `mp3organizer.jar "songs"`

Helpful links: 
http://javamusictag.sourceforge.net/
