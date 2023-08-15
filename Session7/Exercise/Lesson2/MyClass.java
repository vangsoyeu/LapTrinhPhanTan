package com.example.javafxruntime.PracticeAndExercisesInClass.Session7.Exercise.Lesson2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyClass {
    public void hello() {System.out.println("hello");}
    public int sum(int numberA, int numberB) {
        int result = numberA + numberB;
        return result;
    }

    public static String mess() {
        String message = "Tin nhắn dành cho người cô đơn !!! Thk viết ra bài này del có cô đơn đâu :v";
        return message;
    }
}

class StaticMethodCheckExample {
    public static void main(String[] args) {
        // Tên của phương thức cần kiểm tra
        String methodName1 = "hello";
        String methodName2 = "sum";
        String methodName3 = "mess";

        // Lấy đối tượng Class tương ứng với tên lớp
        Class<?> clazz;
        try {
            clazz = Class.forName("com.example.javafxruntime.PracticeAndExercisesInClass.Session7.Exercise.Lesson2.MyClass");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy lớp");
            return;
        }

        // Lấy danh sách các phương thức của lớp
        Method[] methods = clazz.getDeclaredMethods();

        // Kiểm tra xem phương thức có phải là static hay không
        for (Method method : methods) {
            if (method.getName().equals(methodName3)) {
                boolean isStatic = Modifier.isStatic(method.getModifiers());
                if (isStatic) {
                    System.out.println("Phương thức " + methodName3 + " là static");
                } else {
                    System.out.println("Phương thức " + methodName3 + " không phải là static");
                }
                return;
            }
        }

        // Nếu không tìm thấy phương thức
        System.out.println("Không tìm thấy phương thức " + methodName3);
    }
}