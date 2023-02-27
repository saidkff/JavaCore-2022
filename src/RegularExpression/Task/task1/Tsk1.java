package RegularExpression.Task.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Написать программу, проверяющую, является ли введённая
 * строка адресом почтового ящика.
 * В названии почтового ящика разрешить использование только
 * букв, цифр и нижних подчёркиваний, при этом оно должно
 * начинаться с буквы.
 * Возможные домены верхнего уровня: .org .com
 */
public class Tsk1 {
    public static void main(String[] args) {
        String input = "zavokhir2002@gmail.com";
        Pattern compile = Pattern.compile("[a-zA-Z]+\\w*@[a-zA-Z]{2,6}\\.(com|ru|uz|kz)");  //Нужно читать документацию
        Matcher matcher = compile.matcher(input);                                                 // "\\w" сокращенная форма [a-zA-Z0-9], мы можем заменить \\. на [.]
        System.out.println(matcher.matches());                                                    // "+" -> Один или более, "*" -> Ноль или более
    }
}
