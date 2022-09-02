package s.s.JS.Expression;

public class ValueExpr implements Expression{
    private String lhs;
    public ValueExpr(String lhs) {
        this.lhs = lhs;
    }
    @Override
    public String value() {
        return lhs ;
    }
}
