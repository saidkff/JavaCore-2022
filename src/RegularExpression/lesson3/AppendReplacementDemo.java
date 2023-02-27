package RegularExpression.lesson3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppendReplacementDemo {
    public static void main(String[] args) {


        String input = "Электронная почта: jo%hn@example.com, jane@example.com, " + "admin@example.com, sal-e.sSSS@example.com 9e2e7297e";

        // Создаем регулярное выражение для поиска адресов электронной почты
        Pattern pattern = Pattern.compile("\\b[\\w.%-]+@[\\w.-]+\\.[a-z]{2,4}\\b");

        // Создаем объект Matcher, который будет искать совпадения
        Matcher matcher = pattern.matcher(input);

        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, "YYYYY@XXXX.FFF");
        }
        matcher.appendTail(buffer);


        System.out.println(buffer);

//        ------------------------------------------------
//        String output = matcher.replaceAll("Hello");
//        System.out.println(output);
//        ---------------------------------------------
//        // Перебираем все совпадения и выводим их на консоль
//        while (matcher.find()) {
//            String email = matcher.group();
//            System.out.println(email);
//        }
    }
}