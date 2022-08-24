package s.s.Parser;

import org.apache.commons.lang.text.StrBuilder;

public class ParserHelper {

    public static int lookForEnd(String str, StrBuilder sb) {
        sb = new StrBuilder(sb.toString());
        int ind = 0;
        while(!sb.isEmpty() && !sb.startsWith(str)){
            sb.deleteCharAt(0);
            ind++;
        }
        if(sb.isEmpty()){
            throw new Error("U DONE messed UP" + str);
        }
        return ind;
    }

    public static String getTag(StrBuilder sb){
        while(sb.startsWith(" ")) sb.deleteCharAt(0);
        if(sb.charAt(0) != '<'){
            throw new Error("No start with tag " + sb.toString() );
        }
        StringBuilder sbr = new StringBuilder(); 
        int ind = 1;
        while(!(sb.charAt(ind) == '>') && !(sb.charAt(ind) == ' ')){
            sbr.append(sb.charAt(ind++));
        }
        return sbr.toString();

    }

    public static StrBuilder grabTag(StrBuilder sb ) {

        String Tag = getTag(sb);
        int end = ParserHelper.lookForEnd("</" + Tag + ">", sb);
        StrBuilder rows = new StrBuilder(sb.substring(4, end));
        sb.delete(0, end  + Tag.length() + 3);
        return rows;
    }
    
}
