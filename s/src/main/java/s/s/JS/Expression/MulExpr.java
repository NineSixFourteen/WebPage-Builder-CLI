package s.s.JS.Expression;

public class MulExpr implements Expression{
    private Expression lhs;
    private Expression rhs;
    public MulExpr(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public String value() {
        return lhs.value() + " * " + rhs.value() ;
    }
    
}
