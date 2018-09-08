package com.ashwin.demo.polymorphism.constructor;

import static com.ashwin.demo.util.Util.print;

class Meal {
    Meal() { print("Meal()"); }
}
class Bread {
    Bread() { print("Bread()"); }
}
class Cheese {
    Cheese() { print("Cheese()"); }
}
class Lettuce {
    Lettuce() { print("Lettuce()"); }
}
class Lunch extends Meal {
    Lunch() { print("Lunch()"); }
}
class PortableLunch extends Lunch {
    PortableLunch() { print("PortableLunch()");}
}
public class Sandwich extends PortableLunch {
    //Whenever you are calling an constructor/create object of specific class
    //member functions are callled first.
    //So after initializing this call, followin b,c & l members are executed & then constuctor Sandwicch()
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    //In the constructor hierarchy the top-level class in hierarchy is executed first & then followed by derived class
    //until most derived class is reached.
    public Sandwich() { print("Sandwich()"); }
    public static void main(String[] args) {
        new Sandwich();
    }

}

