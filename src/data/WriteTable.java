/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author nbp184
 */
public class WriteTable {
    
    private static final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder dBuilder = null;
    
    public static void write(File file, Table[] tables) {
        if(dBuilder == null) {
            try {
                dBuilder = dbFactory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace(System.out);
                System.out.println(ex.getLocalizedMessage());
                throw new RuntimeException("ERROR");
            }
        }
        Document doc = dBuilder.newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);
        Element table, item, subitem, subsubitem;
        for(Table t : tables) {
            table = doc.createElement("table");
            item = doc.createElement("name");
            item.setTextContent(t.name);
            table.appendChild(item);
            if(t.hasItems()) {
                for(TableEntry te : t.getEntries()) {
                    item = doc.createElement("item");
                    if(te.text != null) {
                        subitem = doc.createElement("text");
                        subitem.setTextContent(te.text);
                        item.appendChild(subitem);
                    }
                    if(te.rollon != null) {
                        for(String r : te.rollon) {
                            subitem = doc.createElement("rollon");
                            subitem.setTextContent(r);
                            item.appendChild(subitem);
                        }
                    }
                    if(te.die != null) {
                        subitem = doc.createElement("dice");
                        subsubitem = doc.createElement("amount");
                        subsubitem.setTextContent(""+te.die.amount);
                        subitem.appendChild(subsubitem);
                        subsubitem = doc.createElement("sides");
                        subsubitem.setTextContent(""+te.die.sides);
                        subitem.appendChild(subsubitem);
                        subsubitem = doc.createElement("modifier");
                        subsubitem.setTextContent(""+te.die.modifier);
                        subitem.appendChild(subsubitem);
                        item.appendChild(subitem);
                    }
                    if(te.unit != null) {
                        subitem = doc.createElement("unit");
                        subitem.setTextContent(te.unit);
                        item.appendChild(subitem);
                    }
                    if(te.appears > 1) {
                        subitem = doc.createElement("appears");
                        subitem.setTextContent(""+te.appears);
                        item.appendChild(subitem);
                    }
                    table.appendChild(item);
                }
            } else {
                if(t.text != null) {
                    item = doc.createElement("text");
                    item.setTextContent(t.text);
                    table.appendChild(item);
                }
                for(String s : t.getRollon()) {
                    item = doc.createElement("rollon");
                    item.setTextContent(s);
                    table.appendChild(item);
                }
            }
            root.appendChild(table);
        }
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tr.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(file)));
        } catch (TransformerException | IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.getLocalizedMessage());
            throw new RuntimeException("ERROR");
        }
        
    }
    
}
