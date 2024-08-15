package priv.ray.codex.parse;

import priv.ray.codex.enums.CodexEnum;

/**
 * @author Ray
 * @data 2024/8/15 16:35
 * @description: bcd编解码器
 */
public class BcdParser implements CodexParser<String> {
    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.BCD;
    }

    @Override
    public byte[] encode(String o) {
        return new byte[0];
    }

    @Override
    public String decode(byte[] bytes) {
        return null;
    }
}
