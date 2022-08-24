package s.s.Parser;

import org.apache.commons.lang.text.StrBuilder;

import s.s.HTML.PageBuilder;
import s.s.HTML.Table;


public class HTMLParser {

    public static PageBuilder parsePage(String page){
        StrBuilder sb = new StrBuilder(page);
        PageBuilder pb = new PageBuilder();
        int end;
        String message ;
        while(!sb.isEmpty()){
            if(sb.startsWith("<table")){
                end = ParserHelper.lookForEnd("</table>",sb);
                message = sb.substring(6, end );
                System.out.println("lol");
                System.out.println(message);
                getTable(pb, message);
            } else if(sb.startsWith("<h") && sb.charAt(2) > 48 && sb.charAt(2) < 58){
                int level = sb.charAt(2) - 48;
                end = ParserHelper.lookForEnd("</h" + level + ">",sb);
                message = sb.substring(3, end);
                getHead(pb,message,level);
            } else if(sb.startsWith("<p")){
                end = ParserHelper.lookForEnd("</p>",sb);
                message = sb.substring(2, end );
                getPara(pb,message);
            } else {
                end = 1;
                message = "";
            }
            sb.delete(0, end);
        }
        return pb;
    }

    private static void getPara(PageBuilder pb, String message) {
        int ind = findClose(message);
        String info = message.substring(0, ind);
        message = message.substring(ind + 1);
        System.out.println(message);
        String ID = checkID(info);
        String classs = checkClass(info);
        pb.addParagraph(message, ID, classs);
    }

    private static void getHead(PageBuilder pb, String message, int level) {
        int ind = findClose(message);
        String info = message.substring(0, ind);
        message = message.substring(ind + 1);
        String ID = checkID(info);
        String classs = checkClass(info);
        pb.addHeading(message, level, ID, classs);
    }

    private static void getTable(PageBuilder pb, String message) {
        int ind = findClose(message);
        String info = message.substring(0, ind);
        String ID = checkID(info);
        String classs = checkClass(info);
        message = message.substring(ind + 1);
        Table tab = TableParser.getTable(message);
        pb.addTable(tab, ID, classs);
    }

    private static int findClose(String message) {
        int ind = 0;
        while(message.charAt(ind) != '>'){
            ind++;
        }
        return ind;
    }

    private static String checkID(String info) {
        StrBuilder sb = new StrBuilder(info);
        while(!sb.isEmpty()){
            if(!sb.startsWith("id")){
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
