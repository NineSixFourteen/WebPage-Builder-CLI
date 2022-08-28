package s.s.JS.Lines;

import java.util.ArrayList;

public class FuncCall implements Line {


    private String name;
    private ArrayList<String> values;

    public FuncCall(String name, ArrayList<String> values) {
        this.name = name;
        this.values = values;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append(name)
        .append("(");
        for(String value : values.subList(0, values.size() -1)){
            sb.append(value)
             .append(",");
        }
        sb.append(values.get(values.size() - 1))
         .append(")")
         .append(";");

    }
    
}
