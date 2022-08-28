package s.s.JS.Lines;

import java.util.ArrayList;

public class ForLine implements Line {

    private String var;
    private String value; 
    private String condition;  
    private Line   oLine;
    private ArrayList<Line> lines;

    public ForLine(String var, String value, String condition, Line oLine, ArrayList<Line> lines) {
        this.var = var;
        this.value = value;
        this.condition = condition;
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
         .append(condition);
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
