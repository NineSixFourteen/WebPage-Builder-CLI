package s.s.JS.Expression;

public class GetIdExpr implements Expression{

    private String id; 
    public GetIdExpr(String id) {
        this.id = id;
    }
    @Override
    public String value() {
        return "document.getElementById(\"" + id + "\").innerHTML";
    }

    
}
