package com.yuanyang.parser;

import com.yuanyang.struct.DexFile;
import com.yuanyang.struct.DexHeader;
import com.yuanyang.struct.StringPool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class DexParser implements Parser<DexFile> {

    private ByteBuffer buffer;

    public DexParser(byte[] bytes) {
        buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override
    public DexFile parse() {
        if (!isDexFile()) {
            throw new IllegalStateException("the file you parse is not an dex file");
        }
        DexFile dexFile = new DexFile();
        DexHeader header = DexHeader.parse(buffer);
        dexFile.setHeader(header);
        StringPool pool = StringPool.parse(buffer, header.getStringIdsSize(), header.getStringIdsOff());
        dexFile.setStringPool(pool);
        return dexFile;
    }

    private boolean isDexFile() {
        byte[] magicBytes = new byte[8];
        buffer.get(magicBytes);
        String magic = new String(magicBytes);
        return magic.startsWith(Constants.MAGIC_DEX);
    }
}
