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
        sb.replaceAll(" ", "").replaceAll("\n","");
        System.out.println(sb);
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
        int end = ParserHelper.lookForEnd("</tr>", sb);
        StrBuilder rows = new StrBuilder(sb.substring(4, end));
        System.out.println("row");
        System.out.println(rows);
        sb.delete(0, end + 5);
        while(!rows.isEmpty()){
            String str = rows.substring(1, 3);
            end = ParserHelper.lookForEnd("</" + str + ">", rows); 
            strs.add(rows.substring(4, end));
            rows.delete(0, end + 5);
            System.out.println("rows");
            System.out.println(rows);
            System.out.println(rows.isEmpty());
        }
        return strs;
    }
    

}
