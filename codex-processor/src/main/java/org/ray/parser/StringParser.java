package org.ray.parser;


import java.nio.charset.StandardCharsets;

public class StringParser implements CodexParser<String>{

    @Override
    public byte[] encode(String s) {
        return s.trim().getBytes(StandardCharsets.US_ASCII);
    }

    @Override
    public String decode(byte[] bytes) {
        return new String(bytes,StandardCharsets.US_ASCII);
    }
}
