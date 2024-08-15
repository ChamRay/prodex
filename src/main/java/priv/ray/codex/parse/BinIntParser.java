package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

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
        return new byte[0];
    }

    @Override
    public Integer decode(byte[] bytes) {
        return 0;
    }
}
