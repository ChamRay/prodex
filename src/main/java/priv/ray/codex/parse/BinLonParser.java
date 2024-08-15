package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

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
        return new byte[0];
    }

    @Override
    public Long decode(byte[] bytes) {
        return 0L;
    }
}
