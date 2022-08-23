package s.s.Parser;

import org.apache.commons.lang.text.StrBuilder;

public class ParserHelper {

    public static int lookForEnd(String str, StrBuilder sb) {
        int ind = 0;
        while(!sb.isEmpty() && !sb.startsWith(str)){
            sb.deleteCharAt(0);
            ind++;
        }
        if(sb.isEmpty()){
            throw new Error("U DONE FUCKED UP");
        }
        return ind + str.length();
    }
    
}
