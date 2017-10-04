/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Objects;

/**
 *
 * @author nbp184
 */
public class TableEntry {
    
    public String text;
    public String[] rollon;
    public Dice die;
    public String unit;
    public int appears;
    
    public TableEntry(String text, String[] rollon, Dice die, String unit) {
        this.text = text;
        this.rollon = rollon;
        this.die = die;
        this.unit = unit;
        appears = 1;
    }
    
    public TableEntry() {
        this.appears = 1;
    }

    public String getText() {
        String rv = "";
        if(text != null) {
            rv += text;
        }
        if(rollon != null) {
            if(!rv.isEmpty()) {
                rv += " ";
            }
            rv += "<" +rollon[0] +"> ";
            for(int i = 1; i < rollon.length; i++) {
                rv += " <" +rollon[i] +">";
            }
        }
        if(die != null) {
            rv += die.roll() + " ";
        }
        if(unit != null) {
            rv += unit;
        }
        return rv;
    }

    public TableEntry copy() {
        String[] rCopy = null;
        if(rollon != null) {
            rCopy= new String[rollon.length];
            System.arraycopy(rollon, 0, rCopy, 0, rollon.length);
        }
        return new TableEntry(text, rCopy, die, unit);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.text);
        hash = 83 * hash + Objects.hashCode(this.rollon);
        hash = 83 * hash + Objects.hashCode(this.die);
        hash = 83 * hash + Objects.hashCode(this.unit);
        return hash;
    }
    
    @Override
    public String toString() {
        return getText();
    }
    
}
