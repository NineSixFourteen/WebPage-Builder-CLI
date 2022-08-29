package s.s.JS;

import java.util.ArrayList;

import s.s.JS.Lines.Line;

public class FunctionBuilder {

    Function func;
    
    public FunctionBuilder(String name){
        func = new Function(name);
    }

    public FunctionBuilder addParam(String name){
        func.getParams().add(name);
        return this;
    }

    public FunctionBuilder changeName(String newName){
        func.setName(newName);
        return this;
    }

    public FunctionBuilder addFor(String var, String value, String condition, Line oLine, ArrayList<Line> lines){
        func.getLines().add(LineFactory.newFor(var, value, condition, oLine, lines));
        return this;
    }

    public FunctionBuilder addForEach(String itemName, String listName, ArrayList<Line> lines){
        func.getLines().add(LineFactory.newForEach(itemName, listName, lines));
        return this;
    }

    public FunctionBuilder addIf(String condition, ArrayList<Line> lines){
        func.getLines().add(LineFactory.newIf(condition, lines));
        return this;
    }

    public FunctionBuilder addVarDec(String name, String value){
        func.getLines().add(LineFactory.newVarDec(name, value));
        return this;
    }
    
    public FunctionBuilder addVarChange(String name,String value){
        func.getLines().add(LineFactory.newVarChange(name, value));
        return this;
    }

    public FunctionBuilder addElemChange(String elemName, String newValue){
        func.getLines().add(LineFactory.newElemChange(elemName, newValue));
        return this;
    }

    public FunctionBuilder addStyleChange(String elemName, String style, String newValue){
        func.getLines().add(LineFactory.newStyleChange(elemName, style, newValue));
        return this;
    }
    
    public FunctionBuilder addFuncCall(String name , ArrayList<String> values){
        func.getLines().add(LineFactory.newFuncCall(name, values));
        return this;
    }

    public Function Build(){
        return func;
    }
    
}
