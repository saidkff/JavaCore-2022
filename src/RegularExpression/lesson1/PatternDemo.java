package RegularExpression.lesson1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class PatternDemo {
    public static void main(String[] args) {
        String number = "+7 405 35-00";
        Pattern format = Pattern.compile("\\+7 (\\(\\d{3}\\))? ?\\d{3} \\d{2}-\\d{2}");

        Matcher matcher = format.matcher(number);
        if (matcher.matches()){
            System.out.println("That is correct number!");
        }
        else{
            System.out.println("That is not correct number!");
        }
    }
}
