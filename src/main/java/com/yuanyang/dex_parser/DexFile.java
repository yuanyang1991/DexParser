package com.yuanyang.dex_parser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DexFile {

    private HeaderItem headerItem;


    public static DexFile from(InputStream inputStreams) throws IOException {
        byte[] bytes = IOUtils.toByteArray(inputStreams);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer = byteBuffer.asReadOnlyBuffer();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        HeaderItem headerItem = HeaderItem.from(byteBuffer);
        return null;
    }
}
