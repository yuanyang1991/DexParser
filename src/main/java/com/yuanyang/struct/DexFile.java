package com.yuanyang.struct;

public class DexFile {

    private DexHeader header;
    private StringPool stringPool;
    private Types types;

    public void setHeader(DexHeader header) {
        this.header = header;
    }


    public void setStringPool(StringPool pool) {
        this.stringPool = pool;
    }

    public void setTypes(Types types) {
        this.types = types;
    }
}
