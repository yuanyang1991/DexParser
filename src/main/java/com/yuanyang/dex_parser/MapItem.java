package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class MapItem {

    private short type;
    private short unused;
    private int size;
    private int offset;

    public MapItem(short type, short unused, int size, int offset) {
        this.type = type;
        this.unused = unused;
        this.size = size;
        this.offset = offset;
    }

    public short getType() {
        return type;
    }

    public short getUnused() {
        return unused;
    }

    public int getSize() {
        return size;
    }

    public int getOffset() {
        return offset;
    }

    public static MapItem from(ByteBuffer buffer) {
        return new MapItem(buffer.getShort(), buffer.getShort(), buffer.getInt(), buffer.getInt());
    }
}
