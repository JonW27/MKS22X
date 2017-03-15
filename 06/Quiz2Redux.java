import java.util.*;
public class Quiz2Redux{
    public static ArrayList<String> combinations(String s){
      ArrayList<String>words = new ArrayList<String>();
      help(words, s, "", 0);
      System.out.println(words);
      Collections.sort(words);
      return words;
    }
    private static void help(ArrayList<String> words, String s, String formed, int index){
            if(index == s.length() && words.indexOf(formed) == -1){
                words.add(formed);
                return;
            }
            else if(index >= s.length()){
                return;
            }
            help(words, s, formed, index+1);
            help(words, s, formed+s.substring(index,index+1), index+1);

    }
}