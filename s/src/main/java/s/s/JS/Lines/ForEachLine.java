package s.s.JS.Lines;

import java.util.ArrayList;

public class ForEachLine implements Line {

    private String itemName; 
    private String listName;
    private ArrayList<Line> lines;


    public ForEachLine(String itemName, String listName, ArrayList<Line> lines) {
        this.itemName = itemName;
        this.listName = listName;
        this.lines = lines;
    }



    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("for( ")
        .append(itemName)
        .append(" : ")
        .append(listName)
        .append("){\n");
        for(Line line : lines){
            line.codeGen(sb);
        }
        sb.append("}\n");
    }
    
}
