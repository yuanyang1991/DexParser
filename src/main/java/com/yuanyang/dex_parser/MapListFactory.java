package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class MapListFactory {

    public static MapList createMapList(ByteBuffer buffer, int mapListOff) {
        int pos = buffer.position();
        buffer.position(mapListOff);
        MapList mapList = MapList.from(buffer);
        buffer.position(pos);
        return mapList;
    }
}
