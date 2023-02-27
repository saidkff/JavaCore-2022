package RegularExpression.Task.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 3. Написать программу, выполняющую поиск в строке всех тегов
 * абзацев, в т.ч. тех, у которых есть параметры, например <p id
 * ="p1">,
 * и замену их на простые теги абзацев <p>.
 */
public class Tsk3 {
    public static void main(String[] args) {
        String input = "<p> dicheihc </p>eidheih <p id=\"this is just string\"> dedehcrjn" +
                " </p> dehciehwxi <p id=75>s ihxihxe hi";

        String regex = "(<p .+?>)(.+?</p>)";

        String all = input.replaceAll(regex, "<p>$2");
        System.out.println(all);
    }
}
