package org.ray.wrapper;

import org.ray.parse.parser.CodexParser;

public interface FieldWrapper {

    FieldWrapper setField(String field);

    FieldWrapper setFrameLength(Integer frameLength);

    FieldWrapper bindParser(CodexParser<?> parser);

    FieldWrapper isNecessary(Boolean must);

}
