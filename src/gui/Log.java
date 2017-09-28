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
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author nbp184
 */
public class Log {
    
    private static final String newLine = System.getProperty("line.separator");
    
    private final JTextArea txtLog;
    private final File file;
    
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
    
    public Log(JTextArea txtLog) {
        this.txtLog = txtLog;
        file = new File(IniFile.getInstance().logs +"log-" +getToday() +"-" +getRandom() +".txt");
    }
    
    public Log(JTextArea txtLog, File file) {
        this.txtLog = txtLog;
        this.file = file;
        String text = "";
        try {
            BufferedReader fileIn = new BufferedReader(new FileReader(file));
            String line = fileIn.readLine();
            while(line != null) {
                if(!text.isEmpty()) {
                    text += "\n";
                }
                text += line;
                line = fileIn.readLine();
            }
            fileIn.close();
        } catch(IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error reading log.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        txtLog.setText(text);
    }
    
    public String getLabel() {
        return "Log: " +file.getName();
    }
    
    public void addText(String text) {
        if(txtLog.getText().isEmpty()) {
            txtLog.setText(text);
        } else {
            txtLog.setText(txtLog.getText() +"\n" +text);
        }
        save();
    }
    
    public void save() {
         try {
            PrintWriter outFile = new PrintWriter(file);
            outFile.println(getFixedText());
            outFile.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println(ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error saving log.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getFixedText() {
        return txtLog.getText().replace("\n", newLine);
    }
           
}
