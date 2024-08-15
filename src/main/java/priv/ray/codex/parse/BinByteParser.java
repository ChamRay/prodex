package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

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
        return new byte[0];
    }

    @Override
    public Byte decode(byte[] bytes) {
        return 0;
    }
}
