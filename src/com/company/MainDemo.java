package com.company;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 1. Создать класс Car с полями String brand и String model.
 * Создать аннотации @Table (принимает название схемы и таблицы
 * в базе данных) и @Column (принимает название колонки в таблице
 * базы данных). Пометить класс аннотацией @Table и поля
 * аннотацией @Column. Написать программу, принимающую
 * объект класс  Car c проинициализированными полями и
 * составляющую запрос "INSERT" в виде строки на основании
 * данных объекта.
 *     Пример: дан объект Car car = new Car("Toyota", "Corolla");
 *     Программа, принимающая этот объект, должна вывести в консоль строку:
 * "INSERT INTO garage.car (model, brand) VALUES ('Toyota', 'Corolla');"
 */
public class MainDemo {
    public static void main(String[] args) {
        Car car = new Car("Tayota", "Corolla");
        String template = "INSERT INTO %s.%s (%s) VALUES (%s);";
        String scheme = car.getClass().getAnnotation(TestTable.class).scheme();
        String dataName = car.getClass().getAnnotation(TestTable.class).dataName();

        Field[] fields = car.getClass().getDeclaredFields();
        String collect = Arrays.stream(fields)
                .peek(field -> field.setAccessible(true))
                .map(Field::getName)
                .collect(Collectors.joining(", "));

        String collect1 = Arrays.stream(fields)
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    try {
                        return String.valueOf(field.get(car));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(", "));
        System.out.println(String.format(template, scheme, dataName, collect, collect1));
    }
}
