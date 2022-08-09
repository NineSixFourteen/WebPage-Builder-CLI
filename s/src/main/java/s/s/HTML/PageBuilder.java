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
        page.append("<p> ")
        .append(para)
        .append(" </p>");
        return this; 
    }

    public PageBuilder addTable(Table tb){
        page.append("<Table>");
        for(String th : tb.getTitles()){
            page.append(EF.newTableHeading(th).toString());
        }
        page.append("</Table>");
        return this;
    }

    
    
}
