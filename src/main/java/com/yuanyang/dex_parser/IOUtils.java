package com.yuanyang.dex_parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int readSize = 0;
        while ((readSize = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, readSize);
        }
        inputStream.close();
        byte[] data = bos.toByteArray();
        bos.close();
        return data;
    }
}
