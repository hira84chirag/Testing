package test;
class ClassB {
    public void methodB() {
        System.out.println("Method from Class B has been called.");
    }
}

// Class C with a simple method.
class ClassC {
    public void methodC() {
        System.out.println("Method from Class C has been called.");
    }
}
public class ClassA {

    public static void main(String[] args) {
        // --- Method 1: Composition (The most common approach) ---
        // Composition means that one class contains an instance of another class.
        // It models a "has-a" relationship (e.g., Class A "has a" Class B).
        System.out.println("--- Accessing methods using Composition ---");
        ClassB objB = new ClassB();
        objB.methodB();
        ClassC objC= new ClassC();
        objC.methodC();
        
     // Let's create a nested class to show the concept simply.
        class Inheritor extends ClassA {
            public void inheritedMethod() {
                // This method could access methods from a parent class if A had any.
                System.out.println("This is an inherited method.");
            }
        }
        ClassA aInstance = new ClassA();
        aInstance.runMethods();
    }
    public void runMethods() {
        System.out.println("--- Re-running Composition logic from a method in ClassA ---");
        ClassB bObject = new ClassB();
        ClassC cObject = new ClassC();

        bObject.methodB();
        cObject.methodC();
    }
  }