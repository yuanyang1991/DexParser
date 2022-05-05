package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class MethodIdItem {

    private final short classIdx;
    private final short protoIdx;
    private final int nameIdx;

    public MethodIdItem(short classIdx, short protoIdx, int nameIdx) {
        this.classIdx = classIdx;
        this.protoIdx = protoIdx;
        this.nameIdx = nameIdx;
    }

    public short getClassIdx() {
        return classIdx;
    }

    public short getProtoIdx() {
        return protoIdx;
    }

    public int getNameIdx() {
        return nameIdx;
    }

    public static MethodIdItem from(ByteBuffer byteBuffer) {
        return new MethodIdItem(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getInt());
    }
}


