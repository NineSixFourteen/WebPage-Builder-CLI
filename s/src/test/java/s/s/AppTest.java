package s.s;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import s.s.HTML.ListBuilder;
import s.s.HTML.Page;
import s.s.HTML.PageBuilder;
import s.s.HTML.TableBuilder;

/**
 * Unit test for bad App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void examplePage()
    {
        TableBuilder tb = new TableBuilder(2, 3);
        PageBuilder pb = new PageBuilder();
        Page p = pb
         .setTitle("Noice")
         .addParagraph("Hello world","","")
         .addTable(
            tb
             .setTitle(0, "Ding")
             .setTitle(1, "Dong")
             .setTitle(2, "Bong")
             .setRow(0, new String[]{"1","2","3"})
             .setRow(1, new String[]{"3","4","5"})
             .build()
        ,"","").addDiv(
            new PageBuilder()
            .addParagraph("Goodbye World!","","")
            .addParagraph("LMAO","","")
            .getBody(),"","" 
        ).addList(
          new ListBuilder(0)
           .addElems(new String[]{"init","nini","bili"})
           .Build(),"",""
        ).addList(
          new ListBuilder(2)
           .addElems(new String[]{"Book","has words","man","has pepe"})
           .Build(),"",""
        ).Build();
        assertEquals(
            p.toString(), 
            new StringBuilder()
             .append("<p> Hello world </p>\n")
             .append("<table>\n")
             .append("  <tr>\n")
             .append("    <th>Ding</th>\n")
             .append("    <th>Dong</th>\n")
             .append("    <th>Bong</th>\n")
             .append("  </tr>\n")
             .append("  <tr>\n")
             .append("    <td>1</td>\n")
             .append("    <td>2</td>\n")
             .append("    <td>3</td>\n")
             .append("  </tr>\n")
             .append("  <tr>\n")
             .append("    <td>3</td>\n")
             .append("    <td>4</td>\n")
             .append("    <td>5</td>\n")
             .append("  </tr>\n")
             .append("</table>\n")
             .append("<div>\n")
             .append("  <p> Goodbye World! </p>\n")
             .append("  <p> LMAO </p>\n")
             .append("</div>\n")
             .append("<ul>\n")
             .append("  <li>init </li>\n")
             .append("  <li>nini </li>\n")
             .append("  <li>bili </li>\n")
             .append("</ul>\n")
             .append("<dl>\n")
             .append("  <dt>Book </dt>\n")
             .append("  <dd>has words </dd>\n")
             .append("  <dt>man </dt>\n")
             .append("  <dd>has pepe </dd>\n")
             .append("</dl>\n")
             .toString()
        );
    }
}
