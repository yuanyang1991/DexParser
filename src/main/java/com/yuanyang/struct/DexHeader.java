package com.yuanyang.struct;


import java.nio.ByteBuffer;

/**
 * DexFile Header
 *
 * @author yuany
 */
public class DexHeader {

    private String checkSum;
    private int fileSize;
    private int headerSize;
    private String endingTag;
    private int linkSize;
    private int linkOff;
    private int mapOff;
    private int stringIdsSize;
    private int stringIdsOff;
    private int typeIdsSize;
    private int typeIdsOff;
    private int protoIdsSize;
    private int protoIdsOff;
    private int fieldIdsSize;
    private int fieldIdsOff;
    private int methodIdsSize;
    private int methodIdsOff;
    private int classDefsSize;
    private int classDefsOff;
    private int dataSize;
    private int dataOff;

    public static DexHeader parse(ByteBuffer buffer) {
        DexHeader header = new DexHeader();
        header.setCheckSum(Integer.toHexString(parseCheckSum(buffer)));
        header.setFileSize(buffer.getInt());
        header.setHeaderSize(buffer.getInt());
        header.setEndingTag(Integer.toHexString(buffer.getInt()));
        header.setLinkSize(buffer.getInt());
        header.setLinkOff(buffer.getInt());
        header.setMapOff(buffer.getInt());
        header.setStringIdsSize(buffer.getInt());
        header.setStringIdsOff(buffer.getInt());
        header.setTypeIdsSize(buffer.getInt());
        header.setTypeIdsOff(buffer.getInt());
        header.setProtoIdsSize(buffer.getInt());
        header.setProtoIdsOff(buffer.getInt());
        header.setFieldIdsSize(buffer.getInt());
        header.setFieldIdsOff(buffer.getInt());
        header.setMethodIdsSize(buffer.getInt());
        header.setMethodIdsOff(buffer.getInt());
        header.setClassDefsSize(buffer.getInt());
        header.setClassDefsOff(buffer.getInt());
        header.setDataSize(buffer.getInt());
        header.setDataOff(buffer.getInt());
        return header;
    }

    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public void setHeaderSize(int headerSize) {
        this.headerSize = headerSize;
    }

    public void setEndingTag(String endingTag) {
        this.endingTag = endingTag;
    }

    public void setLinkSize(int linkSize) {
        this.linkSize = linkSize;
    }

    public void setLinkOff(int linkOff) {
        this.linkOff = linkOff;
    }

    public void setMapOff(int mapOff) {
        this.mapOff = mapOff;
    }

    public void setStringIdsSize(int stringIdsSize) {
        this.stringIdsSize = stringIdsSize;
    }

    public void setStringIdsOff(int stringIdsOff) {
        this.stringIdsOff = stringIdsOff;
    }

    public void setTypeIdsSize(int typeIdsSize) {
        this.typeIdsSize = typeIdsSize;
    }

    public void setTypeIdsOff(int typeIdsOff) {
        this.typeIdsOff = typeIdsOff;
    }

    public void setProtoIdsSize(int protoIdsSize) {
        this.protoIdsSize = protoIdsSize;
    }

    public void setProtoIdsOff(int protoIdsOff) {
        this.protoIdsOff = protoIdsOff;
    }

    public void setFieldIdsSize(int fieldIdsSize) {
        this.fieldIdsSize = fieldIdsSize;
    }

    public void setFieldIdsOff(int fieldIdsOff) {
        this.fieldIdsOff = fieldIdsOff;
    }

    public void setMethodIdsSize(int methodIdsSize) {
        this.methodIdsSize = methodIdsSize;
    }

    public void setMethodIdsOff(int methodIdsOff) {
        this.methodIdsOff = methodIdsOff;
    }

    public void setClassDefsSize(int classDefsSize) {
        this.classDefsSize = classDefsSize;
    }

    public void setClassDefsOff(int classDefsOff) {
        this.classDefsOff = classDefsOff;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public void setDataOff(int dataOff) {
        this.dataOff = dataOff;
    }


    public String getCheckSum() {
        return checkSum;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public String getEndingTag() {
        return endingTag;
    }

    public int getLinkSize() {
        return linkSize;
    }

    public int getLinkOff() {
        return linkOff;
    }

    public int getMapOff() {
        return mapOff;
    }

    public int getStringIdsSize() {
        return stringIdsSize;
    }

    public int getStringIdsOff() {
        return stringIdsOff;
    }

    public int getTypeIdsSize() {
        return typeIdsSize;
    }

    public int getTypeIdsOff() {
        return typeIdsOff;
    }

    public int getProtoIdsSize() {
        return protoIdsSize;
    }

    public int getProtoIdsOff() {
        return protoIdsOff;
    }

    public int getFieldIdsSize() {
        return fieldIdsSize;
    }

    public int getFieldIdsOff() {
        return fieldIdsOff;
    }

    public int getMethodIdsSize() {
        return methodIdsSize;
    }

    public int getMethodIdsOff() {
        return methodIdsOff;
    }

    public int getClassDefsSize() {
        return classDefsSize;
    }

    public int getClassDefsOff() {
        return classDefsOff;
    }

    public int getDataSize() {
        return dataSize;
    }

    public int getDataOff() {
        return dataOff;
    }

    private static int parseCheckSum(ByteBuffer buffer) {
        int checkSum = buffer.getInt();
        // skip SHA1 signature
        buffer.get(new byte[20]);
        return checkSum;
    }

    @Override
    public String toString() {
        return "DexHeader{" + '\n' +
                "checkSum='" + checkSum + '\n' +
                "fileSize=" + fileSize + '\n' +
                "headerSize=" + headerSize + '\n' +
                "endingTag=" + endingTag + '\n' +
                "linkSize=" + linkSize + '\n' +
                "linkOff=" + linkOff + '\n' +
                "mapOff=" + mapOff + '\n' +
                "stringIdsSize=" + stringIdsSize + '\n' +
                "stringIdsOff=" + stringIdsOff + '\n' +
                "typeIdsSize=" + typeIdsSize + '\n' +
                "typeIdsOff=" + typeIdsOff + '\n' +
                "protoIdsSize=" + protoIdsSize + '\n' +
                "protoIdsOff=" + protoIdsOff + '\n' +
                "fieldIdsSize=" + fieldIdsSize + '\n' +
                "fieldIdsOff=" + fieldIdsOff + '\n' +
                "methodIdsSize=" + methodIdsSize + '\n' +
                "methodIdsOff=" + methodIdsOff + '\n' +
                "classDefsSize=" + classDefsSize + '\n' +
                "classDefsOff=" + classDefsOff + '\n' +
                "dataSize=" + dataSize + '\n' +
                "dataOff=" + dataOff + '\n' +
                '}';
    }
}
