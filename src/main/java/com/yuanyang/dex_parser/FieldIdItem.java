package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

/**
 * 属性
 */
public class FieldIdItem {

    private final short classIdx;
    private final short typeIdx;
    private final int nameIdx;

    public FieldIdItem(short classIdx, short typeIdx, int nameIdx) {
        this.classIdx = classIdx;
        this.typeIdx = typeIdx;
        this.nameIdx = nameIdx;
    }

    public short getClassIdx() {
        return classIdx;
    }

    public short getTypeIdx() {
        return typeIdx;
    }

    public int getNameIdx() {
        return nameIdx;
    }

    public static FieldIdItem from(ByteBuffer buffer) {
        return new FieldIdItem(buffer.getShort(), buffer.getShort(), buffer.getInt());
    }
}
