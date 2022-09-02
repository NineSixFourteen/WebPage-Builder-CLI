package s.s.JS.Expression;

public class GTEQExpr implements Expression {
    private Expression lhs;
    private Expression rhs;
    @Override
    public String value() {
        return lhs.value() + ">=" + rhs.value() ;
    }
    public GTEQExpr(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    
}
