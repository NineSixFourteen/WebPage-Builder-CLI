package s.s.JS.Lines;

public class StylesChange implements Line{


    private String elemName;
    private String style; 
    private String newValue;  

    public StylesChange(String elemName, String style,String newValue) {
        this.elemName = elemName;
        this.style = style;
        this.newValue = newValue;
    }

    @Override
    public void codeGen(StringBuilder sb) {
        sb.append("document.getElementById(\"")
         .append(elemName)
         .append("\".style")
         .append(style)
         .append(" = \"")
         .append(newValue)
         .append("\"")
         .append(";\n");
    }
    
}
