/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nbp184
 */
public class Table {
    
    private static final Random rand = new Random();
    
    public final String name;
    private final ArrayList<TableEntry> entries;
    
    public String text;
    private final ArrayList<String> rollon;
    
    public Table(String name) {
        this.name = name;
        entries = new ArrayList<>();
        rollon = new ArrayList<>();
    }
    
    public void addEntry(TableEntry te, int amount) {
        for(int i = 0; i < amount; i++) {
            entries.add(te);
        }
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void addRollon(String rollon) {
        this.rollon.add(rollon);
    }
    
    public String roll() {
        if(!entries.isEmpty()) {
            return entries.get(rand.nextInt(entries.size())).getText();
        } else {
            String rv = "";
            if(text != null) {
                rv += text;
            }
            for(String t : rollon) {
                if(!rv.isEmpty()) {
                    rv += " ";
                }
                rv += "<" +t +">";
            }
            return rv;
        }
    }
    
    @Override
    public String toString() {
        return name;
    }

    public boolean hasItems() {
        return !entries.isEmpty();
    }

    public TableEntry[] getEntries() {
        TableEntry[] rv = new TableEntry[entries.size()];
        entries.toArray(rv);
        return rv;
    }
    
    public String[] getRollon() {
        String[] rv = new String[rollon.size()];
        rollon.toArray(rv);
        return rv;
    }
    
}
