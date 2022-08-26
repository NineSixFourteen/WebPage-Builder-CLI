package s.s.Parser.HTMLParser;

import java.util.ArrayList;

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
        int cBrac = 0;
        while(sb.charAt(cBrac) != '>'){
            cBrac++;
        }
        StrBuilder rows = new StrBuilder(sb.substring(cBrac + 1, end));
        sb.delete(0, end  + Tag.length() + 3);
        return rows;
    }

    public static ArrayList<String> scanTag(StrBuilder sb){
        ArrayList<String> info = new ArrayList<>();
        info.add(checkID(sb.toString()));
        info.add(checkClass(sb.toString()));
        info.add(grabTag(sb).toString());
        return info;
    }

    private static String checkID(String info) {
        StrBuilder sb = new StrBuilder(info);
        while(!sb.isEmpty()){
            if(!sb.startsWith("id")){
                if(sb.charAt(0) == '>'){
                    return "";
                }
                sb.deleteCharAt(0);
            } else {
                sb.deleteCharAt(3);
                int ind = 0;
                while(ind < sb.length() && sb.charAt(ind) != '"'){
                    ind++;
                }
                if(ind >= sb.length()){
                    return "";
                }
                return sb.substring(0, --ind);
            }
        }
        return "";
    }

    private static String checkClass(String info) {
        StrBuilder sb = new StrBuilder(info);
        while(!sb.isEmpty()){
            if(!sb.startsWith("class")){
                if(sb.charAt(0) == '>'){
                    return "";
                }
                sb.deleteCharAt(0);
            } else {
                sb.deleteCharAt(6);
                int ind = 0;
                while(ind < sb.length() && sb.charAt(ind) != '"'){
                    ind++;
                }
                if(ind >= sb.length()){
                    return "";
                }
                return sb.substring(0, --ind);
            }
        }
        return "";
    }
    
}
