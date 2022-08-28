package s.s.JS;

public class JSPageBuilder {

    private JSPage page; 

    public JSPageBuilder(JSPage page){
        this.page = page;
    }

    public JSPageBuilder addFunction(Function func){
        page.getFunctions().add(func);
        return this;
    }

    public JSPage Build(){
        return page;
    }
    
}
