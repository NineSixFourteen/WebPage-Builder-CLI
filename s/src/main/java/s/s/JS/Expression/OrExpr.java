package s.s.JS.Expression;

public class OrExpr implements Expression {
    public OrExpr(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    private Expression lhs;
    private Expression rhs;
    @Override
    public String value() {
        return lhs.value() + " || " + rhs.value() ;
    }
    
}
