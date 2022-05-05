package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class ClassDefItem {

    private final int classIdx;
    private final int accessFlags;
    private final int superclassIdx;
    private final int interfacesOff;
    private final int sourceFileIdx;
    private final int annotationsOff;
    private final int classDataOff;
    private final int staticValuesOff;

    public ClassDefItem(int classIdx, int accessFlags, int superclassIdx, int interfacesOff, int sourceFileIdx, int annotationsOff, int classDataOff, int staticValuesOff) {
        this.classIdx = classIdx;
        this.accessFlags = accessFlags;
        this.superclassIdx = superclassIdx;
        this.interfacesOff = interfacesOff;
        this.sourceFileIdx = sourceFileIdx;
        this.annotationsOff = annotationsOff;
        this.classDataOff = classDataOff;
        this.staticValuesOff = staticValuesOff;
    }

    public int getClassIdx() {
        return classIdx;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public int getSuperclassIdx() {
        return superclassIdx;
    }

    public int getInterfacesOff() {
        return interfacesOff;
    }

    public int getSourceFileIdx() {
        return sourceFileIdx;
    }

    public int getAnnotationsOff() {
        return annotationsOff;
    }

    public int getClassDataOff() {
        return classDataOff;
    }

    public int getStaticValuesOff() {
        return staticValuesOff;
    }

    public static ClassDefItem from(ByteBuffer buffer) {
        return new ClassDefItem(buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt(), buffer.getInt());
    }
}
