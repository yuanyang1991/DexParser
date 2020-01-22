package com.yuanyang;

import com.yuanyang.struct.DexFile;
import com.yuanyang.struct.DexHeader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 解析Dex文件格式
 */
public class DexParser {

    private ByteBuffer buffer;

    public DexParser(byte[] bytes) {
        buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public DexFile parse() {
        String magic = parseMagic();
        if (!magic.startsWith("dex")) {
            throw new IllegalStateException("the file is not dex file");
        }
        DexFile dexFile = new DexFile();
        DexHeader header = new DexHeader();
        header.setCheckSum(Integer.toHexString(parseCheckSum()));
        header.setFileSize(buffer.getInt());
        header.setHeaderSize(buffer.getInt());
        header.setEndingTag(Integer.toHexString(parseEndingTag()));
        header.setLinkSize(buffer.getInt());
        header.setLinkOff(buffer.getInt());
        header.setMapOff(buffer.getInt());
        header.setStringIdsSize(buffer.getInt());
        return dexFile;
    }


    private int parseEndingTag() {
        return buffer.getInt();
    }

    private String parseMagic() {
        byte[] magicBytes = new byte[8];
        buffer.get(magicBytes);
        return new String(magicBytes);
    }

    private int parseCheckSum() {
        int checkSum = buffer.getInt();
        // skip SHA1 signature
        buffer.get(new byte[20]);
        return checkSum;
    }
}
