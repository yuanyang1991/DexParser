package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class MapList {

    private int size;
    private MapItem[] list;

    public MapList(int size, MapItem[] list) {
        this.size = size;
        this.list = list;
    }

    public int getSize() {
        return size;
    }

    public MapItem[] getList() {
        return list;
    }

    public static MapList from(ByteBuffer buffer) {
        int size = buffer.getInt();
        MapItem[] mapItems = new MapItem[size];
        for (int i = 0; i < size; i++) {
            mapItems[i] = MapItem.from(buffer);
        }
        return new MapList(size, mapItems);
    }
}
