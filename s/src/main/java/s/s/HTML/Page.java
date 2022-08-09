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

    public Page append(Element s){
        body.add(s);
        return this;
    }

    @Override
    public String toString() {
        return makeString(0, new StringBuilder()).toString();
    }

    public StringBuilder makeString(int ind, StringBuilder sb) {
        StringBuilder space = new StringBuilder(); 
        for(int i = 0; i < ind;i++){
            space.append("  ");
        }
        String start = space.toString();
        for(Element elem : body){
            sb.append(start);
            switch(elem.getId()){
                case Div:
                    break;
                case Heading:
                    sb.append("<h1> ")
                     .append(elem.getString())
                     .append(" </h1>\n");
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
                default:
                    break;
            }
        }
        return sb;
        
    }
    
}
