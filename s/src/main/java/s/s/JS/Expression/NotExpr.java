package s.s.JS.Expression;

public class NotExpr implements Expression {
    private Expression lhs;
    public NotExpr(Expression lhs) {
        this.lhs = lhs;
    }
    @Override
    public String value() {
        return "!( " + lhs.value() + ")" ;
    }
}
