package s.s.JS;

public class JSPageBuilder {

    private JSPage page; 

    public JSPageBuilder(){
        this.page = new JSPage();
    }

    public JSPageBuilder addFunction(Function func){
        page.getFunctions().add(func);
        return this;
    }

    public JSPage Build(){
        return page;
    }
    
}
