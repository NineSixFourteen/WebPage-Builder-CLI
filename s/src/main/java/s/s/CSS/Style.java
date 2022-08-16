package s.s.CSS;

public class Style {

    private StyleType type; 
    private String value; 
    
    public Style(StyleType type, String amount){
        this.type = type;
        this.value = amount;
    }

    public StyleType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
