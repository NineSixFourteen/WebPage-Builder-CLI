package s.s.CSS;

public class StyleFactory {

    public static Style newMargin(int side, String value) {
        switch(side){
            // TODO Remove 0 as kinda pointless 
            case 0: 
                return new Style(StyleType.margin, value);
            case 1: 
                return new Style(StyleType.margin_top, value);
            case 2: 
                return new Style(StyleType.margin_right, value);
            case 3:     
                return new Style(StyleType.margin_bottom, value);
            case 4: 
                return new Style(StyleType.margin_left, value);
            default:
                return new Style(StyleType.margin, value);
        }
    }

    public static Style newBorder(int side, String value) {
        switch(side){
            case 0: 
                return new Style(StyleType.border, value);
            case 1: 
                return new Style(StyleType.border_top, value);
            case 2: 
                return new Style(StyleType.border_right, value);
            case 3:     
                return new Style(StyleType.border_bottom, value);
            case 4: 
                return new Style(StyleType.border_left, value);
            default:
                return new Style(StyleType.border, value);
        }
    }
    
    public static Style newBorderStyle(int side, String value) {
        switch(side){
            case 0: 
                return new Style(StyleType.border_style, value);
            case 1: 
                return new Style(StyleType.border_top_style, value);
            case 2: 
                return new Style(StyleType.border_right_style, value);
            case 3:     
                return new Style(StyleType.border_bottom_style, value);
            case 4: 
                return new Style(StyleType.border_left_style, value);
            default:
                return new Style(StyleType.border_style, value);
        }
    }

    public static Style newPadding(int side, String value) {
        switch(side){
            case 0: 
                return new Style(StyleType.padding, value);
            case 1: 
                return new Style(StyleType.padding_top, value);
            case 2: 
                return new Style(StyleType.padding_right, value);
            case 3:     
                return new Style(StyleType.padding_bottom, value);
            case 4: 
                return new Style(StyleType.padding_left, value);
            default:
                return new Style(StyleType.padding, value);
        }
    }
    
    public static Style newColour(int option, String value) {
        switch(option){
            case 0: 
                return new Style(StyleType.colour, value);
            case 1: 
                return new Style(StyleType.background_colour, value);
            default:
                return new Style(StyleType.colour, value);
        }
    }

    public static Style newSize(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.width, value);
            case 1: 
                return new Style(StyleType.height, value);
            case 2: 
                return new Style(StyleType.min_width, value);
            case 3: 
                return new Style(StyleType.min_height, value);
            case 4: 
                return new Style(StyleType.max_width, value);
            case 5: 
                return new Style(StyleType.max_height, value);
            default:
                return new Style(StyleType.width, value);
        }
    }

    public static Style newBorderOther(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.border_radius ,value);
            case 1: 
                return new Style(StyleType.border_width ,value);
            case 2: 
                return new Style(StyleType.border_colour ,value);
            default: 
                return new Style(StyleType.background_colour ,value);
        }
    }

    public static Style newOutline(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.outline, value);
            case 1: 
                return new Style(StyleType.outline_style, value);
            case 2: 
                return new Style(StyleType.outline_offset, value);
            case 3: 
                return new Style(StyleType.outline_color, value);
            case 4: 
                return new Style(StyleType.outline_width, value);
            default: 
                return new Style(StyleType.background_colour, value);
        }
    }

    public static Style newText(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.text_transform, value);
            case 1: 
                return new Style(StyleType.text_indent, value);
            case 2: 
                return new Style(StyleType.text_shadow, value);
            case 3: 
                return new Style(StyleType.text_align, value);
            default: 
                return new Style(StyleType.text_transform, value);
        }
    }

    public static Style newLetter(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.letter_spacing, value);
            case 1: 
                return new Style(StyleType.line_height, value);
            case 2: 
                return new Style(StyleType.word_spacing, value);
            case 3: 
                return new Style(StyleType.white_space, value);
            default: 
                return new Style(StyleType.letter_spacing, value);
        }
    }

    public static Style newFont(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.font_family, value);
            case 1: 
                return new Style(StyleType.font_size, value);
            case 2: 
                return new Style(StyleType.font_weight, value);
            case 3: 
                return new Style(StyleType.font_variant, value);
            default: 
                return new Style(StyleType.font_family, value);
        }
    }

    public static Style newList(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.list_style_type, value);
            case 1: 
                return new Style(StyleType.list_style_image, value);
            case 2: 
                return new Style(StyleType.list_style_position, value);
            case 3: 
                return new Style(StyleType.list_style, value);
            default: 
                return new Style(StyleType.list_style_type, value);
        }
    }

    public static Style newOther(int option, String value){
        switch(option){
            case 0: 
                return new Style(StyleType.visibility, value);
            case 1: 
                return new Style(StyleType.display, value);
            case 2: 
                return new Style(StyleType.position, value);
            case 3: 
                return new Style(StyleType.z_index, value);
            case 4: 
                return new Style(StyleType.overflow, value);
            case 5: 
                return new Style(StyleType.box_sizing, value); 
            default: 
                return new Style(StyleType.visibility, value);
        }
    }

}
