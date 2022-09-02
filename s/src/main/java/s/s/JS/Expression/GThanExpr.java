package s.s.JS.Expression;

public class GThanExpr implements Expression {
    private Expression lhs;
    private Expression rhs;

    public GThanExpr(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String value() {
        return lhs.value() + ">" + rhs.value() ;
    }
}
