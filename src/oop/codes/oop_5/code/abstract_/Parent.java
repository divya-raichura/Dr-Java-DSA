package src.oop.codes.oop_5.code.abstract_;

public abstract class Parent {
    int age;

    public Parent(int age) {
        this.age = age;
    }

    abstract void career();

    // we cannot create abstract constructors
//    abstract Parent();

    // can't create static abstract methods
    // but we can create static methods
    static void hey() {
        System.out.println("Hey, this is static method in parent");
    }

    // not overridden anywhere
    void hello() {
        System.out.println("Hello, this is normal method not overridden in parent");
    }

    // overridden in the child classes
    void hi() {
        System.out.println("Hi, this is normal method in parent and this is overriden");
    }

}
