/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author nbp184
 */
public class LogCellRenderer extends JLabel implements ListCellRenderer {
    
    private static final int PADDING = 5;
    
    public LogCellRenderer() {
        this.setOpaque(true);
        this.setToolTipText(null);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        this.setBackground(Color.white);
        this.setForeground(list.getForeground());
        if(index > 0) {
            this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.gray), 
                    BorderFactory.createLineBorder(Color.white, PADDING)));
        } else {
            this.setBorder(BorderFactory.createLineBorder(Color.white, PADDING));
        }
        String line = value.toString();
        if(list.getWidth() > 0) {
            FontMetrics fm = this.getFontMetrics(this.getFont());
            String[] pieces = new String[line.length()];
            pieces[0] = line;
            int count = 1;
            while(fm.stringWidth(pieces[count-1]) > list.getWidth()-2*PADDING) {
                //remove a word from the end of last line
                int i = pieces[count-1].lastIndexOf(" ");
                String word = pieces[count-1].substring(i+1);
                pieces[count-1] = pieces[count-1].substring(0, i);
                //add that word to pieces[count]
                if(pieces[count] == null) {
                    pieces[count] = word;
                } else {
                    pieces[count] = word +" " +pieces[count];
                }
                //if pieces[count-1] is good enough now then move up
                if(fm.stringWidth(pieces[count-1]) < list.getWidth()-2*PADDING) {
                    count++;
                }
            }
            line = pieces[0];
            for(int i = 1; i < count; i++) {
                line += "<br>" +pieces[i];
            }
        }
        this.setText("<html>" +line +"</html>");
        return this;
    }
    
}
