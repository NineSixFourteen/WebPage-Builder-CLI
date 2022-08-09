package s.s.HTML;

public class PageBuilder {

    private Page page;
    private ElementFactory EF; 

    public PageBuilder() {
        page = new Page();
        EF = new ElementFactory();
    }

    public Page Build() {
        return page;
    }

    public PageBuilder addParagraph(String para) {
        page.append(EF.newParagraph(para));
        return this; 
    }

    public PageBuilder addTable(Table tb){
        page.append(EF.newTable(tb));
        return this;
    }

    public PageBuilder addDiv(Page page){
        page.append(EF.newDiv(page));
        return this;
    }

    
    
}
