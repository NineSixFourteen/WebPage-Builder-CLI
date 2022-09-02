package s.s.JS.Lines;

import java.util.ArrayList;

import s.s.JS.Expression.Expression;

public class whileLoopLine implements Line {

    private Expression conditon;
    private ArrayList<Line> lines;

    public whileLoopLine(Expression condition, ArrayList<Line> lines){
        this.conditon = condition;
        this.lines = lines;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("while(")
         .append(conditon.value())
         .append(" ){\n");
        for(Line line : lines){
            line.codeGen(sb);
        }
        sb.append("}\n");
    }
    
}
