package s.s.HTML;

public class ElementFactory {
    
    public ElementFactory() {
    }

    public Element newParagraph(String msg) {
        return new Element(ElementID.P, msg);
    }

    public Element newHeading(String msg) {
        return new Element(ElementID.H1, msg);
    }

    public Element newTableHeading(String msg){
        return new Element(ElementID.TH, msg);
    }
}
