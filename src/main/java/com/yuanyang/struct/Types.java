package com.yuanyang.struct;

import java.nio.ByteBuffer;

public class Types {

    private String[] types;

    public static Types parse(ByteBuffer buffer, int typesSize, int typesIdOffset, StringPool pool) {
        String[] array = new String[typesSize];
        for (int i = 0; i < typesSize; i++) {
            buffer.position(typesIdOffset);
            typesIdOffset += 4;
            long index = buffer.getInt();
            array[i] = pool.get((int) index);
        }
        Types types = new Types();
        types.types = array;
        return types;
    }
}
