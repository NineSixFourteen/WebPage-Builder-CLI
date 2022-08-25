package s.s.Parser.HTMLParser;

import java.util.ArrayList;

import org.apache.commons.lang.text.StrBuilder;

import s.s.HTML.ListBuilder;
import s.s.HTML.PageBuilder;
import s.s.HTML.Table;


public class HTMLParser {

    public static PageBuilder parsePage(String page){
        StrBuilder sb = 
         new StrBuilder(page)
         .replaceAll("\n",""); // Remove Spaces and New Lines
        PageBuilder pb = new PageBuilder();
        while(!sb.isEmpty()){
            if(sb.startsWith("<table")){
                getTable(pb, sb);
            } else if(sb.startsWith("<h") && sb.charAt(2) > 48 && sb.charAt(2) < 58){
                getHead(pb,sb);
            } else if(sb.startsWith("<p")){
                getPara(pb,sb);
            } else if(sb.startsWith("<ol")){
                getList(pb,sb, 0);
            } else if(sb.startsWith("<ul")){
                getList(pb,sb, 1);
            } else if(sb.startsWith("<dl")){
                getList(pb,sb, 2);
            } else {
                sb.deleteCharAt(0);
            }
        }
        return pb;
    }

    private static void getList(PageBuilder pb, StrBuilder message, int i) {
        ArrayList<String> info = ParserHelper.scanTag(message);
        StrBuilder items = new StrBuilder(info.get(2));
        ArrayList<String> strs = new ArrayList<>();
        while(true){
            while(items.startsWith(" ")) items.deleteCharAt(0);
            if(!items.isEmpty()){
                strs.add(ParserHelper.grabTag(items).toString());   
            } else {
                break;
            }
        }
        pb.addList(
            new ListBuilder(i).addElems(strs.toArray(new String[0])).Build(),
            info.get(0), info.get(1));
    }

    private static void getPara(PageBuilder pb, StrBuilder message) {
        ArrayList<String> info = ParserHelper.scanTag(message);
        pb.addParagraph(info.get(2), info.get(0), info.get(1));
    }

    private static void getHead(PageBuilder pb, StrBuilder message) {
        int level = message.charAt(2) - 48;
        ArrayList<String> info = ParserHelper.scanTag(message);
        pb.addHeading(info.get(2), level, info.get(0), info.get(1));
    }

    private static void getTable(PageBuilder pb, StrBuilder message) {
        ArrayList<String> info = ParserHelper.scanTag(message);
        Table tab = TableParser.getTable(info.get(2));
        pb.addTable(tab, info.get(0), info.get(1));
    }

}
