# More Problems with Collections

##1.Given a list of Students, sort them by grade

Lets say you have a `List<Student>`, where a Student is a class, containing two fields: `name` and `grade`.

Sort them by their grades first. Their grades actually are integers => 2,3,4,5,6. If two students happen to have the same grades, sort those two by their names.

##2.Implement a class ToDoList

Imagine you have a world of stuff to do.
Homeworks, courseworks, exams, even preparing for HackBulgaria!
Unfortunately you do not have much time - you need to eat, you need to sleep, you need to have a good time.

Now, you need to sort your priorities right! Make a class `ToDoList`, which supports the following operations:
`void add(Task t)`
`void markFinished(Task t)`
`void markCancelled(Task t)`
`Task getTop()`
`boolean canFinish()`
`int getRemainigTime()` //calculates the time remaining after you've done all of your tasks.

... where `Task` is a class which represents something you have to do. What data/methods should it have? What is common for all the tasks you need to get done?
A `Task` should at the very least have a priority and a time required in order to finish.
You should take an integer in your constructor - the ammount of hours available for each task.

Example usage of your class:

```java
ToDoList todo = new ToDoList(11); //11 hours remaining!
todo.addTask(new StudyForAlgebraTask(10)); //maximum priority!
todo.addTask(new LearnGeometryTask()); //default priority, smaller than 10
todo.addTask(new GoOutTask(1.5f));  //default priority, smaller than 10
todo.addTask(new SleepTask()); //straight 8 hours, of course!

if (todo.canFinish()){
    System.out.println("Woohoo!");
} else {
    System.out.println("I am ...screwed :(");
}

System.out.println(todo.top()) //StudyForAlgebraTask
System.out.println(todo.getTimeNeeded()) //sum of the time needed for every task added in todo list
```

*Hints*
See Comparable and Comparator classes in Java. Check out the PriorityQueue class.
http://javarevisited.blogspot.com/2011/06/comparator-and-comparable-in-java.html

##3.Implement your own HashMap.

It's up to choose how to resolve colisions.
Use this link to see the most common approaches:
https://en.wikipedia.org/wiki/Hash_table

Make it iterative - one step at time.

First make the basic functionality.
You should be able to put, get and check if a given key is already in the map.

Then make it resizable.
You can choose 0.75 for load factor.

When it is resizable and you can try to make it a bit generic.

Finally your class can implement the Map interface.