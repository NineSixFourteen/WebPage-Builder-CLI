package s.s.JS.Lines;

import s.s.JS.Expression.Expression;

public class VarDecLine implements Line {

    String name; 
    Expression value;

    public VarDecLine(String name, Expression value){
        this.name = name;
        this.value = value;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("let")
        .append(name)
        .append(" = ")
        .append(value.value())
        .append(";\n");
    }
    
}
