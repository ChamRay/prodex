package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

/**
 * @author Ray
 * @data 2024/8/15 16:36
 * @description: short字节编解码器
 */

public class BinShortParser implements CodexParser<Short> {
    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.SHORT;
    }

    @Override
    public byte[] encode(byte[] bytes, Short aShort, CodexEnum type) {
        return new byte[0];
    }

    @Override
    public Short decode(byte[] bytes, CodexEnum type) {
        return 0;
    }
}
