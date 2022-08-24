package s.s.Parser;

import java.util.ArrayList;
import java.util.List;

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
        String[][] RS = new String[rows.size() - 1][];
        int i = 0;
        for(List<String> str : rows.subList(1, rows.size())){
            RS[i++] = str.toArray(new String[0]);
        }
        tb.setBody(RS);
        return tb.build();
    }

    public static ArrayList<String> getRow(StrBuilder sb) {
        ArrayList<String> strs = new ArrayList<>();
        StrBuilder rows = ParserHelper.grabTag(sb);
        while(true){
            while(rows.startsWith(" ")) rows.deleteCharAt(0);
            if(!rows.isEmpty()){
                strs.add(ParserHelper.grabTag(rows).toString());   
            } else {
                break;
            }
        }
        while(sb.startsWith(" ")) sb.deleteCharAt(0);
        return strs;
    }
    

}
