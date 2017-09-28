/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.ini4j.Wini;

/**
 *
 * @author nbp184
 */
public class IniFile {
    
    private static IniFile instance = null;
    
    public final String tables;
    public final String logs;
    
    public static IniFile getInstance() {
        if(instance == null) {
            instance = new IniFile();
        }
        return instance;
    }
    
    private IniFile() {
        String running;
        try {
            running = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException ex) {
            throw new RuntimeException("Couldn't get running directory: " +ex.getMessage());
        }
        String sep = System.getProperty("file.separator");
        String t, l;
        File f = new File(running +sep +"ryansthing.ini");
        if(f.exists()) {
            try {
                Wini ini = new Wini(f);
                t = ini.get("locations", "tables");
                l = ini.get("locations", "logs");
            } catch (IOException ex) {
                t = running;
                l = running;
            }
        } else {
            t = running;
            l = running;
            try {
                f.createNewFile();
                Wini ini = new Wini(f);
                ini.put("locations", "tables", t);
                ini.put("locations", "logs", l);
                ini.store();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(!t.endsWith(sep)) {
            t += sep;
        }
        if(!l.endsWith(sep)) {
            l += sep;
        }
        tables = t;
        logs = l;
    }
    
}
