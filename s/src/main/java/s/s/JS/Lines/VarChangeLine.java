package s.s.JS.Lines;

public class VarChangeLine implements Line {

    String name; 
    String value;

    public VarChangeLine(String name, String value){
        this.name = name;
        this.value = name;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append(name)
        .append(" = ")
        .append(value)
        .append(";\n");
    }
}
