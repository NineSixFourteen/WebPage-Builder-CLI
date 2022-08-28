package s.s.JS.Lines;

public class ElemChange implements Line{

    private String elemName;
    private String newValue;  

    public ElemChange(String elemName, String newValue) {
        this.elemName = elemName;
        this.newValue = newValue;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("document.getElementById(\"")
         .append(elemName)
         .append("\".innerHTML = \"")
         .append(newValue)
         .append("\"")
         .append(";\n");
    }
    
}
