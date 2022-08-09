package s.s.HTML;

import java.util.ArrayList;

public class ElementFactory {

    public class Element {
        private ElementID id; 
        //private String name = ""; 
        private Object msg;
    
        private Element(ElementID id, Object msg) {
            this.id = id;
            this.msg = msg;
        }

        public ElementID getId() {
            return id;
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
    }

    public ElementFactory() {
    }

    public Element newParagraph(String msg) {
        return new Element(ElementID.P, msg);
    }

    public Element newHeading(String msg) {
        return new Element(ElementID.Heading, msg);
    }

    public Element newTable(Table msg){
        return new Element(ElementID.Table, msg);
    }

    public Element newDiv(Page pg){
        return new Element(ElementID.Div, pg);
    }
}
