/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import gui.MainFrame;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import org.ini4j.Wini;

/**
 *
 * @author nbp184
 */
public class MakeIniFileWindows {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException, IOException {
        String running = MainFrame.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        int i = running.indexOf("RyansThing");
        String t = running.substring(0, i+11) +"Tables/";
        String l = running.substring(0, i+11);
        File f = new File(running, "ryansthing.ini");
        if(!f.exists()) {
            f.createNewFile();
        }
        Wini ini = new Wini(f);
        ini.put("locations", "tables", t);
        ini.put("locations", "logs", l);
        ini.store();
        f = new File(l, "dist/ryansthing.ini");
        if(!f.exists()) {
            f.createNewFile();
        }
        ini = new Wini(f);
        ini.put("locations", "tables", t);
        ini.put("locations", "logs", l+"dist/");
        ini.store();
    }
    
}
