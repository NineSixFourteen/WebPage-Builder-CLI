package s.s.Parser.CSSParser;

import java.util.ArrayList;

import org.apache.commons.lang.text.StrBuilder;

import s.s.CSS.CSSElement;
import s.s.CSS.CSSElementBuilder;
import s.s.CSS.Style;
import s.s.CSS.Type;

public class CSSParserHelper {

    public static CSSElement GrabElem(StrBuilder str){
        String name = GrabBefore(str, '{');
        String Bracs = GrabBefore(str, '}');
        String[] styles = Bracs.split(";");
        ArrayList<Style> stys = convertToStyle(styles);
        System.out.println(name);
        CSSElementBuilder ret = new CSSElementBuilder(name,Type.ELEM);
        for(Style sty : stys){
            ret.addStyle(sty);
        }
        return ret.build();
    }

    private static ArrayList<Style> convertToStyle(String[] styles) {
        ArrayList<Style> stls = new ArrayList<>();
        for(int i = 0; i < styles.length - 1; i++){
            stls.add(ToStyle.makeStyle(styles[i]));
        } 
        return stls;
    }

    private static String GrabBefore(StrBuilder str, char c){
        int ind = 0 ;
        while(str.charAt(ind) != c){
            ind++;
        }
        String ret = str.substring(0, ind);
        str.delete(0, ind + 1);
        return ret;
    }
    
}
