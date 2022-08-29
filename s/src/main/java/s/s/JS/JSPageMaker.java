package s.s.JS;

import java.util.ArrayList;

import s.s.JS.Lines.Line;

public class JSPageMaker {

    public static String make(JSPage page){
        StringBuilder sb = new StringBuilder();
        for(Function func : page.getFunctions()){
            addFunc(sb, func);
        }
        return "";
    }

    private static void addFunc(StringBuilder sb, Function func) {
        sb.append("function ")
         .append(func.getName())
         .append("(");
        for(String value : func.params.subList(0, func.getLines().size() -1)){
            sb.append(value)
             .append(", ");
        }
        sb.append(func.params.get(func.params.size() - 1))
         .append(") {\n");
        addLines(sb, func.Lines);
        sb.append("}\n");
    }

    private static void addLines(StringBuilder sb, ArrayList<Line> lines) {
        for(Line line : lines){
            line.codeGen(sb);
        }
    }
    
}
