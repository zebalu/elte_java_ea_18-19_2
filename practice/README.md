# Exam

The exams will be in the following times:

* 2019.05.27 13:00-17:00
* 2019.06.04 13:00-17:00
* 2019.06.11 09:00-13:00
* 2019.06.18 09:00-13:00

If you have come to any of the exams above (or have a valid medical paper to prove you were unable to participate) and did not get a passing mark (or want to get a better one), than you can come to one of these events:

* 2019.07.03 10:00-14:00
* 2019.07.03 14:00-18:00

All exams are held in __Lovard__, __Nyelvi labor__ and __AB labor__.

## Consultation

I will hold a consultation at __2019.05.24 14:00-16:00__ where we can discuss your questions. Please come prepared with exact questions and don't just expect a "replay" of the semester.

# Practice exercise

The following exercise is similar to the exam. It is not compulsory, but can help.

## ZOO

Create a miniature registry system of a Zoo.

### 1. Animal

Create an `abstract` class: `Aniaml`. Every `Animal` has a name which should be not accessible directly but through access methods. `Animal` should also have an unchangeable `String` property that describes its species latin name. `Animal` should have __2__ `abstract` subclasses:
1. Carnivore
2. Herbivore

### 2. Petable

Create an __interface__, called `Petable`. `Petable` has only __1__ method: `pet` which does not return anything, and takes no argument. When some `Animal` is `pet()`-ed, than a message should appear on the screen with the noise the animal makes, to express their joy.

### 3. Some animals

Create the following classes:

1. `Dog` should be a `Petable` `Carnivore` (`Dog`s __bark__ when they are happy.)
2. `Goat` should be a `Petable` `Herbivore` (`Goat`s say __maa__ when they are happy.)
3. `Tiger` should be a `Carnivore` (and no `Tiger` is `Petable`)
4. `Hippopotamus`should be a `Herbivore` (and no `Hippopotamus` is `Petable`)

### 4. Cage

Create a class called `Cage`.
* Every `Cage` should get a type parameter what kind of `Animal` it keeps. (It should only accept `Animal`s)
* A `Cage` should hold animals in a `Container`.
* A `Cage` must have an `add` method to add more `Animal`s into it.
* A `Cage` can tell how many `Animal` it holds
* A `Cage` can be a __lonely__ `Cage` in this case, it can only hold __1__ `Animal`, and should raise `CageIsFullException` if somebody tries to add a new `Animal` into it.

### 5. The whole Zoo

Create a __runnable__ class called `Zoo`. In the `Zoo` create `Cage`s for all type of `Animal`s and put at least __2__ `Animal`s into them. Except the `Tiger`'s `Cage` which should be a __lonely__ `Cage` with only __1__ `Tiger`. Don't forget to `pet` all the `Petable` `Animal`s.

# Practice test questions

1. Is there multiple inheritance in Java?
2. What are the _9_ base types in Java?
3. What is the difference between checked and unchecked Exceptions?
4. What is polymorphism?
5. What would this code segment print to the screen:

```java
        int i = 0;
        try {
            ++i;
            throw new RuntimeException();
        } catch (RuntimeException re) {
            i=i+1;
        } catch (Exception e) {
            i=i+2;
        }
        System.out.println(i);
```

