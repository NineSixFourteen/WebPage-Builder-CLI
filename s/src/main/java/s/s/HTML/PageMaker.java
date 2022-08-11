package s.s.HTML;

import java.util.ArrayList;

import s.s.HTML.ElementFactory.Element;

//Make a string with a html page From Page

public class PageMaker {

    Page page;

    public PageMaker(Page page){
        this.page = page;
    }

    @Override
    public String toString() {
        return makeString(0, new StringBuilder(), page.getBody()).toString();
    }

    public StringBuilder makeString(int ind, StringBuilder sb, ArrayList<Element> body) {
        StringBuilder space = new StringBuilder(); 
        for(int i = 0; i < ind;i++){
            space.append("  ");
        }
        String start = space.toString();
        for(Element elem : body){
            sb.append(start);
            switch(elem.getType()){
                case Div:
                    sb.append("<div>\n");
                    ArrayList<Element> elems = elem.getElements();
                    makeString(ind + 1 , sb, elems);
                    sb.append(start).append("</div>\n");
                    break;
                case Heading:
                    makeHeading(sb, start, elem);
                    break;
                case P:
                    sb.append("<p")
                     .append(additionalInfo(elem))
                     .append("> ")
                     .append(elem.getString())
                     .append(" </p>\n");
                    break;
                case Table:
                    makeTable(sb, start, elem);
                    break;
                case List:
                    makeList(sb, start, elem);
                    break;
                default:
                    break;
            }
        }
        return sb;
    }

    private void makeHeading(StringBuilder sb, String start, Element elem) {
        String tag; 
        Heading heading = elem.getHeading();
        switch(heading.getLevel()){
            case 1: 
                tag = "h1";
                break;
            case 2: 
                tag = "h2";
                break;
            case 3: 
                tag = "h3";
                break;
            default:
                tag = "h4";
        }
        sb.append("<")
         .append(tag)
         .append(" ")
         .append(additionalInfo(elem))
         .append("> ")
         .append(heading.getMsg())
         .append(" </")
         .append(tag)
         .append(">\n");
    }

    private String additionalInfo(Element elem) {
        StringBuilder sb = new StringBuilder();
        if (elem.getClasss() != "") {
            sb.append(" class=\"")
             .append(elem.getClasss())
             .append("\"");
        }
        if (elem.getId() != "") {
            sb.append(" id=\"")
            .append(elem.getClasss())
            .append("\"");
        }
        return sb.toString();
    }

    private StringBuilder makeTable(StringBuilder sb, String start, Element elem){
        Table tab = elem.getTable();
        sb.append("<table ")
        .append(additionalInfo(elem))
        .append(">\n")
        .append(start)
        .append("  <tr>\n");
       for(String title : tab.getTitles()){
           sb.append(start)
            .append("    <th>")
            .append(title)
            .append("</th>\n");
       }
       sb.append("  </tr>\n");
       for(String[] row : tab.getContents()){
           sb.append(start)
            .append("  <tr>\n");
           for(String cont : row ){
               sb.append(start)
                .append("    <td>")
                .append(cont)
                .append("</td>\n");
           }
           sb.append(start)
            .append("  </tr>\n");
       }
       sb.append("</table>\n");
       return sb;
    }

    private StringBuilder makeList(StringBuilder sb, String space, Element elems){
        LList list = elems.getList();
        switch(list.getType()){
            case 0:
                sb.append("<ul")
                .append(additionalInfo(elems))
                .append(">\n");
                for(String elem : list.getElems()) {
                    sb.append(space)
                    .append("  <li>")
                    .append(elem)
                    .append(" </li>\n");
                }
                sb.append(space).append( "</ul>\n");
                break; 
            case 1: 
            sb.append("<ol")
            .append(additionalInfo(elems))
            .append(">\n");
            for(String elem : list.getElems()) {
                sb.append(space)
                .append("  <li>")
                .append(elem)
                .append(" </li>\n");
            }
            sb.append(space).append( "</ol>\n");
                break;
            case 2: 
                boolean b = true; 
                sb.append("<dl")
                .append(additionalInfo(elems))
                .append(">\n");
                for(String elem : list.getElems()) {
                    if (b) {
                        sb.append(space)
                        .append("  <dt>")
                        .append(elem)
                        .append(" </dt>\n");
                    } else {
                        sb.append(space)
                        .append("  <dd>")
                        .append(elem)
                        .append(" </dd>\n");
                    }
                    b = !b;
                }
                sb.append(space).append( "</dl>\n"); 
                break;
            default : //error
        }
        return sb;
    }

}