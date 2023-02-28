package RegularExpression.Task.JustFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например <p id
 * ="p1">,
 * и замену их на простые теги абзацев <p>.
 */
public class TempFile {
    public static void main(String[] args) {
        String input = "<p id=\"helloWorld\"> Hello my name is Murod</p>" +
                " <p id=\"JustDoIt\"> I am Bakhodir</p>" +
                " <p id=\"JustCodeIt\"> My name is Zhavokhir</p>";
        Pattern compile = Pattern.compile("(<p .+?>)(.+?</p>)");
        String all = input.replaceAll(String.valueOf(compile), "<p>$2");
        System.out.println(all);
    }
}
