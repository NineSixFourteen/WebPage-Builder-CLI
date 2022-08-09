package s.s.HTML;

import java.util.ArrayList;

public class Element {
    ElementID id; 
    Object msg;

    public Element(ElementID id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public Element(ElementID id, ArrayList<Element> elems){
        this.id = id; 
        this.msg = elems; 
    }

    public String toString(int ind) {
        StringBuilder sb = new StringBuilder();
        for (int i =0 ; i < ind;i++){
            sb.append("\t");
        }
        switch(msg.getClass().getSimpleName()){
            case "String":
                switch(this.id){
                    case H1:
                        sb.append("<h1>").append((String) this.msg).append("</h1>");
                        break;
                    case P:
                        sb.append("<p>").append((String) this.msg).append("</h1>");
                        break;
                    case TH:
                        sb.append("<th>").append((String) this.msg).append("</th>");
                        break;
                    default:
                        sb.append("Error");
                        break;

                }
            case "ArrayList":
                switch(this.id){
                    case Div: 
                        sb.append("<Div>");
                        for(Element e : (ArrayList<Element>) this.msg){
                            sb.append(e.toString(ind + 1));
                        }
                        sb.append("</Div>");
                    default: 
                        sb.append("Error");
                }
            default: sb.append("ERROR : " + msg.getClass().getSimpleName());
        }
        return sb.toString();

    }
}
