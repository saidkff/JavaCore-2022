package RegularExpression.Task.JustFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JustJavaClass {
    public static void main(String[] args) {
        String input = "JustWord dc-bhe iey^dw seew!ij xiis%hxi";
        Pattern compile = Pattern.compile("\\b[\\w-^!%]+\\b");
        Matcher matcher = compile.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
