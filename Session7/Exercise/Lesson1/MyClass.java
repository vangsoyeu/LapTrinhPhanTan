package com.example.javafxruntime.PracticeAndExercisesInClass.Session7.Exercise.Lesson1;

import java.lang.reflect.Constructor;

public class MyClass {
    private int id;
    private String name;

    public MyClass() {}
    public MyClass(int id) {
        id = this.id;
    }
    public MyClass(String name) {
        name = this.name;
    }
    public MyClass(int id, String name) {
        id = this.id;
        name = this.name;
    }
}


class ConstructorListExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // Lấy danh sách các constructor của class
        Class<?> clazz = Class.forName("com.example.javafxruntime.PracticeAndExercisesInClass.Session7.Exercise.Lesson1.MyClass");

        // Lấy dang sách các constructor của class
        Constructor<?>[] constructors = clazz.getConstructors();

        //Liệt kê danh sách các constructor
        System.out.println("Constructors in Class:");
        for (Constructor<?> constructor: constructors) {
//            System.out.println(constructor);
            // Lấy tên constructor
//            String constructorName = constructor.getName();

            // Lấy danh sách tham số của constructor
//            Parameter[] parameters = constructor.getParameters();

            // Biến đổi danh sách các tham số thành một mảng kiểu dữ liệu
//            String[] parameterTypes = Arrays.stream(parameters)
//                    .map(Parameter::getType)
//                    .map(Class::getSimpleName)
//                    .toArray(String[]::new);

            // Hiển thị thông tin của constructor
//            String constructorInfo = constructorName + "(" + String.join(", ", parameterTypes) + ")";
//            System.out.println(constructorInfo);

            // Cách 2:
            // Lấy thông tin đầy đủ của constructor bằng cách sử dụng toGenericString()
            String constructorInfo = constructor.toGenericString();
            System.out.println(constructorInfo);
        }
    }
}


/*sau khi lấy danh sách tham số của mỗi constructor bằng cách sử dụng constructor.getParameters(),
* chúng ta sẽ biến đổi danh sách các tham số thành một mảng kiểu dữ liệu bằng cách sử dụng Arrays.stream()
* và map() để lấy tên đơn giản của kiểu dữ liệu (Class.getSimpleName()). Cuối cùng, chúng ta sẽ sử dụng
* String.join() để nối các kiểu dữ liệu lại thành một chuỗi và hiển thị thông tin của constructor bằng cách in ra constructorInfo.*/
