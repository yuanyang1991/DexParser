package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

/**
 * dex文件头，头内部各区域含义见
 * https://source.android.com/devices/tech/dalvik/dex-format#header-item
 *
 * @author yuanyang
 */
public class HeaderItem {


    private int linkSize;
    private int linkOff;
    private int mapOff;
    private int stringIdSize;
    private int stringIdSOff;
    private int typeIdSize;
    private int typeIdsOff;
    private int protoIdSize;
    private int protoIdOff;
    private int fieldIdSize;
    private int fieldIdOff;
    private int methodIdSize;
    private int methodIdOff;
    private int classDefsSize;
    private int classDefsOff;
    private int dataSize;
    private int dataOff;


    public static HeaderItem from(ByteBuffer byteBuffer) {
        // 检查magic
        byte[] magic = new byte[8];
        byteBuffer.get(magic);
        checkMagic(magic);

        // checksum
        byteBuffer.getInt(); // skip

        // signature
        byteBuffer.get(new byte[20]); // skip

        // file size
        byteBuffer.getInt(); // skip

        // header size
        byteBuffer.getInt(); // skip

        // ending
        byteBuffer.getInt(); // skip


        HeaderItem headerItem = new HeaderItem();

        headerItem.linkSize = byteBuffer.getInt();
        headerItem.linkOff = byteBuffer.getInt();

        headerItem.mapOff = byteBuffer.getInt();

        headerItem.stringIdSize = byteBuffer.getInt();
        headerItem.stringIdSOff = byteBuffer.getInt();
        headerItem.typeIdSize = byteBuffer.getInt();
        headerItem.typeIdsOff = byteBuffer.getInt();
        headerItem.protoIdSize = byteBuffer.getInt();
        headerItem.protoIdOff = byteBuffer.getInt();
        headerItem.fieldIdSize = byteBuffer.getInt();
        headerItem.fieldIdOff = byteBuffer.getInt();
        headerItem.methodIdSize = byteBuffer.getInt();
        headerItem.methodIdOff = byteBuffer.getInt();
        headerItem.classDefsSize = byteBuffer.getInt();
        headerItem.classDefsOff = byteBuffer.getInt();
        headerItem.dataSize = byteBuffer.getInt();
        headerItem.dataOff = byteBuffer.getInt();
        return headerItem;
    }

    /**
     * dex文件必须以dex开头
     *
     * @param magic
     */
    private static void checkMagic(byte[] magic) {
        String magicStr = new String(magic);
        if (!magicStr.startsWith("dex")) {
            throw new IllegalStateException("this file is not a dex file");
        }
    }


}
