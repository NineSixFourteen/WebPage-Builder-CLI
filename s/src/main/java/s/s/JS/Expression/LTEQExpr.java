package s.s.JS.Expression;

public class LTEQExpr implements Expression{
    private Expression lhs;
    private Expression rhs;
    public LTEQExpr(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public String value() {
        return lhs.value() + " <= " + rhs.value() ;
    }
}
