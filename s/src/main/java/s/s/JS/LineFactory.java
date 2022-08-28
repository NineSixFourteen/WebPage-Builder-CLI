package s.s.JS;

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

    public static Line newFor(){
        return new ForLine();
    }

    public static Line newForEach(){
        return new ForEachLine();
    }

    public static Line newIf(){
        return new IfLine();
    }

    public static Line newVarDec(){
        return new VarDecLine();
    }

    public static Line newVarChange(){
        return new VarChangeLine();
    }

    public static Line newElemChange(){
        return new ElemChange();
    }

    public static Line newStyleChange(){
        return new StylesChange();
    }
    
    public static Line newFuncCall(){
        return new FuncCall();
    }
    
}
