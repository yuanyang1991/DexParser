package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

/**
 * String在data区中的位置
 */
public class StringIdItem {

    private int stringDataOff;

    public StringIdItem(int stringDataOff) {
        this.stringDataOff = stringDataOff;
    }

    public static StringIdItem from(ByteBuffer byteBuffer) {
        return new StringIdItem(byteBuffer.getInt());
    }

    public int getStringDataOff() {
        return stringDataOff;
    }
}
