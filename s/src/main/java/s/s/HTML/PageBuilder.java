package s.s.HTML;

import java.util.ArrayList;

import s.s.HTML.ElementFactory.Element;

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

    public PageBuilder setTitle(String title) {
        page.setTitle(title);
        return this;
    }

    public String getTitle(){
        return page.getTitle();
    }

    public ArrayList<Element> getBody(){
        return this.page.getBody();
    }

    public PageBuilder addParagraph(String para) {
        page.append(EF.newParagraph(para));
        return this; 
    }

    public PageBuilder addTable(Table tb){
        page.append(EF.newTable(tb));
        return this;
    }

    public PageBuilder addDiv(ArrayList<Element> page2){
        page.append(EF.newDiv(page2));
        return this;
    }

    public PageBuilder addList(LList list ){
        page.append(EF.newList(list));
        return this;
    }

    public PageBuilder addHeading(String heading, int level) {
        page.append(EF.newHeading(heading));
        return this;
    }

    
    
}
