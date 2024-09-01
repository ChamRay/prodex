package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;
import priv.ray.util.ByteUtil;

/**
 * @author Ray
 * @data 2024/8/15 16:38
 * @description: long字节编解码器
 */
public class BinLonParser implements CodexParser<Long> {

    int size = Long.BYTES;

    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.LONG;
    }

    @Override
    public byte[] encode( Long aLong) {
        return ByteUtil.long2Bytes(aLong);
    }

    @Override
    public Long decode(byte[] bytes) {
        return ByteUtil.byte2Long(bytes);
    }
}
