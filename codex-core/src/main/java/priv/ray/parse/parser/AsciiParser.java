package priv.ray.parse.parser;

import priv.ray.parse.enums.CodexEnum;

import java.nio.charset.StandardCharsets;

/**
 * @author Ray
 * @data 2024/9/1 16:50
 * @description: ascii码转换器
 */
public class AsciiParser implements CodexParser<String> {
    @Override
    public CodexEnum getCodexType() {
        return CodexEnum.ASCII;
    }

    @Override
    public byte[] encode(String s) {
        return s.trim().getBytes(StandardCharsets.US_ASCII);
    }

    @Override
    public String decode(byte[] bytes) {
        return new String(bytes, StandardCharsets.US_ASCII).trim();
    }
}
