package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;
import priv.ray.util.ByteUtil;

/**
 * @author Ray
 * @data 2024/8/15 16:33
 * @description: 字节解析器
 */
public class BinByteParser implements CodexParser<Byte> {
    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.BYTE;
    }

    @Override
    public byte[] encode(Byte aByte) {
        return new byte[]{aByte.byteValue()};
    }

    @Override
    public Byte decode(byte[] bytes) {
        return new Byte(bytes[0]);
    }
}
