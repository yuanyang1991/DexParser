package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class ProtoIdItem {

    private final int shortyIdx;
    private final int returnTypeIdx;
    private final int parametersOff;

    public ProtoIdItem(int shortyIdx, int returnTypeIdx, int parametersOff) {
        this.shortyIdx = shortyIdx;
        this.returnTypeIdx = returnTypeIdx;
        this.parametersOff = parametersOff;
    }

    public static ProtoIdItem from(ByteBuffer byteBuffer) {
        return new ProtoIdItem(byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
    }
}
