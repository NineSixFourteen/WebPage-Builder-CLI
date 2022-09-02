package s.s.JS.Expression;

public class DivExpr implements Expression {
    private Expression lhs;
    private Expression rhs;
    public DivExpr(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public String value() {
        return lhs.value() + " / " + rhs.value() ;
    }
}
