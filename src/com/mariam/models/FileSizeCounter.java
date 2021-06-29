package com.mariam.models;

import com.mariam.foldersizecounter.Test;

import java.io.File;
import java.text.DecimalFormat;

public class FileSizeCounter {
    public static long countFileSize( File folder){

        long foldersize = 0;
        File[] files = folder.listFiles();
        if(files!=null){
            for (int i=0; i < files.length; i++) {

                if (files[i].isDirectory()) {
                    foldersize += countFileSize(files[i]);
                }
                else {
                    foldersize += files[i].length();
                    Test.size+=files[i].length();
                }
            }
        }
        return foldersize;
    }
    //this 2 functions for converting are from the internet
    public static String getReadableSizeByte(long size) {
        if(size <= 0) return "0";
        final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups))
                + " " + units[digitGroups];
    }
    public static String getReadableSizeK(long size) {
        if(size <= 0) return "0";
        final String[] units = new String[] { " ","K", "M", "B", "T"};
        int digitGroups = (int) (Math.log10(size)/Math.log10(1000));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1000, digitGroups))
                + " " + units[digitGroups];
    }

}
