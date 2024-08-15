package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

/**
 * @author Ray
 * @data 2024/8/15 16:38
 * @description: long字节编解码器
 */
public class BinLonParser implements CodexParser<Long> {
    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.LONG;
    }

    @Override
    public byte[] encode(byte[] bytes, Long aLong, CodexEnum type) {
        return new byte[0];
    }

    @Override
    public Long decode(byte[] bytes, CodexEnum type) {
        return 0L;
    }
}
