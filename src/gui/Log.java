/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nbp184
 */
public class Log extends AbstractListModel {
    
    public static String getToday() {
        Calendar today = Calendar.getInstance();
        String rv = "" +today.get((Calendar.YEAR));
        if(today.get(Calendar.MONTH) < 10) {
            rv += "0";
        }
        rv += today.get(Calendar.MONTH);
        if(today.get(Calendar.DAY_OF_MONTH) < 10) {
            rv += "0";
        }
        rv += today.get(Calendar.DAY_OF_MONTH);
        if(today.get(Calendar.HOUR_OF_DAY) < 10) {
            rv += "0";
        }
        rv += today.get(Calendar.HOUR_OF_DAY);
        if(today.get(Calendar.MINUTE) < 10) {
            rv += "0";
        }
        rv += today.get(Calendar.MINUTE);
        return rv;
    }
    
    public static String getRandom() {
        String rv = "";
        for(int i = 0; i < 3; i++) {
            rv += (int)(Math.random()*10);
        }
        return rv;
    }
    
    private final ArrayList<String> data;
    private final File file;
    
    public Log() {
        data = new ArrayList<>();
        file = new File(IniFile.getInstance().logs +"log-" +getToday() +"-" +getRandom() +".txt");
    }
    
    public Log(File file) {
        data = new ArrayList<>();
        this.file = file;
        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(file));
            String line = fileIn.readLine();
            while(line != null) {
                data.add(line);
                line = fileIn.readLine();
            }
            fileIn.close();
        } catch(IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error reading log.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String getLabel() {
        return "Log: " +file.getName();
    }
    
    public void addText(String text) {
        data.add(text);
        this.fireIntervalAdded(this, data.size()-1, data.size());
        save();
    }
    
    public void save() {
        if(!data.isEmpty()) {
            try {
                PrintWriter outFile = new PrintWriter(file);
                for(String s : data) {
                    outFile.println(s);
                }
                outFile.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                System.out.println(ex.getLocalizedMessage());
                JOptionPane.showMessageDialog(null, "Error saving log.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getFilename() {
        return file.getName();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public String getElementAt(int index) {
        return data.get(index);
    }
           
}
