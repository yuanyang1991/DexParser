package com.yuanyang.struct;

public class DexFile {

    private DexHeader header;
    private StringPool stringPool;

    public void setHeader(DexHeader header) {
        this.header = header;
    }


    public void setStringPool(StringPool pool) {
        this.stringPool = pool;
    }
}
