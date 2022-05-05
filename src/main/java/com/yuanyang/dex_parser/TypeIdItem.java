package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class TypeIdItem {

    private final int descriptorIdx;

    public TypeIdItem(int descriptorIdx) {
        this.descriptorIdx = descriptorIdx;
    }

    public static TypeIdItem from(ByteBuffer byteBuffer) {
        return new TypeIdItem(byteBuffer.getInt());
    }

    public int getDescriptorIdx() {
        return descriptorIdx;
    }
}
