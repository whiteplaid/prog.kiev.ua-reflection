package com.homework.reflection.homework1;
public class TestClass {
    @Test(a = 2, b = 5)
    private static int testObj(int a, int b){
        int result = a + b;
        return result;
    }
}