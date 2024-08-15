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
    public byte[] encode(byte[] bytes, String o, CodexEnum type) {
        return new byte[0];
    }

    @Override
    public String decode(byte[] bytes, CodexEnum type) {
        return null;
    }
}
