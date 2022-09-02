package s.s.JS.Lines;


import java.util.ArrayList;

import s.s.JS.Expression.Expression;

public class ForLine implements Line {

    private String var;
    private String value; 
    private Expression condition;  
    private Line   oLine;
    private ArrayList<Line> lines;

    public ForLine(String var, String value, Expression condition2, Line oLine, ArrayList<Line> lines) {
        this.var = var;
        this.value = value;
        this.condition = condition2;
        this.oLine = oLine;
        this.lines = lines;
    }

    @Override
    public void codeGen(StringBuilder sb){
        sb.append("for( let ")
         .append(var)
         .append(" = ")
         .append(value)
         .append(" ; ")
         .append(condition.value());
        oLine.codeGen(sb);
        sb.deleteCharAt(sb.length() - 1); // delete new line 
        sb.deleteCharAt(sb.length() - 1); // delete semi-colan
        sb.append(" ){\n");
        for(Line line : lines){
            line.codeGen(sb);
        }
        sb.append("}\n");
    }
}
