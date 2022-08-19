package s.s.HTML;

import java.util.ArrayList;

public class ElementFactory {

    public class Element {
        private ElementID type; 
        private String classs = ""; 
        private String id = "";
        private Object msg;
    
        private Element(ElementID type, Object msg, String classs, String id){
            this.type = type;
            this.msg = msg;
            this.classs = classs;
            this.id = id; 
        }

        public String getClasss() {
            return classs;
        }
        public ElementID getType() {
            return type;
        }
        public String getId() {
            return id;
        }
        public Heading getHeading(){
            return (Heading) this.msg;
        }
        public String getString(){
            return (String) this.msg;
        }
        @SuppressWarnings("unchecked")
        public ArrayList<Element> getElements(){
            return (ArrayList<Element>) this.msg;
        }
        public Table getTable(){
            return (Table) this.msg;
        }
        public LList getList(){
            return (LList) this.msg;
        }
    }
    public ElementFactory() {
    }
    public Element newParagraph(String msg, String id, String classs){
        return new Element(ElementID.P, msg, id, classs);
    }
    public Element newHeading(String msg, int level, String id, String classs){
        return new Element(ElementID.Heading, new Heading(level, msg), id, classs);
    }
    public Element newTable(Table msg, String id, String classs){
        return new Element(ElementID.Table, msg, id, classs);
    }
    public Element newDiv(ArrayList<Element> pg, String id, String classs){
        return new Element(ElementID.Div, pg, id, classs);
    }
    public Element newList(LList list, String id, String classs){
        return new Element(ElementID.List, list, id, classs);
    }
}
