import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPrep{
  public static void main (String args[]){
    String input = "testing this fBADBADBADor between###.";
    String pattern = "BAD|#*";

    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(input);
    StringBuffer output = new StringBuffer();
    while(m.find()){
      m.appendReplacement(output, "");
    }
    m.appendTail(output);
    System.out.println(output);
  }
}
