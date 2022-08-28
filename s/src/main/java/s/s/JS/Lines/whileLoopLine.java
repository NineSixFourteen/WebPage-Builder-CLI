package s.s.JS.Lines;

import java.util.ArrayList;

public class whileLoopLine implements Line {

    private String conditon;
    private ArrayList<Line> lines;

    public whileLoopLine(String condition, ArrayList<Line> lines){
        this.conditon = condition;
        this.lines = lines;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("while(")
         .append(conditon)
         .append(" ){\n");
        for(Line line : lines){
            line.codeGen(sb);
        }
        sb.append("}\n");
    }
    
}
