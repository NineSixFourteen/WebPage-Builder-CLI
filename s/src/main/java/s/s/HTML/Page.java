package s.s.HTML;

import java.util.ArrayList;

import s.s.HTML.ElementFactory.Element;

public class Page {

    String Title;
    ArrayList<Element> body; 
    
    public Page() {
        Title = "";
        body = new ArrayList<>(); 
       } 

    public ArrayList<Element> getBody() {
        return body;
    }

    public Page append(Element s){
        body.add(s);
        return this;
    }

    @Override
    public String toString() {
        return makeString(0, new StringBuilder(), this.body).toString();
    }

    public StringBuilder makeString(int ind, StringBuilder sb, ArrayList<Element> body) {
        StringBuilder space = new StringBuilder(); 
        for(int i = 0; i < ind;i++){
            space.append("  ");
        }
        String start = space.toString();
        for(Element elem : body){
            sb.append(start);
            switch(elem.getId()){
                case Div:
                    sb.append("<div>\n");
                    ArrayList<Element> elems = elem.getElements();
                    makeString(ind + 1 , sb, elems);
                    sb.append(start).append("</div>\n");
                    break;
                case Heading:
                    sb.append("<h1> ")
                     .append(elem.getString())
                     .append("</h1>\n");
                    break;
                case P:
                    sb.append("<p> ")
                     .append(elem.getString())
                     .append(" </p>\n");
                    break;
                case Table:
                    sb.append("<table>\n")
                     .append(start)
                     .append("  <tr>\n");
                    Table t = elem.getTable();
                    for(String title : t.getTitles()){
                        sb.append(start)
                         .append("    <th>")
                         .append(title)
                         .append("</th>\n");
                    }
                    sb.append("  </tr>\n");
                    for(String[] row : t.getContents()){
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
                    break;
                case List:
                    makeList(sb, start, elem.getList());
                    break;
                default:
                    break;
            }
        }
        return sb;
    }

    private StringBuilder makeList(StringBuilder sb, String space, LList list){
        switch(list.getType()){
            case 0:
                sb.append("<ul>\n");
                for(String elem : list.getElems()) {
                    sb.append(space)
                    .append("  <li>")
                    .append(elem)
                    .append(" </li>\n");
                }
                sb.append(space).append( "</ul>\n");
                break; 
            case 1: 
            sb.append("<ol>\n");
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
                sb.append("<dl>\n");
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
