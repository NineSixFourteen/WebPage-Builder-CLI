package s.s.HTML;

import java.util.ArrayList;

import s.s.HTML.ElementFactory.Element;

public class Page {

    private String Title;
    private ArrayList<Element> body; 
    
    public Page() {
        Title = "No Title";
        body = new ArrayList<>(); 
       } 

    public ArrayList<Element> getBody() {
        return body;
    }


    public void swap(int ind, Element elem){
        this.body.set(ind, elem);
    } 

    public Page setTitle(String title) {
        Title = title;
        return this;
    }

    public String getTitle() {
        return Title;
    }

    public Page append(Element s){
        body.add(s);
        return this;
    }
}
