package s.s.JS.Expression;

public class BracExpr implements Expression {
    private Expression lhs;

    public BracExpr(Expression lhs) {
        this.lhs = lhs;
    }

    @Override
    public String value() {
        return "(" + lhs + ")";
    }

     
    
}
