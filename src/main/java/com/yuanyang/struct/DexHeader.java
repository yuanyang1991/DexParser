package com.yuanyang.struct;


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
}
