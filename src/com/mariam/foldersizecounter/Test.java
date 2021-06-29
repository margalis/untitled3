package com.mariam.foldersizecounter;

import com.mariam.models.FileSizeCounter;

import java.io.File;

public class Test {
    public static long size;

    public static void main(String[] args) {

        FileSizeCounter counter = new FileSizeCounter();
        Thread t = new Thread(() -> {
           String readable = FileSizeCounter
                    .getReadableSizeByte(FileSizeCounter.countFileSize(new File("C:\\Users\\User\\Desktop") ));

        });
        Thread t1 = new Thread(() -> {
            while (t.isAlive()) {

                System.out.println("Size of the folder " + FileSizeCounter.getReadableSizeByte((size)));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Size of the folder: " + FileSizeCounter.getReadableSizeByte((size)));
        });
        t1.start();
        t.start();
    }
}
