package s.s.JS;

public class FunctionBuilder {

    Function func;
    

    public FunctionBuilder(){
        func = new Function();
    }

    public FunctionBuilder addFor(){
        func.getLines().add(LineFactory.newFor());
        return this;
    }

    public FunctionBuilder addForEach(){
        func.getLines().add(LineFactory.newFuncCall());
        return this;
    }

    public FunctionBuilder addIf(){
        func.getLines().add(LineFactory.newIf());
        return this;
    }

    public FunctionBuilder addVarDec(){
        func.getLines().add(LineFactory.newVarDec());
        return this;
    }
    
    public FunctionBuilder addVarChange(){
        func.getLines().add(LineFactory.newVarChange());
        return this;
    }

    public FunctionBuilder addElemChange(){
        func.getLines().add(LineFactory.newElemChange());
        return this;
    }

    public FunctionBuilder addStyleChange(){
        func.getLines().add(LineFactory.newStyleChange());
        return this;
    }
    
    public FunctionBuilder addFuncCall(){
        func.getLines().add(LineFactory.newFuncCall());
        return this;
    }
    
}
