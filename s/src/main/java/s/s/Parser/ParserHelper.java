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
    
}
