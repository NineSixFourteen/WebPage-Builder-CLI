package s.s.CSS;

public class CSSElementBuilder {
    
    private CSSElement element;
    
    public CSSElementBuilder(String name, Type type){
        element = new CSSElement(name,type);
    }

    public CSSElementBuilder setState(State st){
        element.setState(st); 
        return this;
    }

    public CSSElementBuilder addStyle(Style sty ) {
        element.getStyles().add(sty);
        return this;
    }

    public CSSElement build(){
        return element;
    }
}
