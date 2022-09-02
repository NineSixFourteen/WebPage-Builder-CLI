package s.s.JS.Lines;

import s.s.JS.Expression.Expression;

public class VarChangeLine implements Line {

    String name; 
    Expression value;

    public VarChangeLine(String name, Expression value){
        this.name = name;
        this.value = value;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append(name)
        .append(" = ")
        .append(value.value())
        .append(";\n");
    }
}
