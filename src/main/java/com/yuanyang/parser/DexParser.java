package com.yuanyang.parser;

import com.yuanyang.struct.DexFile;
import com.yuanyang.struct.DexHeader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 解析Dex文件格式
 */
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
        dexFile.setDexHeader(DexHeader.parse(buffer));
        return dexFile;
    }

    private boolean isDexFile() {
        byte[] magicBytes = new byte[8];
        buffer.get(magicBytes);
        String magic = new String(magicBytes);
        return magic.startsWith(Constants.MAGIC_DEX);
    }
}
