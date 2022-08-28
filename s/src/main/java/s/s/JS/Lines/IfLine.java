package s.s.JS.Lines;

import java.util.ArrayList;

public class IfLine implements Line {

    private String condition;
    private ArrayList<Line> lines; 

    public IfLine(String condition, ArrayList<Line> lines){
        this.condition = condition;
        this.lines = lines;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("if(")
         .append(condition)
         .append("){\n");
        for(Line line : lines){
            line.codeGen(sb);
        }
        sb.append("}\n");

    }
    
}
