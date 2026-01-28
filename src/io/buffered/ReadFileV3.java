package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV3 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        BufferedInputStream bis = new BufferedInputStream(fis);
        long start = System.currentTimeMillis();

        int data;
        int fileSize = 0;
        while ((data = bis.read()) != -1) {
            fileSize++;
        }

        bis.close();
        long end = System.currentTimeMillis();

        System.out.println("File name: " + FILE_NAME);
        System.out.println("File size: " + fileSize);
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
