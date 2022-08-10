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

    public PageBuilder addParagraph(String para, String id, String classs){
        page.append(EF.newParagraph(para, id, classs));
        return this;
    }

    public PageBuilder addTable(Table tb){
        page.append(EF.newTable(tb));
        return this;
    }

    public PageBuilder addTable(Table tb, String id, String classs){
        page.append(EF.newTable(tb, id, classs));
        return this;
    }

    public PageBuilder addDiv(ArrayList<Element> page2){
        page.append(EF.newDiv(page2));
        return this;
    }

    public PageBuilder addDiv(ArrayList<Element> page2, String id, String classs){
        page.append(EF.newDiv(page2, id, classs));
        return this;
    }

    public PageBuilder addList(LList list ){
        page.append(EF.newList(list));
        return this;
    }

    public PageBuilder addList(LList list, String id, String classs){
        page.append(EF.newList(list, id, classs));
        return this;
    }

    public PageBuilder addHeading(String heading, int level) {
        page.append(EF.newHeading(heading));
        return this;
    }

    public PageBuilder addHeading(String heading, int level, String id, String classs){
        page.append(EF.newHeading(heading, id, classs));
        return this;
    }

    
    
}
