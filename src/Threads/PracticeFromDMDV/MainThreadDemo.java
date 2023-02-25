package Threads.PracticeFromDMDV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainThreadDemo {
    public static void main(String[] args) {
        String number = "+7 (778) 405-35-00"; //Создается текст из которого нужно искать шаблон
        Pattern pattern = Pattern.compile("\\+7 \\(\\d{3}\\) \\d{3} \\d{2} \\d{2}");  //Создает шаблон
        Matcher matcher = pattern.matcher(number);  //Ищет шаблон из текста
        System.out.println(matcher.matches()); // matches() вернет true, если текст совподает шаблоном
    }
}