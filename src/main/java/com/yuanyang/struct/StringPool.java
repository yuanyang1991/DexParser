package com.yuanyang.struct;


import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * strings in dex file
 */
public class StringPool {

    private StringEntry[] pool;

    public StringEntry[] getPool() {
        return pool;
    }

    public String get(int index) {
        return pool[index].data;
    }

    /**
     * 1. get string offset
     * 2. move to offset
     * 3. get string length
     * 4. constructor string
     *
     * @param buffer          data
     * @param stringSize      size of string
     * @param stringIdsOffset string id offset
     */
    public static StringPool parse(ByteBuffer buffer, int stringSize, int stringIdsOffset) {
        StringEntry[] entries = new StringEntry[stringSize];
        StringEntry entry;
        for (int i = 0; i < stringSize; i++) {
            buffer.position(stringIdsOffset);
            stringIdsOffset += 4;
            int stringOffset = buffer.getInt();
            entry = StringEntry.parse(buffer, stringOffset);
            entries[i] = entry;
        }
        StringPool pool = new StringPool();
        pool.pool = entries;
        return pool;
    }

    @Override
    public String toString() {
        return "StringPool{" +
                "pool=" + Arrays.toString(pool) +
                '}';
    }

    /**
     * string items in dex file
     */
    static class StringEntry {
        private String data;

        private int offset;

        public String getData() {
            return data;
        }

        public int getOffset() {
            return offset;
        }

        @Override
        public String toString() {
            return "StringEntry{" +
                    "data='" + data + '\'' +
                    '}';
        }

        /**
         * 1. move to offset
         * 2. read string length
         * 3. get string value
         */
        private static StringEntry parse(ByteBuffer buffer, int offset) {
            StringEntry entry = new StringEntry();
            buffer.position(offset);
            byte b = buffer.get();
            int stringLength = b & 0xFF;// byte to unsigned int
            byte[] dst = new byte[stringLength];
            buffer.get(dst);
            entry.data = new String(dst);
            entry.offset = ++offset;
            return entry;
        }
    }

}
