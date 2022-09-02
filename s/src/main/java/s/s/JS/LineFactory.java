package s.s.JS;


import java.util.ArrayList;

import s.s.JS.Expression.Expression;
import s.s.JS.Lines.ElemChange;
import s.s.JS.Lines.ForEachLine;
import s.s.JS.Lines.ForLine;
import s.s.JS.Lines.FuncCall;
import s.s.JS.Lines.IfLine;
import s.s.JS.Lines.Line;
import s.s.JS.Lines.StylesChange;
import s.s.JS.Lines.VarChangeLine;
import s.s.JS.Lines.VarDecLine;

public class LineFactory {

    public static Line newFor(String var, String value, Expression condition, Line oLine, ArrayList<Line> lines){
        return new ForLine(var, value, condition, oLine, lines);
    }

    public static Line newForEach(String itemName, String listName, ArrayList<Line> lines){
        return new ForEachLine(itemName, listName, lines);
    }

    public static Line newIf(Expression Condition, ArrayList<Line> lines){
        return new IfLine(Condition, lines);
    }

    public static Line newVarDec(String name, String value){
        return new VarDecLine(name, value);
    }

    public static Line newVarChange(String name, String value ){
        return new VarChangeLine(name, value);
    }

    public static Line newElemChange(String elemName, String newValue){
        return new ElemChange(elemName, newValue);
    }

    public static Line newStyleChange(String elemName, String style, String newValue){
        return new StylesChange(elemName, style, newValue);
    }
    
    public static Line newFuncCall(String name, ArrayList<String> values){
        return new FuncCall(name, values);
    }
    
}
