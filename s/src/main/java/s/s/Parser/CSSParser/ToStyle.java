package s.s.Parser.CSSParser;

import org.apache.commons.lang.StringEscapeUtils;

import s.s.CSS.Style;
import s.s.CSS.StyleType;

public class ToStyle {

    public static Style makeStyle(String style){
        String[] parts = style.split(":");
        System.out.println(StringEscapeUtils.escapeJava(parts[0]
        .replace("-", "_")
        .replace("color", "colour")
        .toLowerCase()
        .replace(" ", "")
        .replace("\n", "")));
        StyleType type = StyleType.valueOf(parts[0]
            .replace("-", "_")
            .replace("color", "colour")
            .toLowerCase()
            .replace(" ", "")
            .replace("\n", ""));
        return new Style(type, parts[1]);
    }
    
}
