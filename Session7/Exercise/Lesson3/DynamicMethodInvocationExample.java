package com.example.javafxruntime.PracticeAndExercisesInClass.Session7.Exercise.Lesson3;

import java.lang.reflect.Method;

public class DynamicMethodInvocationExample {
    public static void main(String[] args) {
        try {
            // Tạo một đối tượng Class đại diện cho lớp cần gọi phương thức
            Class<?> clazz = Class.forName("com.example.javafxruntime.PracticeAndExercisesInClass.Session7.Exercise.Lesson3.MyClass");

            // Lấy đối tượng Method của phương thức cần gọi
            Method method = clazz.getMethod("myMethod", String.class, int.class);

            // Tạo một đối tượng động để gọi phương thức
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // Gọi phương thức trên đối tượng động
            ((Method) method).invoke(obj, "Hello", 123);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyClass {
    public void myMethod(String str, int num) {
        System.out.println("myMethod called with arguments: " + str + ", " + num);
    }
}

