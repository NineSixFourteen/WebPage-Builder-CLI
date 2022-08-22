package s.s.CSS;

public class CSSPageBuilder {

    private CSSPage page; 

    public CSSPageBuilder(){
        this.page = new CSSPage();
    }

    public CSSPageBuilder addElement(CSSElement el){
        page.getElements().add(el);
        return this;
    }

    public CSSPage build(){
        return page;
    }

}
