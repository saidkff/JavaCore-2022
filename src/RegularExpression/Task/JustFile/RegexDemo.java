package RegularExpression.Task.JustFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        String text = "Привет! Мой адрес электронной почты abc123@gmail.com, а у моего друга def456@yahoo.com. Не забудьте мне написать!";
        String regex = "\\b[\\w.%-]+@[\\w.-]+\\.[A-Z]{2,4}\\b";
        // регулярное выражение ищет адреса электронной почты, состоящие из букв, цифр и символов: %, ., -, @
        // адреса могут содержать доменные имена с точками и дефисами, а также верхнеуровневые домены длиной от 2 до 4 символов

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); // компилируем регулярное выражение
        Matcher matcher = pattern.matcher(text); // создаем Matcher для входной строки

        while (matcher.find()) {
            System.out.println("Найден адрес электронной почты: " + matcher.group());
        }
    }
}
