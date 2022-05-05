package com.yuanyang.dex_parser;

import java.nio.ByteBuffer;

public class StringUtils {


    public static String decode(ByteBuffer in) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            char a = (char) (in.get() & 0xff);
            if (a == 0) {
                return sb.toString();
            }

            if (a < '\u0080') {
                sb.append(a);
            } else if ((a & 0xe0) == 0xc0) {
                int b = in.get() & 0xff;
                if ((b & 0xC0) != 0x80) {
                    throw new IllegalArgumentException("bad second byte");
                }
                sb.append((char) (((a & 0x1F) << 6) | (b & 0x3F)));
            } else if ((a & 0xf0) == 0xe0) {
                int b = in.get() & 0xff;
                int c = in.get() & 0xff;
                if (((b & 0xC0) != 0x80) || ((c & 0xC0) != 0x80)) {
                    throw new IllegalArgumentException("bad second or third byte");
                }
                sb.append((char) (((a & 0x0F) << 12) | ((b & 0x3F) << 6) | (c & 0x3F)));
            } else {
                throw new IllegalArgumentException("bad byte");
            }
        }
    }

    private static String newString(char[] chars, int realLen) {
        return new String(chars, 0, realLen);
    }

    public static String escapeString(String value) {
        int len = value.length();
        StringBuilder sb = new StringBuilder(len * 3 / 2);

        for (int i = 0; i < len; i++) {
            char c = value.charAt(i);

            if ((c >= ' ') && (c < 0x7f)) {
                if ((c == '\'') || (c == '\"') || (c == '\\')) {
                    sb.append('\\');
                }
                sb.append(c);
                continue;
            } else if (c <= 0x7f) {
                switch (c) {
                    case '\n':
                        sb.append("\\n");
                        continue;
                    case '\r':
                        sb.append("\\r");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                }
            }

            sb.append("\\u");
            sb.append(Character.forDigit(c >> 12, 16));
            sb.append(Character.forDigit((c >> 8) & 0x0f, 16));
            sb.append(Character.forDigit((c >> 4) & 0x0f, 16));
            sb.append(Character.forDigit(c & 0x0f, 16));
        }

        return sb.toString();
    }
}
