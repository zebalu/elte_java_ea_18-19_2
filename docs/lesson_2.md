# Values and References
## Value
```java
int i = 10;
int j = i;
j++;
System.out.println("i: "+i+", j: "+j);
```
result:
```
i: 10, j:11
```
---

# Values and References
## Reference
```java
StringBuilder sb1 = new StringBuilder();
StringBuilder sb2 = sb1;
sb2.append("Hello");
System.out.println(sb1.toString()+", "+sb2.toString());
```
result:
```
Hello, Hello
```
---

# Execution stack and Heap

* Execution stack is filled by method frames on method calls, and automaticaly cleand on method returns.
* Heap is populated by objects and cleaned by the garbage collector

---

# Public and Private

* We set a variable or method `public` if we want to make it accessible to the whole world.
* We set a variable or method `privat` if it is only matters to the object (or class).

---

# Two "rule of thumb"s

* variables should be `private`
* only the "services" of the object should be `public`

---

# getters and setters

```java
public class A {
    int i;
    
    int getI() {
        return i;
    }
    
    void setI(int i) {
        this.i = i;
    }
}
```
