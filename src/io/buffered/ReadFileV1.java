package io.buffered;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);

        int data;
        int fileSize = 0;
        while ((data = fis.read()) != -1) {
            fileSize++;
        }
        fis.close();

        System.out.println("File name: " + FILE_NAME);
        System.out.println("File size: " + fileSize);
    }
}
