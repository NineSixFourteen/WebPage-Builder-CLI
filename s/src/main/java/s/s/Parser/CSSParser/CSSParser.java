package s.s.Parser.CSSParser;

import org.apache.commons.lang.text.StrBuilder;

import s.s.CSS.CSSPageBuilder;

public class CSSParser {
    
    public static CSSPageBuilder parsePage(String page){
        StrBuilder sb = 
         new StrBuilder(page)
         .replaceAll('\r', ' ')
         .replaceAll('\n', ' ');
        CSSPageBuilder pb = new CSSPageBuilder();
        while(true){
            while(!sb.isEmpty() && sb.charAt(0) == ' ') sb.deleteCharAt(0);
            if(!sb.isEmpty()){
                pb.addElement(CSSParserHelper.GrabElem(sb));
            } else {
                break;
            }
        }
        
        return pb;
    }
    
}
