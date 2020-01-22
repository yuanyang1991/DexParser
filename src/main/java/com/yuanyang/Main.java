package com.yuanyang;

import com.yuanyang.parser.DexParser;
import com.yuanyang.struct.DexFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {


    public static void main(String[] args) {
        InputStream inputStream = Main.class.getResourceAsStream("/classes.dex");
        if (inputStream == null) {
            throw new NullPointerException("resource not found");
        }
        byte[] buffer = new byte[4 * 1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = -1;
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byteArrayOutputStream.flush();
            DexParser parser = new DexParser(byteArrayOutputStream.toByteArray());
            DexFile dexFile = parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
