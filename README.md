_OOP course Exercise #1_  
_Authors [@ElhaiAgassi]() & [@Danielle Musai](https://github.com/DanielleMusai)_

---

# Observer Design Pattern Project
The `observer` design pattern is a behavioral design pattern that defines a one-to-many dependency between objects. When one `object`, the subject, changes state, all of its dependents, the `observers`, are notified and updated automatically.

This pattern is often used in GUI applications where multiple objects need to be updated in response to changes in a shared object. It allows for loose coupling between objects, as the subject and its observers do not need to know each other's implementation details.

In this project, we have implemented the observer design pattern using the following classes:
___
## Classes

### Member interface
The `Member` interface defines the methods that must be implemented by any object that is to be registered as an observer of a subject.

### Sender interface
The `Sender` interface defines the methods that a sender object should implement. This includes methods to register and unregister observers, and methods to manipulate the shared object.

### GroupAdmin class
The `GroupAdmin` class implements the Sender interface, which defines methods to `register` and `unregister` Member objects, as well as methods to insert and `append` strings to the `UndoableStringBuilder` object, `delete` strings from the UndoableStringBuilder, and `undo` previous actions on the UndoableStringBuilder.  
The `GroupAdmin` class has a `notifyObservers` method that is called whenever there is a change to the `UndoableStringBuilder`. This method iterates through the list of registered `Member` objects and calls their `update` method, passing in the current state of the `UndoableStringBuilder` as an argument.

### ConcreteMember class
The `ConcreteMember` class is a concrete implementation of the Member interface. This class represents a member who is registered to receive updates from a GroupAdmin. When the update method is called, the ConcreteMember class updates its internal copy of the UndoableStringBuilder object with the current state of the shared `UndoableStringBuilder`.

## Usage
To use the GroupAdmin and ConcreteMember classes in a program, first create a GroupAdmin object and a ConcreteMember object. Then, register the ConcreteMember with the GroupAdmin using the register method. Finally, call the insert, append, delete, or undo methods on the GroupAdmin object to modify the shared UndoableStringBuilder object. The ConcreteMember object will be automatically notified of the change and will update its internal copy of the UndoableStringBuilder.

___
## Part B

In the second part we were asked to track the size of the object in the heap.
We found out that one of the parameters for checking the efficiency of the code is the size of the object in the JVM memory.
In addition, we saw that in the JvmUtilities class there are 3 static methods that we used to test the efficiency.

- The method objectFootprint - shows all the references
that the object contains the size of each reference (including overhead)

- the method objectTotalSize - displays the total size of
the object. This method is most relevant to us in this assignment.

- The jvmInfo method – displays the process ID of the JVM
and the total amount of memory for the benefit of the program.

___

## UML

<img width="440" alt="image" src="https://user-images.githubusercontent.com/92378800/208301330-5d76893a-ede2-4417-b0d6-3f906bf3ab5f.png">
