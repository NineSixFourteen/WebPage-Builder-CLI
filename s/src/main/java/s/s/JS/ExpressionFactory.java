package s.s.JS;

import s.s.JS.Expression.AddExpr;
import s.s.JS.Expression.AndExpr;
import s.s.JS.Expression.BracExpr;
import s.s.JS.Expression.DivExpr;
import s.s.JS.Expression.Expression;
import s.s.JS.Expression.GTEQExpr;
import s.s.JS.Expression.GThanExpr;
import s.s.JS.Expression.LTEQExpr;
import s.s.JS.Expression.LThanExpr;
import s.s.JS.Expression.MulExpr;
import s.s.JS.Expression.NotExpr;
import s.s.JS.Expression.OrExpr;
import s.s.JS.Expression.SubExpr;
import s.s.JS.Expression.ValueExpr;

public class ExpressionFactory {

    //Boolean Expr - Level 1
    public Expression newNot(Expression exp){
        return new NotExpr(exp);
    }
    public Expression newAnd(Expression lhs, Expression rhs ){
        return new AndExpr(lhs, rhs);
    }
    public Expression newOr(Expression lhs, Expression rhs ){
        return new OrExpr(lhs, rhs);
    }
    //Boolean Expr - Level 2
    public Expression newGT(Expression lhs, Expression rhs){
        return new GThanExpr(lhs, rhs);
    }
    public Expression newGTEQ(Expression lhs, Expression rhs){
        return new GTEQExpr(lhs, rhs);
    }
    public Expression newLT(Expression lhs, Expression rhs){
        return new LThanExpr(lhs, rhs);
    }
    public Expression newLTEQ(Expression lhs, Expression rhs){
        return new LTEQExpr(lhs, rhs);
    }
    // Other 
    public Expression newBrac(Expression exp){
        return new BracExpr(exp);
    }
    public Expression newValue(String value){
        return new ValueExpr(value);
    }
    //Binary Expr
    public Expression newAdd(Expression lhs, Expression rhs){
        return new AddExpr(lhs, rhs);
    }
    public Expression newSub(Expression lhs, Expression rhs){
        return new SubExpr(lhs, rhs);
    }
    public Expression newMul(Expression lhs, Expression rhs){
        return new MulExpr(lhs, rhs);
    }
    public Expression newDiv(Expression lhs, Expression rhs){
        return new DivExpr(lhs, rhs);
    }

    
}
