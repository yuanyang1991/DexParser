package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class StringDataItem {

    private int size;

    private String string;

    public StringDataItem(int size, String string) {
        this.size = size;
        this.string = string;
    }

    public int getSize() {
        return size;
    }

    public String getString() {
        return string;
    }

    public static StringDataItem from(ByteBuffer buffer) {
        int size = ULEB128.readULEB128(buffer);
        String value = StringUtils.decode(buffer);
        return new StringDataItem(size, value);
    }
}
