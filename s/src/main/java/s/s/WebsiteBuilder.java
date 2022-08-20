package s.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import s.s.HTML.ElementFactory.Element;
import s.s.CSS.CSSElement;
import s.s.CSS.CSSPageBuilder;
import s.s.HTML.LList;
import s.s.HTML.PageBuilder;
import s.s.HTML.Table;

public class WebsiteBuilder {
    //fields
    private PageBuilder pb; 
    private CSSPageBuilder cpb; 
    private Set<String> ids; 
    private List<String> elems;
    private Set<String> classes; 

    //constructors
    public WebsiteBuilder(){
        pb = new PageBuilder();
        cpb = new CSSPageBuilder();
        this.ids = new HashSet<>();
        this.classes = new HashSet<>();
        this.elems = Arrays.asList("P","H1","H2","H3","H4","H5","H6","Table");
    }

    //getters 
    public Set<String> getClasses() {
        return classes;
    }
    public List<String> getElems() {
        return elems;
    }
    public Set<String> getIds() {
        return ids;
    }
    public CSSPageBuilder getCpb() {
        return cpb;
    }
    public PageBuilder getPb() {
        return pb;
    }

    //To add a html element and store info about id, classes
    public WebsiteBuilder addParagraph(String para, String id, String classs){
        pb.addParagraph(para, id, classs);
        ids.add(id);
        classes.add(classs);
        return this;
    }


    public WebsiteBuilder addTable(Table tb, String id, String classs){
        pb.addTable(tb, id, classs);
        ids.add(id);
        classes.add(classs);
        return this;
    }

    public WebsiteBuilder addDiv(ArrayList<Element> page2, String id, String classs){
        pb.addDiv(page2, id, classs);
        ids.add(id);
        classes.add(classs);
        return this;
    }

    public WebsiteBuilder addList(LList list, String id, String classs){
        pb.addList(list, id, classs);
        ids.add(id);
        classes.add(classs);
        return this;
    }

    public WebsiteBuilder addHeading(String heading, int level, String id, String classs){
        pb.addHeading(heading, level, id, classs);
        ids.add(id);
        classes.add(classs);
        return this;
    }

    public WebsiteBuilder addElem(CSSElement elem){
        this.cpb.addElement(elem);
        return this;
    }
    


}
