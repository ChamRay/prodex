package com.ray.codex.parse;

import com.ray.codex.coding.Coding;
import com.ray.codex.enums.CodexEnum;
import com.ray.codex.factory.CodexFactory;

public class DefaultParser implements CodexParser<Short>{


    @Override
    public byte[] encode(byte[] bytes, Short aShort, CodexEnum type) {
        Coding coding = CodexFactory.getInstance(type);

        return new byte[0];
    }

    @Override
    public Short decode(byte[] bytes, CodexEnum type) {
        return 0;
    }
}
