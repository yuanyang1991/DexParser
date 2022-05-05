package com.yuanyang.dex_parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntUnaryOperator;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("C:/Users/wps/Downloads/classes.dex");
        DexFile dexFile = DexFile.from(inputStream);

    }
}
