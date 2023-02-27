package RegularExpression.Task.task2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Написать программу, выполняющую поиск в строке
 * шестнадцатеричных чисел, записанных по правилам Java,
 * с помощью регулярных выражений и выводящую их на страницу.
 */
public class Tsk2 {
    public static void main(String[] args) {
        String input = "0xFF xeihi 0X65784 jgjgi 0x758abc hjgh 3xabc jhgg 0j54ab";
        Pattern compile = Pattern.compile("0[Xx][a-fA-F0-9]+\\b");
        Matcher matcher = compile.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
