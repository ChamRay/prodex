package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;
import priv.ray.util.ByteUtil;

/**
 * @author Ray
 * @data 2024/8/15 16:36
 * @description: short字节编解码器
 */

public class BinShortParser implements CodexParser<Short> {


    int size = Short.BYTES;

    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.SHORT;
    }

    @Override
    public byte[] encode(Short aShort) {
        return ByteUtil.short2Byte(aShort);
    }

    @Override
    public Short decode(byte[] bytes) {
        return ByteUtil.byte2Short(bytes);
    }
}
