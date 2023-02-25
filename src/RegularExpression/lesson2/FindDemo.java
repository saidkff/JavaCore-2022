package RegularExpression.lesson2;

import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDemo {
    public static void main(String[] args) {
        String someText = "+7 (778) 405 35-00owjoxj +7 (908) 736 92-73odcomie+7 (326) 862 82-28osjjw+7 (114) 826 12-34fgt";
        Pattern compile = Pattern.compile("\\+7 ?\\((?<group>\\d{3})\\) (\\d{3}) (\\d{2})-(\\d{2})");

        StringBuilder stringBuilder = new StringBuilder();   // Для записи нового текста
        Matcher matcher = compile.matcher(someText);
        while(matcher.find()){
            matcher.appendReplacement(stringBuilder, "$2 $3 $4");      //Если найдем шаблона, то заменяем с 2, 3, 4 группой
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder);

//        matcher.appendReplacement(stringBuilder, "****"); //Все тексты которые подходит шаблону будут заменены на "****"

//        String all = someText.replaceAll(String.valueOf(compile), "$2 - $3 - $4");  // Через знак доллара можно обратится к группам из шаблона
//        System.out.println(all); //Здесь можно заглянуть структуру метода replaceAll. Он принимает текст шаблона и текст для замены. 21:55 25.02.2023
    }
}
