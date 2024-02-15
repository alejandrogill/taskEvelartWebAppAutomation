package utils;

import com.vdurmont.emoji.EmojiParser;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static int countCaracters(String caracter, String text){
        List<String> emojis =  EmojiParser.extractEmojis(text);

        int count =0;
        for (int i = 0; i < emojis.size(); i++)
            if(EmojiParser.parseToUnicode(emojis.get(i)).equals(EmojiParser.parseToUnicode(caracter)))
                count++;
        return count;
    }

    public static int operationResult(String operation){
        List<String> terminos= new ArrayList<String>();
        String termino="";
        boolean neg= false;
        for (int i = 0; i < operation.length(); i++) {
            if (operation.charAt(i)=='+' | operation.charAt(i)=='-'){
                terminos.add((neg ? "-":"") +termino);
                termino="";
                neg= operation.charAt(i)=='-';
            }
            else
                termino=termino+operation.charAt(i);
        }
        terminos.add((neg ? "-":"") +termino);
        int value=0;
        for (String termi:terminos) {

            if (termi.contains("*")){
                int subValue=1;
                for (String factor:termi.split("\\*"))
                    subValue=subValue*Integer.parseInt(factor);
                value+=subValue;
            }
            else
                value+=Integer.parseInt(termi);
        }
        return value;
    }
}
