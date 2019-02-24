# Overloading
## by different number of arguments
```java
public class MessageSender {
    public void send(String message) {
        // ...
    }
    public void send(String message, int retryCount) {
        // ...
    }
}
```
---
 # Overloading
## by different type of arguments
```java
public class MessageSender {
    public void send(String message) {
        // ...
    }
    public void send(Message message) {
        // ...
    }
}
```
---
# Constructor
## Default constructor
```java
public class A {
    private int i = 10;
}

void useA() {
    A a = new A();
}
```
---
# Constructor
## Parameterless constructor
```java
public class A {
    private int i = 10;
    public A() {}
}
```
---
# Constructor overloading

The same ways as overloading before

```java
public class A {
    private int i;
    public A() {
        i = 1;
    }
    
    public A(int i) {
        this.i = i;
    }
}
```
---
# Call constructor in other constructor

```java
public class A {
    private int i;
    public A() {
        this(1);
    }
    
    public A(int i) {
        this.i = i;
    }
}
```
---
# Static in class
Static is shared between instances

```java
public class A {
    public static int counter = 0;
    public A() {
        ++counter;
    }
}
// ... //
A a1 = new A();
A a2 = new A();
System.out.println("static: "+A.counter+", a1: "+a1.counter+", a2: "+a2.counter);
```
the result: `static: 2, a1: 2, a2: 2`
---
# Inheritance
A class can "extend" the API / functionality of an already existing class / specialize it (narrow it's codomain). 
```java
public class Base {
    public void print(String s) {
    	System.out.println(s);
    }
}
public class Sub extends Base {
	public void printTwice(String s) {
    	print(s);
        print(s);
    }
}
Sub s = new Sub();
s.print("Hey");
s.printTwice("Ho");
```
---
# Inheritance
A subclass can stand in place of a base class.
```java
Base b = new Sub();
b.print("Hey-ho!");
```
---
# Inheritance
## override
```java
public class Base {
    public void print(String s) {
    	System.out.println(s);
    }
}
public class Sub extends Base {
    @Override
	public void print(String s) {
    	print(s);
        print(s);
    }
}
Base b = new Sub();
b.print("Hey-ho!");
```
---
# Inheritance
## the problem of square and rectangle

In mathematics a square is a special rectangle. Is it a good idea to extend a Square (class) from a Rectangle (class)?

---
# Abstract class
Abstract classes can defere implementation.
```java
public abstract class Wallet {
	public abstract void pay();
}
public class MobileWallet extends Wallet {
    public void pay() {
        // implementationnof mobile payment
    }
}
```
---
# Abstract class example
```java
public abstract class TagPrinter {
	public void final print(String content) {
    	printOpen();
        System.out.println(content);
        printClose();
    }
    protected abstract void printOpen();
    protected abstract void printClose();
}
public class ParagraphPrinter extends TagPrinter {
    @Override
    protected void printOpen() { System.out.println("<p>"); }
    @Override
    protected void printClose() { System.out.println("</p>"); }
}
```
---
# Interface
Interfaces are "contracts" (used to be) pure abstract classes.

Since Java 8 an interface can have default implementation.

A class can **implement** mulitple interfaces at once.

---
# Interface
```java
public interface I {
	void a();
}
public class C implements I {
    @Override
	public void a() {
    	// body of a();
    }
}

I iInstance = new C();
iInstance.a();
```
---
# Interface
```java
public interface I {
	default void a() {
    	System.out.println("default a");
    }
}
public class C implements I { }
```
---
# Multiple inheritance with interfaces
```java
public interface I1 {
    void a();
}
public interface I2 {
    void b();
}
public class C implements I1, I2 {
    // the implementation of a() and b()
}
```
---
# Diamond inheritance
Pre Java 8 it is not a problem
```java
public interface I1 {
    void a();
}
public interface I2 {
    void a();
}
public class C implements I1, I2 {
    // the implementation of a()
}
```
---
# Diamond inheritance
With default methods:
```java
public interface I1 {
    default void a() { System.out.println("I1.a()"); } 
}
public interface I2 {
    default void a() { System.out.println("I2.a()"); } 
}
public class C implements I1, I2 {
    public void a() {
    	//I1.super.a();
        //I2.super.a();
        //or any local implementation
    }
}
```
---
# Exceptions
Exceptions are a way to propage erroneous cases to the caller.

The base class is `Throwable`

We have `Error` and `Exception` as subclasses.

---
# Checked and unchecked Exceptions

We throw checked exceptions on cases when the error is common.

We throw unchecked exceptions on cases which are programmer errors.

---
# RuntimeException

`RuntimeException` is the base class of every unchecked exception. (And it is a subclass of `Exception`)

---
# Throw an exception

```java
public void print(int[] a, int index) {
    if(i>=a.length) {
        throw new IllegalArgumentException("index is not bounds of array");
    }
    System.out.println(a[i]);
} 
public void printToFile(String fileName, String message) throws IOException {
    File f = new File(fileName);
    if(!f.exists()) {
        throw new IOException("file not found");
    }
    // write to file
}
```
---
# try - catch - finally
You can handle exceptions with catch clauses.

Finally is a block that is always executes.

```java
try {
    // call some "unsafe methods"
} catch (Exception e) {
	// handle e
} finally {
    // operations that should always run
}
```