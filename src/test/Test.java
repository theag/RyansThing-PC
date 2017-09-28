/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.ReadTable;
import data.Table;
import gui.IniFile;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author nbp184
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Table> tables = new ArrayList<>();
        File dir = new File(IniFile.getInstance().tables);
        File[] files = dir.listFiles();
        if(files != null) {
            for(File file : files) {
                ReadTable.read(file, tables);
            }
        }
        Table trap = null;/*
        for(Table t : tables) {
            if(t.name.compareTo("Trap Object") == 0) {
                trap = t;
                break;
            }
        }
        if(trap == null) {
            System.out.println("null");
            System.exit(0);
        }
        String result = trap.entries.get(9).getText();
        while(result.contains("<")) {
            System.out.println("  " +result);
            int i1 = result.indexOf("<");
            int i2 = result.indexOf(">");
            String tName = result.substring(i1+1, i2);
            boolean foundTable = false;
            for(Table o : tables) {
                if(o.name.compareTo(tName) == 0) {
                    result = result.substring(0, i1) +o.roll() +result.substring(i2+1);
                    foundTable = true;
                    break;
                }
            }
            if(!foundTable) {
                System.out.println("Can't find table \"" +tName +"\".");
                result = result.replace("<" +tName +">", "(" +tName +")");
            }
        }
        System.out.println(result);*/
    }
    
}
