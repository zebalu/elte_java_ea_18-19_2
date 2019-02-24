# Java versions

We will focus on **Java 8** (which is  a short name for Java 1.8.0\_\*), and will mention parts of **Java 11** (Java 1.11.0\_\*)

---

# Languange specification

where to look for help?

[Java 8](https://docs.oracle.com/javase/specs/jls/se8/html/index.html)

[Java 11](https://docs.oracle.com/javase/specs/jls/se11/html/index.html)

---

# Types in java

There are **9** basic types in Java:

8 primitives:
* byte
* short
* int
* long
* boolean
* float
* double
* char

+1 reference type: **Object**

---
# Sructure of a Java program

A Java program is made of **objects** that are defined by **classes** that are organised in **packages**.

```java
package hu.example;

public class ExampleClass {

    public static void main(String[] args) {
        ExampleClass exampleObject = new ExampleClass();
    }
}
```

---

# Byte code

Java programs are _compiled_ to **byte code** which is *interpreted* **and** *compiled* by the Java Virtual Machne (**JVM**) in runtime.

---

# Reference version of primitives

Every primitive can be turned into a reference type:

* byte --> Byte
* short --> Short
* int --> **Integer**
* long --> Long
* boolean --> Boolean
* float --> Float
* double --> Double
* char --> **Character**

