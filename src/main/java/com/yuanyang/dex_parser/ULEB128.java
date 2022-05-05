package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class ULEB128 {


    public static int readULEB128(ByteBuffer buffer) {
        int currentByteValue;
        int result;

        result = buffer.get() & 0xFF;
        if (result > 0x7F) { // 0x7F = 128, 10000000 = 128, 所以 > 127表明第一位肯定为1
            currentByteValue = buffer.get() & 0xFF;
            result = (result & 0x7F) + ((currentByteValue & 0x7F) << 7);
            if (currentByteValue > 0x7F) {
                currentByteValue = buffer.get() & 0xff;
                result |= (currentByteValue & 0x7f) << 14;
                if (currentByteValue > 0x7F) {
                    currentByteValue = buffer.get() & 0xff;
                    result |= (currentByteValue & 0x7f) << 21;
                    if (currentByteValue > 0x7F) {
                        currentByteValue = buffer.get() & 0xff;
                        result |= (currentByteValue & 0x7f) << 28;
                    }
                }
            }
        }
        return result;
    }


}
