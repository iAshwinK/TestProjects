package com.ashwin.demo.primitive;

import static com.ashwin.demo.primitive.Print.print;
import static com.ashwin.demo.primitive.Print.printnb;

public class PrimitiveTest {

//    void f2(byte x) { printnb("f2(byte) "); }
//    void f2(short x) { printnb("f2(short) "); }
    void f2(double x) { printnb("f2(double) "); }

    void testShort() {
        short x = 0;
        printnb("short: ");
        f2(x); print();
    }

    public static void main(String[] args) {
        PrimitiveTest p =
                new PrimitiveTest();
        p.testShort();
    }


}
