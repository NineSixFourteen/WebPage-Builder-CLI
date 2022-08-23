package s.s.Parser;

import java.util.ArrayList;

import org.apache.commons.lang.text.StrBuilder;

import s.s.HTML.Table;
import s.s.HTML.TableBuilder;

public class TableParser {

    public static Table getTable(String message) {
        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        TableBuilder tb = new TableBuilder(0,0);
        StrBuilder sb = new StrBuilder(message);
        while(!sb.isEmpty()){
            rows.add(getRow(sb));
        }
        tb.setTitles(rows.get(0).toArray(new String[0]));
        tb.setBody(rows.subList(1,rows.size()).toArray(new String[0][0]));
        return tb.build();
    }

    public static ArrayList<String> getRow(StrBuilder sb) {
        ArrayList<String> strs = new ArrayList<>();
        while(sb.startsWith("<tr>"))sb.deleteCharAt(0);
        int end = ParserHelper.lookForEnd("</tr>", sb);
        StrBuilder rows = new StrBuilder(sb.substring(4, end));
        sb.delete(0, end + 1);
        while(!rows.isEmpty()){
            while(rows.charAt(0) == '<')rows.deleteCharAt(0);
            String str = sb.substring(1, 3);
            end = ParserHelper.lookForEnd("</" + str + ">", rows); 
            strs.add(rows.substring(4, end));
            rows.delete(0, end);
        }
        return strs;
    }
    

}
