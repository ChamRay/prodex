package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;
import priv.ray.util.ByteUtil;

/**
 * @author Ray
 * @data 2024/8/15 16:37
 * @description: int字节编解码器
 */
public class BinIntParser implements CodexParser<Integer> {
    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.INT;
    }

    @Override
    public byte[] encode(Integer integer) {
        return ByteUtil.int2Bytes(integer);
    }

    @Override
    public Integer decode(byte[] bytes) {
        return ByteUtil.bytes2Int(bytes);
    }
}
