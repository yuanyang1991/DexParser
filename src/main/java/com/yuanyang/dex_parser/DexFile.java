package com.yuanyang.dex_parser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DexFile {

    private HeaderItem headerItem;
    private StringIdItem[] stringIds;
    private TypeIdItem[] typeIds;
    private ProtoIdItem[] protoIdItems;
    private FieldIdItem[] fieldIdItems;
    private MethodIdItem[] methodIdItems;
    private ClassDefItem[] classDefItems;
    private int[] callSiteItems;
    private byte[] data;
    private MapList mapList;
    private StringDataItem[] stringDataItems;


    public static DexFile from(InputStream inputStreams) throws IOException {
        DexFile dexFile = new DexFile();
        byte[] bytes = IOUtils.toByteArray(inputStreams);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer = byteBuffer.asReadOnlyBuffer();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        HeaderItem headerItem = HeaderItem.from(byteBuffer);
        dexFile.headerItem = headerItem;

        int pos = byteBuffer.position();
        int dataOff = headerItem.getDataOff();
        int dataSize = headerItem.getDataSize();
        byte[] data = new byte[dataSize];
        byteBuffer.position(dataOff);
        byteBuffer.get(data);
        dexFile.data = data;
        byteBuffer.position(pos);

        int stringIdSize = headerItem.getStringIdSize();
        StringIdItem[] stringIdItems = new StringIdItem[headerItem.getStringIdSize()];
        for (int i = 0; i < stringIdSize; i++) {
            stringIdItems[i] = StringIdItem.from(byteBuffer);
        }
        dexFile.stringIds = stringIdItems;

        int typeIdSize = headerItem.getTypeIdSize();
        TypeIdItem[] typeIdItems = new TypeIdItem[typeIdSize];
        for (int i = 0; i < typeIdSize; i++) {
            typeIdItems[i] = TypeIdItem.from(byteBuffer);
        }
        dexFile.typeIds = typeIdItems;

        int protoIdSize = headerItem.getProtoIdSize();
        ProtoIdItem[] protoIdItems = new ProtoIdItem[protoIdSize];
        for (int i = 0; i < protoIdSize; i++) {
            protoIdItems[i] = ProtoIdItem.from(byteBuffer);
        }
        dexFile.protoIdItems = protoIdItems;

        int fieldIdSize = headerItem.getFieldIdSize();
        FieldIdItem[] fieldIdItems = new FieldIdItem[fieldIdSize];
        for (int i = 0; i < fieldIdSize; i++) {
            fieldIdItems[i] = FieldIdItem.from(byteBuffer);
        }
        dexFile.fieldIdItems = fieldIdItems;


        int methodSize = headerItem.getMethodIdSize();
        MethodIdItem[] methodIdItems = new MethodIdItem[methodSize];
        for (int i = 0; i < methodSize; i++) {
            methodIdItems[i] = MethodIdItem.from(byteBuffer);
        }
        dexFile.methodIdItems = methodIdItems;

        int classSize = headerItem.getClassDefsSize();
        ClassDefItem[] classDefItems = new ClassDefItem[classSize];
        for (int i = 0; i < classSize; i++) {
            classDefItems[i] = ClassDefItem.from(byteBuffer);
        }
        dexFile.classDefItems = classDefItems;

        int mapOff = headerItem.getMapOff();
        dexFile.mapList = MapListFactory.createMapList(byteBuffer, mapOff);

        int originPos = byteBuffer.position();
        int stringDataSize = stringIdItems.length;
        StringDataItem[] stringDataItems = new StringDataItem[stringDataSize];
        for (int i = 0; i < stringDataSize; i++) {
            byteBuffer.position(stringIdItems[i].getStringDataOff()); // 先移动到此位置
            stringDataItems[i] = StringDataItem.from(byteBuffer);
        }
        byteBuffer.position(originPos);
        dexFile.stringDataItems = stringDataItems;
        return null;
    }
}
