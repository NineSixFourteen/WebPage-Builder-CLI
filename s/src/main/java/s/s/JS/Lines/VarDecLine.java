package s.s.JS.Lines;

public class VarDecLine implements Line {

    String name; 
    String value;

    public VarDecLine(String name, String value){
        this.name = name;
        this.value = name;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("let")
        .append(name)
        .append(" = ")
        .append(value)
        .append(";\n");
    }
    
}
