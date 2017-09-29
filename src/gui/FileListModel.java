/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import javax.swing.AbstractListModel;

/**
 *
 * @author nbp184
 */
public class FileListModel extends AbstractListModel {
    
    private final File dir;
    private final FilenameFilter filter;
    private final SimpleDateFormat sdf;
    
    public FileListModel(File dir, FilenameFilter filter) {
        this.dir = dir;
        this.filter = filter;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public int getSize() {
        return dir.list(filter).length;
    }

    @Override
    public Object getElementAt(int index) {
        File f = dir.listFiles(filter)[index];
        return f.getName() +" (" +sdf.format(new java.util.Date(f.lastModified())) +")";
    }
    
    public void removeAt(int index) {
        File f = dir.listFiles(filter)[index];
        f.delete();
        fireIntervalRemoved(this, index, index);
    }
    
    public void cleanUp(long now, long diff) {
        File[] files = dir.listFiles(filter);
        for(File f : files) {
            if(now - f.lastModified() > diff) {
                f.delete();
            }
        }
        fireIntervalRemoved(this, 0, files.length);
    }
    
}
