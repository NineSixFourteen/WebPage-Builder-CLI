package s.s.JS.Lines;

import java.util.ArrayList;

import s.s.JS.Expression.Expression;

public class IfLine implements Line {

    private Expression condition;
    private ArrayList<Line> lines; 

    public IfLine(Expression condition, ArrayList<Line> lines){
        this.condition = condition;
        this.lines = lines;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("if(")
         .append(condition.value())
         .append("){\n");
        for(Line line : lines){
            line.codeGen(sb);
        }
        sb.append("}\n");

    }
    
}
