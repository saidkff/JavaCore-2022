package ReflectionAPI.Tasks;

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
public class Demo {
    public static void main(String[] args) {
        Car car = new Car("Tayota", "Corolla");
        String temp = "INSERT INTO %s.%s (%s) VALUES (%s)";
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();
        String collect = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .peek(field -> field.setAccessible(true))
                .map(Field::getName)
                .collect(Collectors.joining(", "));

        String collect1 = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    try {
                        return String.valueOf(field.get(car));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(obj->"'" + obj + "'")
                .collect(Collectors.joining(", "));

        System.out.println(String.format(temp, table.scheme(), table.data(), collect, collect1));;
    }
}
