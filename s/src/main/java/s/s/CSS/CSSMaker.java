package s.s.CSS;

import java.util.ArrayList;

public class CSSMaker {

    private CSSPage page; 

    public CSSMaker(CSSPage page){
        this.page = page;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(CSSElement elem : page.getElements()){
            switch(elem.getType()){
                case CLASS:
                    sb.append(".")
                     .append(elem.getName())
                     .append("{\n")
                     .append(styles(elem.getStyles()))
                     .append("\n}");
                    break;
                case ELEM:
                    sb.append(elem.getName())
                     .append("{\n")
                     .append(styles(elem.getStyles()))
                     .append("}\n\n");
                    break;
                case ID:
                    sb.append("#")
                     .append(elem.getName())
                     .append("{\n")
                     .append(styles(elem.getStyles()))
                     .append("\n}");
                    break;
                default:
                    break;

            }
        }
        return sb.toString();
    }

    private String styles(ArrayList<Style> styles) {
        StringBuilder sb = new StringBuilder();
        for(Style style : styles){
            sb.append("   ")
             .append(
                style.getType().toString()
                .replace("_", "-")
                .replace("colour", "color"))
             .append(": ")
             .append(style.getValue())
             .append(";\n");
        }
        return sb.toString();
    }
    
}
